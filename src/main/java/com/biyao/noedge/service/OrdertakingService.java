package com.biyao.noedge.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.biyao.api.ordertaking.client.IShopcarOrderTakingService;
import com.biyao.api.ordertaking.client.beans.CreateShopcarOrderParam;
import com.biyao.api.ordertaking.client.beans.ShopcarItemParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author yangyao
 * @date 2019/3/14
 */
@Service
public class OrdertakingService {


    @Autowired
    private IShopcarOrderTakingService shopcarOrderTakingService;

    public Object createShopcarOrder(JSONObject jsonObject){
        CreateShopcarOrderParam createShopcarOrderParam = JSON.toJavaObject(jsonObject.getJSONObject("createShopcarOrderParam"), CreateShopcarOrderParam.class);

        List<ShopcarItemParam> shopcarItems = JSONArray.parseArray(jsonObject.getJSONArray("shopcarItems").toJSONString(), ShopcarItemParam.class);

        Boolean isShopcarCrossValidate = jsonObject.getBoolean("isShopcarCrossValidate");

        return shopcarOrderTakingService.createOrder(createShopcarOrderParam, shopcarItems, isShopcarCrossValidate);
    }

}
