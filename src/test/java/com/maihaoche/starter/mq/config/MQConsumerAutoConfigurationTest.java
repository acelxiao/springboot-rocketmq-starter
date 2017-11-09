package com.maihaoche.starter.mq.config;

import com.maihaoche.starter.mq.annotation.MQConsumer;
import com.maihaoche.starter.mq.base.AbstractMQPushConsumer;
import org.junit.After;
import org.junit.Test;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MQConsumerAutoConfigurationTest {

    private AnnotationConfigApplicationContext context;

    private void prepareApplicationContext() {
        this.context = new AnnotationConfigApplicationContext();
        EnvironmentTestUtils.addEnvironment(this.context, "rocketmq.name-server-address:127.0.0.1:9876");
        this.context.register(TestConsumer.class);
        this.context.register(MQConsumerAutoConfiguration.class);
        this.context.refresh();
    }

    @After
    public void close() {
        this.context.close();
    }

    @Test
    public void testConsumerConfiguration() throws Exception {
        prepareApplicationContext();
        TestConsumer testConsumer = context.getBean(TestConsumer.class);
        assertNotNull(testConsumer.getConsumer());
        assertEquals(testConsumer.getConsumer().getConsumerGroup(), "test_consumer_group");
        assertEquals(testConsumer.getConsumer().getNamesrvAddr(), "127.0.0.1:9876");
    }

    @Component
    @MQConsumer(consumerGroup = "test_consumer_group", topic = "test_topic")
    static class TestConsumer extends AbstractMQPushConsumer<String> {
        @Override
        public boolean process(String message, Map<String, Object> extMap) {
            return true;
        }
    }

}