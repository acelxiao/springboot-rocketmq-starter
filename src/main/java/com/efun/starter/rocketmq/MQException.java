package com.efun.starter.rocketmq;

/**
 * Created by Acel on 2018-01-09.
 * RocketMQ的自定义异常
 */
public class MQException extends RuntimeException {
    public MQException(String msg) {
        super(msg);
    }
}
