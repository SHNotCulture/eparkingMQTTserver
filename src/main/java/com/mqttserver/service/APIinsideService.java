package com.mqttserver.service;

import com.mqttserver.entity.MQTTResult.CarFeeRsp;
import com.mqttserver.entity.MQTTResult.TheThirdCoupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "eparkingAPI")
public interface APIinsideService {
    @PostMapping(value = "/inside/setCarFeeRsp")
    String setCarFeeRsp(@RequestBody CarFeeRsp carFeeRsp);
    @PostMapping(value = "/inside/SendTheThirdCoupon")
    String SendTheThirdCoupon(@RequestBody TheThirdCoupon theThirdCoupon);
}
