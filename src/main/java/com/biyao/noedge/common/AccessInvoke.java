package com.biyao.noedge.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by yangyao on 2019/8/6.
 * name用于记录 允许noedge通过前端调用的接口 的中文名
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessInvoke {
    String name();
}
