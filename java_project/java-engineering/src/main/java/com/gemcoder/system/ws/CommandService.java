package com.gemcoder.system.ws;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


/**
 * 下发道闸命令
 * 
 * @author jiang
 *
 */
@Service
public class CommandService {
	private static final Logger log = LoggerFactory.getLogger(CommandService.class);
	private CmdCachemanager cmdCachemanager = CmdCachemanager.getInstance();
	private SessionCacheManager sessionCacheManager = SessionCacheManager.getInstance();

	/**
	 * 开启道闸
	 * 
	 * @param vr     当前车辆信息
	 * @param isopen true开启，false关闭
	 */
	public String openBarier(VehicleRecord vr, boolean isopen) {
		// String cameraId, String content, boolean broadcast
		// content->show_info->plate_info(plate_num,text_color)
		// content->show_info->line_info[{line_text,font_size,text_color}]
		// content->voice_info(voice_text)
		String cam_id = vr.getCam_id();
		String plate_num = vr.getMsgBody().getString("plate_num");
		boolean isInYard = vr.isInYard();
		log.info("开启道闸。{},{}",cam_id,plate_num);
		return openBarier(cam_id, plate_num, isInYard,isopen);
	}
	/**
	 * 
	 * @param cam_id 道闸编号
	 * @param plate_num 车牌
	 * @param isInYard 进场，出场
	 * @param isopen 开闸，关闸
	 * @return
	 */
	public String openBarier(String cam_id, String plate_num, boolean isInYard,boolean isopen) {

		JSONObject plate_info = new JSONObject();
		{
			plate_info.put("plate_num", plate_num);
			plate_info.put("text_color", "FF00F0");
		}

		JSONArray line_info = new JSONArray();
		{
			{
				JSONObject firstLine = new JSONObject();
				firstLine.put("line_text", "临时车");
				firstLine.put("font_size", "large");
				firstLine.put("text_color", "FF00F0");
				line_info.add(firstLine);
			}

			{
				JSONObject secondLine = new JSONObject();
				if (isInYard) {
					secondLine.put("line_text", "欢迎观临");
				} else {
					secondLine.put("line_text", "一路顺风");
				}
				secondLine.put("font_size", "large");
				secondLine.put("text_color", "FF00F0");
				line_info.add(secondLine);
			}

		}

		JSONObject show_info = new JSONObject();
		show_info.put("text_type", "iooutput");
		show_info.put("plate_info", plate_info);
		show_info.put("line_info", line_info);

		JSONObject voice_info = new JSONObject();
		{
			// <T1>京 A12345+一路顺风
			String voice_text = "<T1>" + plate_num;
			if (isInYard) {
				voice_text += "+欢迎观临".intern();
			} else {
				voice_text += "+一路顺风".intern();
			}
			voice_info.put("voice_text", voice_text);
		}

		JSONObject content = new JSONObject();
		content.put("cmd", "iooutput");
		//msg_id 此次请求的唯一标识，20位长，前 13 位是毫秒时间，后 7 位是字母和数字的随机数
		content.put("msg_id", generateMsgId(20));
		ExtendSession extendsession = sessionCacheManager.get(cam_id);
		content.put("token", extendsession.getToken());
		content.put("utc_ts", Instant.now().getEpochSecond());
		if(isopen) {
			content.put("ionum", 1);
			
		}else {
			content.put("ionum", 2);
		}
		content.put("action", "on");
		content.put("show_info", show_info);
		content.put("voice_info", voice_info);
		String cmd = content.toJSONString();
		Command command = new Command(cam_id, cmd, false);
		cmdCachemanager.putCmd(command);
		return cmd;
	}

	public String capPicture(String cam_id) {
		ExtendSession extendsession = sessionCacheManager.get(cam_id);
		JSONObject content = new JSONObject();
		content.put("cmd", "capture");
		String msg_id=generateMsgId(20);
		content.put("msg_id", msg_id);
		content.put("token", extendsession.getToken());
		content.put("utc_ts", Instant.now().getEpochSecond());
		String cmd = content.toJSONString();
		Command command = new Command(cam_id, cmd, false);
		{
			StringBuilder insertSql = new StringBuilder(
					"INSERT INTO camera_cap_pic_record (msg_id, create_time, cam_id) values(?,?,?)");
			int rowsAffected = executeSQL(insertSql.toString(), msg_id, new Date(), cam_id);
		}
		cmdCachemanager.putCmd(command);
		return cmd;
	}
	
	public String sendRawCmd(String cam_id,String content) {
		//ExtendSession extendsession = sessionCacheManager.get(cam_id);
		ExtendSession extendsession = sessionCacheManager.get(cam_id);
		String msg_id=generateMsgId(20);
		String time=Long.toString(Instant.now().getEpochSecond());
		content=content.replace("${msg_id}", msg_id);
		content=content.replace("${time}", time);
		content=content.replace("${token}", extendsession.getToken());
		Command command = new Command(cam_id, content, false);
		cmdCachemanager.putCmd(command);
		return content;
	}
	
	/**
	 * 获取IO状态
	 * @param cam_id
	 * @return
	 */
	public String getIOStatus(String cam_id) {
		ExtendSession extendsession = sessionCacheManager.get(cam_id);
		JSONObject content = new JSONObject();
		content.put("cmd", "getioinput");
		String msg_id=generateMsgId(20);
		content.put("msg_id", msg_id);
		content.put("token", extendsession.getToken());
		content.put("utc_ts", Instant.now().getEpochSecond());
		String cmd = content.toJSONString();
		Command command = new Command(cam_id, cmd, false);
		cmdCachemanager.putCmd(command);
		return cmd;
	}
	private static final String generateMsgId(int len) {
		final String randChars = "0123456789abcdefghijklmnopqrstuvwxyz";
		Random r = new Random();
		StringBuilder sss = new StringBuilder(Long.toString(System.currentTimeMillis()));
		for (int i = sss.length(); i < len; ++i) {
			sss.append(randChars.charAt(r.nextInt(randChars.length())));
		}
		String sub = sss.toString();
		if (sub.length() > len) {
			return sub.substring(0, len);
		}
		return sub;
	}

}
