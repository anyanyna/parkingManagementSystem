package com.gemcoder.system.job;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 对接MQTT
 * @author jiang
 *
 */
public class MqttJob {
	private static final Logger log = LoggerFactory.getLogger(MqttJob.class);
	
	private String broker;
	private String clientId;
	private String userName;
	private String password;
	private String topics;
	MqttClient client;
	MemoryPersistence persistence;
	public void execute() {
		try {
			_execute();
		}catch(Exception e) {
			log.warn(e.toString(),e);
		}
	}
	private void _execute() throws MqttException {
		persistence = new MemoryPersistence();
		client = new MqttClient(broker, clientId, persistence);
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setUserName(userName);
        connOpts.setPassword(password.toCharArray());
        connOpts.setCleanSession(true);
        client.setCallback(new DefaultMqttCallback(this));
        client.connect(connOpts);
        // TODO 支持多订阅    topics = /设备ID;/设备ID; 以英文;位间隔
        String[] topicFilters = topics.split(";");
        client.subscribe(topicFilters);
	}
	public class DefaultMqttCallback implements MqttCallback {
		MqttJob context;

	    public DefaultMqttCallback(MqttJob context) {
	        this.context = context;
	    }

	    /**
	     * 如果客户端在保持连接时间内没有收到来自服务器的任何消息，
	     * 就会触发 MqttCallback 接口的 connectionLost() 方法。
	     *
	     * @param cause
	     */
	    @Override
	    public void connectionLost(Throwable cause) {
	        // TODO 解决客户端发送PING给服务端，客户端处理相应导致连接丢失
	       
	    }

	    @Override
	    public void messageArrived(String topic, MqttMessage message) throws Exception {
	        //context.
	    }

	    @Override
	    public void deliveryComplete(IMqttDeliveryToken token) {
	        // TODO 消息发送完成
	      
	    }

	}
	
}
