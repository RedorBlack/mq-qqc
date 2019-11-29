package com.red.black.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.Executor;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
/** @Author: Red @Descpription: @Date: 10:36 2019/11/23 */
@Configuration
/** //启动消息队列 */
@EnableJms
public class JmsConfig {

  @Autowired private ActiveMqBean activeMqBean;

  @Autowired Executor asyncPromiseExecutor;

  //  //Queue 模式
  @Bean("queueListener")
  public JmsListenerContainerFactory<?> queueJmsListenerContainerFactory(
      ConnectionFactory connectionFactory) {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory);
    factory.setMessageConverter(jacksonJmsMessageConverter(new ObjectMapper()));
    factory.setTaskExecutor(asyncPromiseExecutor);
    factory.setPubSubDomain(false);
    factory.setConcurrency("6");
    factory.setMessageConverter(jacksonJmsMessageConverter(new ObjectMapper()));
    return factory;
  }

  // 在Topic模式中，对消息的监听需要对containerFactory进行配置
  @Bean("topicListener")
  public JmsListenerContainerFactory<?> topicJmsListenerContainerFactory(
      ConnectionFactory connectionFactory) {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory);
    factory.setPubSubDomain(true);
    factory.setConcurrency("6");
    factory.setTaskExecutor(asyncPromiseExecutor);
    factory.setMessageConverter(jacksonJmsMessageConverter(new ObjectMapper()));
    return factory;
  }

  @Bean
  public MessageConverter jacksonJmsMessageConverter(ObjectMapper objectMapper) {
    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
    converter.setTargetType(MessageType.TEXT);
    converter.setObjectMapper(objectMapper);
    converter.setTypeIdPropertyName("_type");
    return converter;
  }

  @Bean
  public Queue queue() {
    return new ActiveMQQueue("test-queue");
  }

  @Bean
  public Topic topic() {
    return new ActiveMQTopic("test-topic");
  }
}
