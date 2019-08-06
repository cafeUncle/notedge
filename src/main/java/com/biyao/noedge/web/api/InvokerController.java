package com.biyao.noedge.web.api;

import com.alibaba.fastjson.JSONObject;
import com.biyao.noedge.common.AccessInvoke;
import com.biyao.noedge.service.GrabCashOrderTakingService;
import com.biyao.noedge.service.ShopcarOrderTakingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 能跑就行
 *
 * @author yangyao
 * @date 2019/3/14
 */
@Controller
public class InvokerController {

    @Autowired
    ShopcarOrderTakingService shopcarOrderTakingService;

    @Autowired
    GrabCashOrderTakingService grabCashOrderTakingService;

    @PostMapping("/shopcarOrderTaking")
    @ResponseBody
    @AccessInvoke(name = "购物车下单")
    public Object shopcarOrderTaking(@RequestBody JSONObject o) {
        return shopcarOrderTakingService.createOrder(o);
    }

    @PostMapping("/grabCashOrderCount")
    @ResponseBody
    @AccessInvoke(name = "抢返现计算")
    public Object grabCashOrderCount(@RequestBody JSONObject o) {
        return grabCashOrderTakingService.count(o);
    }

    @PostMapping("/grabCashOrderTaking")
    @ResponseBody
    @AccessInvoke(name = "抢返现下单")
    public Object grabCashOrderTaking(@RequestBody JSONObject o) {
        return grabCashOrderTakingService.createOrder(o);
    }
}
