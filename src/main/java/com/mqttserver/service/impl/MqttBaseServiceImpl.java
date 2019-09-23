package com.mqttserver.service.impl;

import com.mqttserver.service.MqttBaseService;
import com.mqttserver.util.JsonUtil;
import com.mqttserver.util.MQTT.MQTTTaskData;
import com.mqttserver.util.MQTT.MqttPushClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MqttBaseServiceImpl implements MqttBaseService {
    private  static final Logger log= LoggerFactory.getLogger(MqttBaseServiceImpl.class);

    /**
     * 发送MQTT任务
     * @param mqttTaskData
     * @return
     */
    public String SendTask(MQTTTaskData mqttTaskData){
        try{

            String str= JsonUtil.beanToJson(mqttTaskData);
            MqttPushClient.publish(mqttTaskData.getTopic(),str);
            log.info("推送MQTT任务成功!topic:"+mqttTaskData.getTopic()+",task_sn："+mqttTaskData.getTask_sn());
        }
        catch (Exception e){
            log.info(e.toString());
        }

        return "下发成功";
    }
}
