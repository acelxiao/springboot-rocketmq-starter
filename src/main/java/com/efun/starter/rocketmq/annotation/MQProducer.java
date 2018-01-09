package com.efun.starter.rocketmq.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by Acel on 2017/6/27.
 * RocketMQ生产者自动装配注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MQProducer {
    String topic() default "";
    String tag() default "";
}
