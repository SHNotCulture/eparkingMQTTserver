package com.mqttserver.util.MQTT;

import com.mqttserver.util.SecretUtils;
import com.mqttserver.util.StringUtil;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MqttPushClient {
    private  static final Logger logger= LoggerFactory.getLogger(MqttPushClient.class);

    private static MqttClient client=null;

    public static MqttClient getClient() {
        return client;
    }

    public static void setClient(MqttClient client) {
        MqttPushClient.client = client;
    }

    public static void connect(String host, String clientID, String username, String password, int timeout, int keepalive){
        try {
            client = new MqttClient(host, clientID, new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(false);
            options.setUserName(username);
            options.setPassword(password.toCharArray());
            options.setConnectionTimeout(timeout);
            options.setKeepAliveInterval(keepalive);
            MqttPushClient.setClient(client);
            try {
                client.setCallback(new PushCallback());
                client.connect(options);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回MqttClient的状态
     * @return
     */
    public static boolean connected(){
        return MqttPushClient.getClient().isConnected();
    }
    /**
     * 发布，默认qos为0，非持久化
     * @param topic
     * @param pushMessage
     */
    public static void publish(String topic,String pushMessage){
        publish(0, false, topic, pushMessage);
    }
    /**
     * 发布
     * @param qos
     * @param retained
     * @param topic
     * @param pushMessage
     */
    public static void publish(int qos,boolean retained,String topic,String pushMessage){

        MqttTopic mTopic = getClient().getTopic(topic);
        if( null== mTopic){
            logger.info("topic not exist");
        }
        MqttDeliveryToken token;
        try {
            pushMessage= StringUtil.encryptBASE64(SecretUtils.encryptMode(pushMessage.getBytes()));
            MqttMessage message = new MqttMessage();
            message.setQos(qos);
            message.setRetained(retained);
            message.setPayload(pushMessage.getBytes());
            token = mTopic.publish(message);
            //token.waitForCompletion();
        } catch (MqttPersistenceException e) {
            e.printStackTrace();
        } catch (MqttException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 订阅某个主题，qos默认为0
     * @param topic
     */
    public static void subscribe(String topic){
        subscribe(topic,0);
    }
    /**
     * 订阅某个主题
     * @param topic
     * @param qos
     */
    public static void subscribe(String topic,int qos){
        try {
            getClient().subscribe(topic, qos);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}


