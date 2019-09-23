package com.mqttserver.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mqtt")
public class MqttConfiguration {
    private  static final Logger logger= LoggerFactory.getLogger(MqttConfiguration.class);
    private String host;

    private String clientid;

    private String topic;

    private String username;

    private String password;

    private int timeout;

    private int keepalive;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getKeepalive() {
        return keepalive;
    }

    public void setKeepalive(int keepalive) {
        this.keepalive = keepalive;
    }

    @Override
    public String toString() {
        return "MqttConfiguration{" +
                "host='" + host + '\'' +
                ", clientid='" + clientid + '\'' +
                ", topic='" + topic + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", timeout=" + timeout +
                ", keepalive=" + keepalive +
                '}';
    }

    /* @Bean
    public String getMqttPushClient(){
        logger.info("开始连接");
        MqttPushClient.connect(host, clientid, username, password, timeout,keepalive);
        MqttPushClient.subscribe("epark3rd/getlocalinfo_result",2);//订阅
       return "连接成功";
    }*/
}
