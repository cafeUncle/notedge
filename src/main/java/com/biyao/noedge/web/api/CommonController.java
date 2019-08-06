package com.biyao.noedge.web.api;

import com.biyao.noedge.common.AccessInvoke;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取公共信息
 *
 * @author yangyao
 * @date 2019/8/6
 */
@RestController
public class CommonController {

    @Value("${dubbo.registry.address}")
    private String dubboRegistryAddress;

    @GetMapping("/accessors")
    public Map<String, String> accessors() {

        Map<String, String> result = new HashMap<String, String>();

        Class<InvokerController> invokerControllerClass = InvokerController.class;

        Method[] methods = invokerControllerClass.getMethods();

        for (Method method : methods) {
            PostMapping postMapping = method.getAnnotation(PostMapping.class);
            AccessInvoke accessInvoke = method.getAnnotation(AccessInvoke.class);
            if (postMapping != null && accessInvoke != null) {
                String key = postMapping.value()[0];
                String value = accessInvoke.name();
                result.put(key, value);
            }
        }

        return result;
    }

    @GetMapping("/curEnv")
    public String curEnv() {
        return dubboRegistryAddress;
    }
}
