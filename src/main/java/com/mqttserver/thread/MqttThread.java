package com.mqttserver.thread;

import com.mqttserver.entity.MQTTResult.CarFeeRsp;
import com.mqttserver.entity.MQTTResult.TheThirdCoupon;
import com.mqttserver.properties.MqttConfiguration;
import com.mqttserver.service.APIinsideService;
import com.mqttserver.util.JsonUtil;
import com.mqttserver.util.MQTT.MQTTTaskData;
import com.mqttserver.util.MQTT.MqttPushClient;
import com.mqttserver.util.StringUtil;
import com.mqttserver.writeLock.CarFeeRspLock;
import com.mqttserver.util.SecretUtils;
import com.mqttserver.util.SpringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

@Async
@Component
public class MqttThread {
    private static final Logger logger = LoggerFactory.getLogger(MqttThread.class);
    @Autowired
    private static MqttConfiguration mqttConfiguration;
    @Autowired
    private APIinsideService apIinsideService;
    /**
     * 间隔5S触发
     */
    @Scheduled(cron = "*/5 * * * * ? ")
    public void checkMqtt(){
        mqttConfiguration= SpringUtils.getBean(MqttConfiguration.class);
        if(MqttPushClient.getClient()==null)
        {
            logger.info("本地MQTT初始化连接...");
            MqttPushClient.connect(mqttConfiguration.getHost(),mqttConfiguration.getClientid(),mqttConfiguration.getUsername(),mqttConfiguration.getPassword(),mqttConfiguration.getTimeout(),mqttConfiguration.getKeepalive());
            //订阅主题
            if(mqttConfiguration.getTopic()!=null){
                String[] topicList=mqttConfiguration.getTopic().split(",");
                if(topicList.length>0){
                    for (String topic: topicList ) {
                        MqttPushClient.subscribe(topic,2);
                        logger.info("本地MQTT订阅主题："+topic);
                    }
                }
            }
        }
        if(!MqttPushClient.connected()){
            logger.info("本地MQTT尝试连接...");
            MqttPushClient.connect(mqttConfiguration.getHost(),mqttConfiguration.getClientid(),mqttConfiguration.getUsername(),mqttConfiguration.getPassword(),mqttConfiguration.getTimeout(),mqttConfiguration.getKeepalive());
            //订阅主题
            if(mqttConfiguration.getTopic()!=null){
                String[] topicList=mqttConfiguration.getTopic().split(",");
                if(topicList.length>0){
                    for (String topic: topicList ) {
                        MqttPushClient.subscribe(topic,2);
                        logger.info("本地MQTT订阅主题："+topic);
                    }
                }
            }
        }


    }
    @Async
    public  void saveMqttResult(String datastr,String topic) {
        try{
            logger.info("接收到MQTT回传数据:"+topic);
            if(datastr.length()>8){
                byte[] firstData= StringUtil.decryptBASE64(datastr);//base64解密
                //System.out.println("firstData:"+firstData);
                byte[] secondData= SecretUtils.decryptMode(firstData);//3des解密
                String thirdData=new String(secondData);
                logger.info("thirdData:"+thirdData);
                MQTTTaskData mqttTaskData= JsonUtil.jsonToBean(thirdData,MQTTTaskData.class);
                apIinsideService=SpringUtils.getBean(APIinsideService.class);//加载API内部service
                logger.info(mqttTaskData.toString());
                        switch (mqttTaskData.getTask_type()){
                            case "cal_fee_request":
                                //SessionUtil.setCarFeeRsp(mqttTaskData.getData());
                                CarFeeRsp carFeeRsp=JsonUtil.jsonToBean(mqttTaskData.getData().toString(),CarFeeRsp.class);
                                carFeeRsp.setCarplate(StringUtil.deCode(carFeeRsp.getCarplate()));
                                if(carFeeRsp.getCode()==0){
                                    carFeeRsp.setIncarplate(StringUtil.deCode(carFeeRsp.getIncarplate()));
                                    carFeeRsp.setPaid((double) Math.round(carFeeRsp.getPaid() * 100) / 100);
                                    carFeeRsp.setNeedpay((double) Math.round(carFeeRsp.getNeedpay() * 100) / 100);
                                    carFeeRsp.setTimeStamp(5);
                                }
                                //通知API接收到线下计费信息
                                apIinsideService.setCarFeeRsp(carFeeRsp);
                                break;
                            case "requestRealtimeBenefits":
                                TheThirdCoupon theThirdCoupon=JsonUtil.jsonToBean(mqttTaskData.getData(), TheThirdCoupon.class);
                                theThirdCoupon.setCarPlate(StringUtil.deCode(theThirdCoupon.getCarPlate()));
                                logger.info("接收到线下获取实时优惠请求,"+theThirdCoupon);
                                if(!theThirdCoupon.getCarPlate().equals("未识别")){
                                    //请求接口
                                    apIinsideService.SendTheThirdCoupon(theThirdCoupon);
                                }
                                else
                                {
                                    logger.info("车辆未识别,不做处理");
                                }

                                break;
                        }
            }
        }
        catch (Exception e){
            logger.info("Mqtt数据接收错误,错误原因"+e.toString());
        }
    }
    /**
     * 间隔1S触发
     */
    @Scheduled(cron = "*/1 * * * * ? ")
    public void clearMqtt(){
        Collection<CarFeeRsp> carFeeRsps=CarFeeRspLock.allValues();
        if(carFeeRsps.size()>0) {
            Iterator<CarFeeRsp> iterator =carFeeRsps.iterator();
            while(iterator.hasNext()) {
                CarFeeRsp carFeeRsp=iterator.next();
                if(carFeeRsp!=null){
                    if(carFeeRsp.getTimeStamp()!=null){
                        carFeeRsp.setTimeStamp(carFeeRsp.getTimeStamp() - 1);
                    }
                    else{
                        carFeeRsp.setTimeStamp(5);
                    }
                    if (carFeeRsp.getTimeStamp() == 0) {
                        logger.info("5S自动清除计费信息，orderId:"+carFeeRsp.getOrderid());
                        iterator.remove();
                    }
                }
            }
        }
    }

}
