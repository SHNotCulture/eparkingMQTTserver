package com.mqttserver.service;

import com.mqttserver.util.MQTT.MQTTTaskData;

public interface MqttBaseService {
    String SendTask(MQTTTaskData mqttTaskData);
}
