package com.gemcoder.system.ws;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.config.MinIOConfig;

public class CameraWebSocketHandler extends TextWebSocketHandler implements Callable {
	private static final Logger log = LoggerFactory.getLogger(CameraWebSocketHandler.class);

	// private ConcurrentHashMap<String, ExtendSession> sessionMap = new
	// ConcurrentHashMap<>();
	private SessionCacheManager sessionCacheManager;
	private NewRegisterCmdCacheManager newRegisterCmdCacheManager;
	private ConcurrentHashMap<String, String> sessionId2CameraIdMap = new ConcurrentHashMap<>();
	ExecutorService es = java.util.concurrent.Executors.newSingleThreadExecutor();
	ExecutorService updateOneLineStatusES = java.util.concurrent.Executors.newSingleThreadExecutor();
	
	public static final List<String> rcvCache = new ArrayList<>();
	
	//static ExecutorService esUploadPic = java.util.concurrent.Executors.newSingleThreadExecutor();
	// TODO websocket 客户端软件

	public CameraWebSocketHandler() {
		sessionCacheManager = SessionCacheManager.getInstance();
		newRegisterCmdCacheManager=NewRegisterCmdCacheManager.getInstance();
		es.submit(this);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 处理接收到的消息
		// System.out.println("收到消息：" + session.getId());
		String payload = message.getPayload();
		rcvCache.add(payload);
		if (rcvCache.size() > 20) {
			rcvCache.remove(0);
		}
		log.info(payload);
		decode(session, payload);

		/**
		 * 更新时间，判断是否在线
		 */
		final String camid=sessionId2CameraIdMap.get(session.getId());
		if(camid!=null) {
			updateOneLineStatusES.submit(new Runnable() {
				@Override
				public void run() {
					try {
						executeSQL("update barrier_gate_equipment set update_time=?",new Date());
					}catch(Throwable t) {
					}
				}
				
			});
		}
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 连接建立后的操作
		log.info("新连接建立：" + session.getId());
		session.setTextMessageSizeLimit(24 * 1024 * 1024); // 设置为24MB
		session.setBinaryMessageSizeLimit(24 * 1024 * 1024); // 设置为24MB
		// 可以在这里发送欢迎消息或者其他初始化操作
		// session.sendMessage(new TextMessage("欢迎连接到服务器！"));
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// 连接关闭后的操作
		log.info("连接关闭：" + session.getId() + ", 状态：" + closeStatus);
		// 可以在这里进行资源清理或者记录日志
		sessionCacheManager.forEach((k, v) -> {
			if (v.getWebSocketSession().equals(session)) {
				sessionCacheManager.remove(k);
				sessionId2CameraIdMap.remove(session.getId());
			}
		});
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// 处理传输错误
		log.warn("传输错误：" + session.getId() + ", 异常：" + exception.getMessage());
		// 可以在这里进行错误处理或者记录日志
	}

	// 其他方法可以根据需要重写，例如：
	// afterConnectionEstablished, afterConnectionClosed, handleTransportError 等
	@Override
	public Object call() throws Exception {
		sendCmds();
		return null;
	}

	/**
	 * 从缓存中读取，然后发送命令
	 */
	private void sendCmds() {
		CmdCachemanager instance = CmdCachemanager.getInstance();
		while (true) {
			Command cmd = instance.getCmd();
			if (cmd == null) {
				continue;
			}
			if (cmd.isBroadcast()) {
				broadcast(cmd);
			}
			String camId = cmd.getCameraId();

			ExtendSession session = findSession(camId);
			if (session == null) {
				log.warn("没有找到对应的session:{}", camId);
			}
			sendMsg(session, cmd);
		}
	}

	/**
	 * 发送消息
	 * 
	 * @param camId
	 * @param session
	 * @param cmd
	 */
	private void sendMsg(ExtendSession session, Command cmd) {
		// TODO Auto-generated method stub
		sendContent(session, cmd.getContent());
	}

	private void sendContent(ExtendSession session, String content) {
		// TODO Auto-generated method stub
		try {
			log.info("发送消息:{}", content);
			session.getWebSocketSession().sendMessage(new TextMessage(content));
		} catch (IOException e) {
			log.info("发送消息失败session:camid->{},IP->{}", session.getCam_id(),
					session.getWebSocketSession().getRemoteAddress());
			log.warn(e.toString(), e);
		}
	}

	private void sendContent(WebSocketSession session, String content) {
		// TODO Auto-generated method stub
		try {
			log.info("发送消息:{}", content);
			session.sendMessage(new TextMessage(content));
		} catch (IOException e) {
			log.info("发送消息失败session:IP->{}", session.getRemoteAddress());
			log.warn(e.toString(), e);
		}
	}

	private ExtendSession findSession(String camId) {
		// TODO Auto-generated method stub
		return sessionCacheManager.get(camId);
	}

	private void broadcast(Command cmd) {
		// TODO Auto-generated method stub
		sessionCacheManager.forEach((k, v) -> {
			sendMsg(v, cmd);
		});
	}

	private void decode(WebSocketSession session, String payload) {
		// TODO Auto-generated method stub
		JSONObject json = null;

		try {
			json = (JSONObject) JSONObject.parse(payload);
		} catch (Exception e) {
			log.info("错误的消息:{}", payload);
			log.warn(e.toString(), e);
		}
		if (json == null) {
			log.info("消息为空:{}", payload);
			return;
		}
		try {
			_decode(session, json);
		} catch (Exception e) {
			log.warn(e.toString(), e);
		}

	}

	private void _decode(WebSocketSession session, JSONObject json) throws Exception {
		String cmd = json.getString("cmd");
		if (cmd == null) {
			return;
		}
		if (cmd.equals("devreg")) {
			// 注册消息
			register_cmd(session, json);
		} else if (cmd.equals("heartbeat")) {
			heartbeat_cmd(session, json);
		} else if (cmd.equals("result")) {
			result_cmd(session, json);
		} else if (cmd.equals("ioinput")) {
			ioinput_cmd(session, json);
		} else if (cmd.equals("rs485input")) {
			rs485input_cmd(session, json);
		} else if (cmd.equals("encrypt_verify")) {
			encrypt_verify_cmd(session, json);
		} else if (cmd.equals("cap_report")) {
			cap_report_cmd(session, json);
		} else if (cmd.equals("turnback_start_event")) {
			turnback_start_event_cmd(session, json);
		} else if (cmd.equals("turnback_end_event")) {
			turnback_end_event_cmd(session, json);
		} else if (cmd.equals("still_start_event")) {
			still_start_event_cmd(session, json);
		} else if (cmd.equals("still_end_event")) {
			still_end_event_cmd(session, json);
		} else if (cmd.endsWith("_rsp")) {
			// 指令下发后的应答消息
			handleResponse(session, json);
		} else {
			// 未知的消息
			log.info("消息不能识别:{}", json);
		}

	}

	/**
	 * 处理应答消息
	 * 
	 * @param session
	 * @param json
	 */
	private void handleResponse(WebSocketSession session, JSONObject json) {
		// TODO Auto-generated method stub
		String cmd = json.getString("cmd");
		if ("getioinput_rsp".equals(cmd)) {
			// 获取IO状态响应
			// log.info(cmd);
		}
	}

	/**
	 * 注册消息
	 * 
	 * @param session
	 * @param json
	 * @throws Exception
	 */
	private void register_cmd(WebSocketSession session, JSONObject json) throws Exception {
		newRegisterCmdCacheManager.add(json.toJSONString());
		String msg_id = json.getString("msg_id");
		String cam_id = json.getString("cam_id");
		String park_id = json.getString("park_id");
		String cam_ip = json.getString("cam_ip");
		ExtendSession old = sessionCacheManager.remove(cam_id);
		if (old != null) {
			try {
				old.getWebSocketSession().close();
			} catch (IOException e) {
				log.warn(cam_id, e);
			}
		}
		ExtendSession extendSession = new ExtendSession(session, cam_ip, park_id, cam_id, msg_id);
		sessionCacheManager.put(cam_id, extendSession);
		sessionId2CameraIdMap.put(session.getId(), cam_id);
		// 响应消息
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		JSONObject response = new JSONObject();
		response.put("cmd", "devreg_rsp");
		response.put("msg_id", msg_id);
		String token = generateToken(32);

		extendSession.setToken(token);
		response.put("token", token);
		response.put("status", "ok");
		response.put("mode", 4);
		response.put("local_time", sdf.format(new Date()));
		sendContent(extendSession, response.toJSONString());
	}

	private void heartbeat_cmd(WebSocketSession session, JSONObject json) throws Exception {
		JSONObject response = new JSONObject();
		response.put("cmd", "heartbeat_rsp");
		response.put("msg_id", json.getString("msg_id"));
		response.put("status", "ok");
		response.put("utc_ts", Instant.now().getEpochSecond());
		sendContent(session, response.toJSONString());
	}

	/**
	 * 结果上报
	 * 
	 * @param session
	 * @param json
	 * @throws IOException
	 */
	private void result_cmd(WebSocketSession session, JSONObject json) throws IOException {
		// TODO Auto-generated method stub
		// 先应答，再处理
		 String jsonStr=json.toJSONString();
		{
			JSONObject response = new JSONObject();
			response.put("cmd", "result_rsp");
			response.put("msg_id", json.getString("msg_id"));
			response.put("status", "ok");
			session.sendMessage(new TextMessage(response.toJSONString()));
		}

		String inout = json.getString("inout");
		// 记录数据，计算费用，开启道闸
		String cameraId=null;
		if ("in".equals(inout)) {
			// 进入停车场
			 cameraId = sessionId2CameraIdMap.get(session.getId());
			 JSONObject cloneJson=(JSONObject) JSONObject.parse(jsonStr);
			VehicleRecord vehicleRecord = new VehicleRecord(true, cameraId, cloneJson);
			VehicleInCacheManager.getInstance().addInYardRecord(vehicleRecord);
			CapMatchServcie.newCapPictureLog(vehicleRecord);
		} else if ("out".equals(inout)) {
			// 出停车场
			// handleOutYardResult(session, json);
			// boolean inYard, String cam_id, JSONObject msgBody
			 cameraId = sessionId2CameraIdMap.get(session.getId());
			 JSONObject cloneJson=(JSONObject) JSONObject.parse(jsonStr);
			VehicleRecord vehicleRecord = new VehicleRecord(false, cameraId, cloneJson);
			VehicleInCacheManager.getInstance().addOutYardRecord(vehicleRecord);
			//CapMatchServcie.newCapPictureOut(vehicleRecord);
			CapMatchServcie.newCapPictureLog(vehicleRecord);
		} else {
			log.info("不能处理的数据：{}", inout);
		}
		insertBarrierRecord(true,cameraId,"result",jsonStr);
	}

	/**
	 * private void handleInYardResult(WebSocketSession session, JSONObject json) {
	 * String type = json.getString("type"); Integer plate_type =
	 * json.getInteger("plate_type"); Integer utc_ts = json.getInteger("utc_ts");
	 * String local_time = json.getString("local_time"); Boolean is_whitelist =
	 * json.getBoolean("is_whitelist"); String full_pic_path =
	 * json.getString("full_pic_path"); String plate_pic_path =
	 * json.getString("plate_pic_path"); String full_pic =
	 * json.getString("full_pic"); String plate_pic = json.getString("plate_pic");
	 * //生成订单记录 //sendCreateUserOrder }
	 **/
	private void insertBarrierRecord(boolean up,String cameraId, String cmd, String content) {
		try {
			StringBuilder insertSql = new StringBuilder(
					"insert into barrier_gate_up_down_record (cmd,updown,cam_id,content,create_time) values(?,?,?,?,?)");
			executeSQL(insertSql.toString(), cmd, up ? "上行" : "下行",cameraId, content, new Date());
		} catch (Exception e) {
			log.info(e.toString(), e);
		}
	}

	/**
	 * io输入上报
	 * 
	 * @param session
	 * @param json
	 * @throws Exception
	 */
	private void ioinput_cmd(WebSocketSession session, JSONObject json) throws Exception {
		JSONObject response = new JSONObject();
		response.put("cmd", "ioinput_rsp");
		response.put("msg_id", json.getString("msg_id"));
		response.put("status", "ok");
		sendContent(session, response.toJSONString());
		String cameraId = sessionId2CameraIdMap.get(session.getId());
		insertBarrierRecord(true,cameraId,"ioinput",json.toJSONString());
	}

	private void rs485input_cmd(WebSocketSession session, JSONObject json) throws Exception {
		JSONObject response = new JSONObject();
		response.put("cmd", "rs485input_rsp");
		response.put("msg_id", json.getString("msg_id"));
		response.put("status", "ok");
		sendContent(session, response.toJSONString());
	}

	private void encrypt_verify_cmd(WebSocketSession session, JSONObject json) throws Exception {
		JSONObject response = new JSONObject();

		String cam_id = json.getString("cam_id");
		// 通过cam_id获取sign_str，sign_str存储在数据库中,应该缓存在内存，每分钟定时刷新
		// TODO
		response.put("cmd", "encrypt_verify_rsp");
		response.put("status", "ok");
		response.put("sign_str", "12345678");
		response.put("msg_id", json.getString("msg_id"));
		sendContent(session, response.toJSONString());
	}

	private void cap_report_cmd(WebSocketSession session, JSONObject json) throws Exception {
		// 抓拍上报
		{
			String cameraId = sessionId2CameraIdMap.get(session.getId());
			String which_msg = json.getString("which_msg");
			String pic_path = json.getString("pic_path");
			Integer pic_len = json.getInteger("pic_len");
			String cap_pic = json.getString("cap_pic");
			
			
			
			
			if (pic_len != null && pic_len > 0) {

				pic_path = saveBase64Pic(session, cameraId,which_msg, cap_pic, pic_len);
			} else if (pic_path != null && !"".equals(pic_path)) {
				// nothing todo
			}
			{
				StringBuilder insertSql = new StringBuilder(
						"update camera_cap_pic_record set response_time =now(),pic_path=? where msg_id=?");
				executeSQL(insertSql.toString(), pic_path, which_msg);
			}
		}

		JSONObject response = new JSONObject();
		response.put("cmd", "cap_report_rsp");
		response.put("msg_id", json.getString("msg_id"));
		response.put("status", "ok");
		sendContent(session, response.toJSONString());
	}

	
	private String saveBase64Pic(WebSocketSession session,String cam_id, String which_msg, String cap_pic, Integer pic_len) {
		String full_pic = cap_pic;
		if (full_pic == null || full_pic.isBlank() || full_pic.length() < 10) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
		StringBuilder pathBuilder = new StringBuilder();

		String nowStr = sdf.format(new Date());
		pathBuilder.append(cam_id).append("_").append(nowStr).append(".jpg");
		String filename = pathBuilder.toString();
		//vr.getMsgBody().put("full_pic_path", filename);
		filename=cam_id+"/"+ filename;
		CapMatchServcie.newCapPicture(full_pic,filename);
		/*esUploadPic.submit(new Runnable() {
			@Override
			public void run() {
				try {
					byte[] imageBytes = Base64.getDecoder().decode(full_pic);
					minioUtil.uploadJPEG(imageBytes, cam_id+"/"+ filename, MinIOConfig.pitureBucket);
				} catch (Throwable e) {
					log.warn("上传图片失败：" + full_pic, e);
				}
			}
		});*/
		return filename;
	}
	private String saveBase64Pic_old(WebSocketSession session, String which_msg, String cap_pic, Integer pic_len) {
		try {
			byte[] imageBytes = Base64.getDecoder().decode(cap_pic);
			// /picture/<park_id>/<cam_id>/<年月日>/<小时>/<年月日_时分秒>_<毫秒>_capture.jpg
			SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
			String camId = sessionId2CameraIdMap.get(session.getId());
			ExtendSession exsession = sessionCacheManager.get(camId);
			final String head = "/home/yuantiaotech/chechangvue/cap/";
			StringBuilder picpath = new StringBuilder(head);
			picpath.append(exsession.getPark_id()).append(File.separator);
			picpath.append(camId).append(File.separator);
			picpath.append(yyyyMMdd.format(new Date())).append(File.separator);
			Path path = Paths.get(picpath.toString());
			/**
			 * 如果目录不存在则创建
			 */
			if (!path.toFile().exists()) {
				Files.createDirectories(path);
			}
			picpath.append(yyyyMMddHHmmss.format(new Date())).append("_capture.jpg");
			try (FileOutputStream fos = new FileOutputStream(picpath.toString())) {
				// 将解码后的字节写入文件
				fos.write(imageBytes);
				System.out.println("图片解码成功并保存为 output_image.png");
			} catch (IOException e) {
				// e.printStackTrace();
			}
			return picpath.toString();
		} catch (Exception e) {
			log.warn("保存抓拍图片报错", e);
			return null;
		}
	}

	private void turnback_start_event_cmd(WebSocketSession session, JSONObject json) throws Exception {
		JSONObject response = new JSONObject();
		response.put("cmd", "turnback_start_event_rsp");
		response.put("msg_id", json.getString("msg_id"));
		response.put("status", "ok");
		sendContent(session, response.toJSONString());
	}

	private void turnback_end_event_cmd(WebSocketSession session, JSONObject json) throws Exception {
		JSONObject response = new JSONObject();
		response.put("cmd", "turnback_end_event_rsp");
		response.put("msg_id", json.getString("msg_id"));
		response.put("status", "ok");
		sendContent(session, response.toJSONString());
	}

	private void still_start_event_cmd(WebSocketSession session, JSONObject json) throws Exception {
		JSONObject response = new JSONObject();
		response.put("cmd", "still_start_event_rsp");
		response.put("msg_id", json.getString("msg_id"));
		response.put("status", "ok");
		sendContent(session, response.toJSONString());
	}

	private void still_end_event_cmd(WebSocketSession session, JSONObject json) throws Exception {
		JSONObject response = new JSONObject();
		response.put("cmd", "still_end_event_rsp");
		response.put("msg_id", json.getString("msg_id"));
		response.put("status", "ok");
		sendContent(session, response.toJSONString());
	}

	private static final String generateToken(int len) {
		String token = UUID.randomUUID().toString().replace("-", "");
		String sub = token.toString();
		if (sub.length() > len) {
			return sub.substring(0, len);
		}
		return sub;
	}

	/*
	 * public static void main(String[] atrg) { SimpleDateFormat yyyyMMddHHmmss =
	 * new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS"); Date dt = new Date();
	 * dt.setTime(1762504892L * 1000);
	 * System.out.println(yyyyMMddHHmmss.format(dt)); }
	 */

}