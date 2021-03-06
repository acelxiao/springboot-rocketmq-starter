package com.efun.starter.rocketmq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Acel on 2018-01-09.
 * RocketMQ的配置参数
 */
@Data
@ConfigurationProperties(prefix = "rocketmq")
public class MQProperties {
    /**
     * config name server address
     */
    private String nameServerAddress;
    /**
     * config producer group , default to DPG+RANDOM UUID like DPG-fads-3143-123d-1111
     */
    private String producerGroup;
    /**
     * config send message timeout
     */
    private Integer sendMsgTimeout = 3000;
    /**
     * switch of trace message consumer: send message consumer info to topic: MQ_TRACE_DATA
     */
    private Boolean traceEnabled = Boolean.FALSE;
}
