package com.biyao.noedge.web.api;

import com.alibaba.fastjson.JSONObject;
import com.biyao.noedge.service.OrdertakingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author yangyao
 * @date 2019/3/14
 */
@Controller
public class InvokerController {

    @Autowired
    OrdertakingService ordertakingService;


    @PostMapping("/invoke")
    @ResponseBody
    public Object invoke(@RequestBody JSONObject o) {
        return ordertakingService.createShopcarOrder(o);
    }
}
