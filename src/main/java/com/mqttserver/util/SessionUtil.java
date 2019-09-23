package com.mqttserver.util;

import com.mqttserver.entity.MQTTResult.CarFeeRsp;
import com.mqttserver.writeLock.CarFeeRspLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class SessionUtil {
    private static Logger logger = LoggerFactory.getLogger(SessionUtil.class);
    public static Map<String,CarFeeRsp> carFeeRspList = new HashMap<String,CarFeeRsp>();
   // public static List<CarFeeRsp> carFeeRspList=new ArrayList<CarFeeRsp>();
    /**
     *  读取MQTT返回的临停车计费信息
     * @return
     */
    public static CarFeeRsp getCarFeeRsp(Integer Millis,String carplate,String parkId){
        CarFeeRsp carFeeRsp=null;
        boolean flog=true;
        try {
            while (flog){
                Millis--;
                if(carFeeRspList.size()>0) {
                    for(CarFeeRsp value : carFeeRspList.values()){
                        if(value.getCarplate().equals(carplate)&&value.getParkid().equals(parkId))
                        {
                            carFeeRsp=value;
                        }
                    }
                }
                if(carFeeRsp!=null){
                    logger.info("获取到MQTT回传信息,通过carplate："+carplate+",parkId:"+parkId+"查询得到的结果:"+carFeeRsp);
                   // carFeeRsp.setTimeStamp(20000);
                    flog=false;
                }
                else
                {
                    logger.info("MQTT未获取到数据"+Millis);
                }
                Thread.sleep(1000);
                if(Millis==1){
                    carFeeRsp=new CarFeeRsp();
                    carFeeRsp.setCode(1);
                    carFeeRsp.setCarplate(carplate);
                    carFeeRsp.setPaid(0.0);
                    carFeeRsp.setNeedpay(0.0);
                    logger.info("MQTT最终未获取到数据,返回数据："+carFeeRsp);
                    flog=false;
                }
            }
        }catch (Exception e){
            logger.info("MQTT获取方法异常,异常信息："+e.toString());
            //throw new SessionException(ActionRspEnum.SESSION_OUT);
        }
        return carFeeRsp;
    }

    /**
     * 设置线下计费数据
     * @param carFeeRsp
     */
    public  static void setCarFeeRsp(CarFeeRsp carFeeRsp){
        CarFeeRspLock.put(carFeeRsp.getOrderid(),carFeeRsp);
    }

    /**
     * 获取当前车场ID
     * @return
     */
    public static Integer getParkId(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Integer parkId=(Integer) request.getSession().getAttribute(Common.ParkId);
        return  parkId;
    }

    /**
     * 设置当前车场ID
     * @param parkId
     */
    public static void setParkId(Integer parkId){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.getSession().setAttribute(Common.ParkId,parkId);
    }
}
