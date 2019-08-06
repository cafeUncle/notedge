package com.biyao.noedge.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.biyao.api.ordertaking.client.IGrabCashOrderTakingService;
import com.biyao.api.ordertaking.client.beans.CountGrabCashPriceParam;
import com.biyao.api.ordertaking.client.beans.CreateGrabCashOrderParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 抢返现下单
 *
 * @author yangyao
 * @date 2019/1/11
 */
@Service
public class GrabCashOrderTakingService {

    @Autowired
    private IGrabCashOrderTakingService grabCashOrderTakingService;

    public Object count(JSONObject jsonObject) {
        CountGrabCashPriceParam countGrabCashPriceParam = JSON.toJavaObject(jsonObject, CountGrabCashPriceParam.class);
        return grabCashOrderTakingService.countGrabCashPrice(countGrabCashPriceParam);
    }

    public Object createOrder(JSONObject jsonObject) {
        CreateGrabCashOrderParam createShopcarOrderParam = JSON.toJavaObject(jsonObject, CreateGrabCashOrderParam.class);
        return grabCashOrderTakingService.createOrder(createShopcarOrderParam);
    }
}