package com.gemcoder.system.job;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 萤石云设备自动更新
 * 
 * @author jiang
 *
 */
@Component
@EnableScheduling
public class EZVIZCameraJob {
	private static final Logger log = LoggerFactory.getLogger(EZVIZCameraJob.class);
	static final String tokenURL = "https://open.ys7.com/api/lapp/token/get";
	// 设备列表
	static final String deviceListURL = "https://open.ys7.com/api/lapp/device/list";
	// 相机列表（通道列表）
	static final String cameraListURL = "https://open.ys7.com/api/lapp/device/camera/list";
	// 直播url
	static final String liveListURL = "https://open.ys7.com/api/lapp/v2/live/address/get";
	// 萤石开放平台凭证，请通过环境变量注入，切勿将真实密钥写入代码
	// 参考：EZVIZ_ACCESS_TOKEN / EZVIZ_APP_KEY / EZVIZ_APP_SECRET
	static String accessToken = System.getenv().getOrDefault("EZVIZ_ACCESS_TOKEN", "");
	static final String appKey = System.getenv().getOrDefault("EZVIZ_APP_KEY", "");
	static final String secret = System.getenv().getOrDefault("EZVIZ_APP_SECRET", "");
	@Value("${ezviz.url.update:true}")
	boolean cameraUpdate;
	List<Map<String, Object>> resultList = new ArrayList<>();
	Map<String, Integer> yardname2idMap = new HashMap<>();
	Map<String, Integer> shortyardname2idMap = new HashMap<>();

	@Scheduled(cron = "0 */5 6-22 * * ?")
	public void refreshCameras() {
		try {
			log.info("EZVIZCameraJob start");
			//if (!cameraUpdate) {
				// return;
			//}
			_refreshCameras();
		} catch (Exception e) {
			log.warn(e.toString(), e);
		}
		try {
			loadYards();
			_savetoDB();
		} catch (Exception e) {
			log.warn(e.toString(), e);
		}
	}

	public void _refreshCameras() {
		// 获取 token
		// 先获取设备列表
		// 再获取channel列表
		// 再获取视频流地址
		loadToken();
		resultList.clear();
		{
			// 第一步获取设备列表
			boolean pageEnd = false;
			for (int page = 0; page < 100 && !pageEnd; ++page) {
				String result = null;
				{
					Map<String, String> map = new HashMap<>();
					map.put("accessToken", accessToken);
					map.put("pageStart", Integer.toString(page));
					map.put("pageSize", "50");
					StringBuilder paramsBuilder = new StringBuilder();
					for (String key : map.keySet()) {
						paramsBuilder.append(key + "=" + map.get(key) + "&");
					}
					result = postAndGet(deviceListURL, paramsBuilder.toString());
					log.info(result);
				}

				if (result == null) {
					log.warn("获取数据失败：{}", deviceListURL);
					return;
				}
				JSONObject resultJSON = (JSONObject) JSONObject.parse(result);
				JSONArray ja = (JSONArray) resultJSON.get("data");
				if (ja.size() < 50) {
					log.info("total page:{}", page + 1);
					pageEnd = true;
				}
				// 第二部遍历设备，再获取设备全部通道
				HashSet<String> deviceSerialSets = new HashSet<>();
				for (int index = 0; index < ja.size(); ++index) {
					try {
						JSONObject oneDevice = (JSONObject) ja.get(index);
						String deviceSerial = oneDevice.getString("deviceSerial");
						String netAddress = oneDevice.getString("netAddress");
						if (deviceSerialSets.contains(deviceSerial)) {
							// 重复的设备，跳过不予处理
							continue;
						}
						deviceSerialSets.add(deviceSerial);

						String cameraResult = null;
						{
							Map<String, String> cameramap = new HashMap<>();
							cameramap.put("accessToken", accessToken);
							cameramap.put("deviceSerial", deviceSerial);
							// cameramap.put("pageStart", "0");
							// cameramap.put("pageSize", "50");
							StringBuilder cameraparamsBuilder = new StringBuilder();
							for (String key : cameramap.keySet()) {
								cameraparamsBuilder.append(key + "=" + cameramap.get(key) + "&");
							}
							cameraResult = postAndGet(cameraListURL, cameraparamsBuilder.toString());
						}

						if (cameraResult == null) {
							log.warn("获取数据失败：{},{}", cameraListURL, deviceSerial);
							continue;
						}
						JSONObject camresultJSON = (JSONObject) JSONObject.parse(cameraResult);
						log.info(cameraResult);
						JSONArray camja = (JSONArray) camresultJSON.get("data");

						// 遍历相机通道获取播放地址
						for (int jdex = 0; jdex < camja.size(); ++jdex) {

							JSONObject oneCamera = (JSONObject) camja.get(jdex);
							Integer channelNo = oneCamera.getInteger("channelNo");
							String localName = oneCamera.getString("localName");
							String channelName = oneCamera.getString("channelName");
							String deviceName = oneCamera.getString("deviceName");
							Integer status = oneCamera.getInteger("status");
							// "deviceName": "重庆路桥下",
							// "localName": "重庆路桥下空间停车场",
							// "channelName": "视频1@DS-7832N-R2(B)(K75602269)",

							// 遍历通道，获取播放url

							String liveResult = null;
							{
								Map<String, String> livemap = new HashMap<>();
								livemap.put("accessToken", accessToken);// 用户访问令牌
								livemap.put("deviceSerial", deviceSerial);// 设备序列号,存在英文字母的设备序列号，字母需为大写
								livemap.put("channelNo", Integer.toString(channelNo));// 通道号，普通摄像头默认为1
								livemap.put("protocol", "2");// 1-ezopen、2-hls、3-rtmp
								livemap.put("type", "1");// 1-预览，2-本地录像回放，3-云存储录像回放
								StringBuilder liveparamsBuilder = new StringBuilder();
								for (String key : livemap.keySet()) {
									liveparamsBuilder.append(key + "=" + livemap.get(key) + "&");
								}
								liveResult = postAndGet(liveListURL, liveparamsBuilder.toString());

								JSONObject liveJSON = (JSONObject) JSONObject.parse(liveResult);
								JSONObject livedata = (JSONObject) liveJSON.get("data");
								String url = livedata.getString("url");
								String expireTime=livedata.getString("expireTime");
								// saveData(deviceSerial,channelNo,localName,channelName,url);
								Map<String, Object> rmap = new HashMap<>();
								rmap.put("deviceSerial", deviceSerial);
								rmap.put("channelNo", channelNo);
								rmap.put("localName", localName);
								rmap.put("deviceName", deviceName);
								rmap.put("channelName", channelName);
								rmap.put("expireTime", expireTime);
								rmap.put("netAddress", netAddress);
								rmap.put("status", status==1?"在线":"离线");

								rmap.put("url", url);
								resultList.add(rmap);
							}

						}
					} catch (Exception e) {
						log.warn(e.toString(), e);
					}
				}
			}

		}

	}

	private void _savetoDB() {
		if (resultList.isEmpty()) {
			return;
		}
		List<Map<String, Object>> maxidList = executeSQL("select max(id) as maxid from camera_equipment");
		Integer maxid = null;
		if (maxidList != null && !maxidList.isEmpty() && maxidList.get(0).get("maxid") != null) {
			maxid = Integer.parseInt(maxidList.get(0).get("maxid").toString());
		}
		resultList.forEach(rmap -> {
			// log.info("$$$${},{},{},{}",deviceSerial,channelNo,localName,url);
			saveData(rmap);
		});
		if (maxid != null) {
			executeSQL("delete from camera_equipment where id<=?", maxid);
		}
	}

	private void saveData(Map<String, Object> map) {
		// TODO Auto-generated method stub
		// log.info("#####{},{},{},{}",deviceSerial,channelNo,localName,url);
		Object deviceSerial = map.get("deviceSerial");
		Object channelNo = map.get("channelNo");
		String localName = (String) map.get("localName");
		String url = (String) map.get("url");
		String deviceName = (String) map.get("deviceName");
		String channelName = (String) map.get("channelName");
		String expireTime = (String) map.get("expireTime");
		String netAddress = (String) map.get("netAddress");
		String status = (String) map.get("status");
		if (channelName == null) {
			log.info("channelName is null,{},{},{}", deviceSerial, deviceName, localName);
			return;
		}
		String yardName = channelName.split("[-]")[0];
		Integer yardid = yardname2idMap.get(yardName);
		if (yardid == null) {
			yardid = yardname2idMap.get(localName);
			if (yardid == null) {
				yardid = yardname2idMap.get(deviceName);
				if (yardid == null) {
					String shortdeviceName = deviceName.length() > 4 ? deviceName.substring(0, 4) : deviceName;
					yardid = shortyardname2idMap.get(shortdeviceName);
				}
			}
		}
		if (yardid == null) {
			log.info("not find yard,{},{},{},{}", deviceSerial, deviceName, localName, channelName);
			return;
		}
		List<Object> params = new ArrayList<>();
		// params.add(parkingLotCode);
		// StringUtils.isEmpty(params)
		params.add(deviceSerial);// cam_id
		params.add(deviceName);// cam_name
		// params.add(localName);// address
		params.add(channelName);// address
		params.add(url);// url

		params.add(yardid);// parking_lot_info_id
		params.add(new Date());// create_time
		params.add(new Date());// update_time
		params.add(status);// status
		params.add(accessToken);// access_token
		params.add(deviceSerial);// device_serial
		params.add(channelNo);// channel
		params.add(expireTime);// expireTime
		params.add(netAddress);// expireTime
		executeSQL(
				"insert into camera_equipment (cam_id,cam_name,address,url,parking_lot_info_id,create_time,update_time,status,access_token,device_serial,channel,expire_time,cam_ip) values(?,?,?,?,?,?,?,?,?,?,?,?,?)",
				params.toArray());

	}

	private void loadToken() {
		try {
			Map<String, String> livemap = new HashMap<>();
			livemap.put("appKey", appKey);
			livemap.put("appSecret", secret);
			StringBuilder liveparamsBuilder = new StringBuilder();
			for (String key : livemap.keySet()) {
				liveparamsBuilder.append(key + "=" + livemap.get(key) + "&");
			}
			String result = postAndGet(tokenURL, liveparamsBuilder.toString());
			log.info(result);
			JSONObject camresultJSON = (JSONObject) JSONObject.parse(result);
			JSONObject camja = (JSONObject) camresultJSON.get("data");
			String at = camja.getString("accessToken");
			if (at != null) {
				accessToken = at;
			}
		} catch (Exception e) {
			log.warn(e.toString(), e);
		}

	}

	/**
	 * 加载停车场数据
	 */
	private void loadYards() {
		List<Map<String, Object>> yardlist = executeSQL("select id,parking_lot_name from parking_lot_info");
		if (yardlist == null || yardlist.isEmpty()) {
			return;
		}
		yardname2idMap.clear();
		shortyardname2idMap.clear();
		yardlist.forEach(m -> {
			Integer yardId = (Integer) m.get("id");
			String parking_lot_name = (String) m.get("parking_lot_name");
			if (parking_lot_name != null) {
				yardname2idMap.put(parking_lot_name, yardId);
				shortyardname2idMap.put(
						parking_lot_name.length() > 4 ? parking_lot_name.substring(0, 4) : parking_lot_name, yardId);
			}
		});
	}

	private String postAndGet(String url, String formData) {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpPost post = new HttpPost(url);
			StringEntity entity = new StringEntity(formData, ContentType.APPLICATION_FORM_URLENCODED);
			post.setEntity(entity);

			try (CloseableHttpResponse response = httpClient.execute(post)) {
				log.info(response.getStatusLine().toString());
				String text = EntityUtils.toString(response.getEntity(), "utf-8");
				log.info(text);
				return text;
			}
		} catch (Exception e) {
			log.error(e.toString(), e);
			return null;
		}
	}

	public static void main(String[] args) {
		EZVIZCameraJob eZVIZCameraJob = new EZVIZCameraJob();
		eZVIZCameraJob.refreshCameras();
	}
}
/**
 * { "msg": "Operation succeeded", "code": "200", "data": [ { "id":
 * "cff2d39fa0824c25b027d644dd340c47FD0783905", "deviceSerial": "FD0783905",
 * "deviceName": "青山路西", "deviceType": "DS-7608N-E2-V3", "status": 1, "defence":
 * 0, "deviceVersion": "V4.76.015 build 240125", "addTime": 1718007284097,
 * "updateTime": 1731462046000, "parentCategory": "COMMON", "riskLevel": 0,
 * "netAddress": "36.113.119.96" }, { "id":
 * "cff2d39fa0824c25b027d644dd340c47FE7485704", "deviceSerial": "FE7485704",
 * "deviceName": "青山路东", "deviceType": "DS-7604N-E1-V3", "status": 1, "defence":
 * 0, "deviceVersion": "V4.76.015 build 240125", "addTime": 1718002389543,
 * "updateTime": 1731411383000, "parentCategory": "COMMON", "riskLevel": 0,
 * "netAddress": "36.113.70.17" }, { "id":
 * "cff2d39fa0824c25b027d644dd340c47K75602269", "deviceSerial": "K75602269",
 * "deviceName": "重庆路桥下", "deviceType": "DS-7832N-R2(B)", "status": 1,
 * "defence": 0, "deviceVersion": "V4.74.000 build 230217", "addTime":
 * 1670134623348, "updateTime": 1731069005000, "parentCategory": "COMMON",
 * "riskLevel": 0, "netAddress": "36.113.38.23" } ], "page": { "total": 3,
 * "size": 10, "page": 0 } }
 */
