package com.red.black.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

/** @Author: Red @Descpription: @Date: 10:36 2019/11/23 */
@Configuration
public class JmsConfig{

  @Autowired private ActiveMqBean activeMqBean;



  //  //Queue 模式
  @Bean("queueListener")
  public JmsListenerContainerFactory<?> queueJmsListenerContainerFactory(ConnectionFactory connectionFactory){
    SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory);
    factory.setPubSubDomain(false);
    return factory;
  }

  // 在Topic模式中，对消息的监听需要对containerFactory进行配置
  @Bean("topicListener")
  public JmsListenerContainerFactory<?> topicJmsListenerContainerFactory(
      ConnectionFactory connectionFactory) {
    SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory);
    factory.setPubSubDomain(true);
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
    return new ActiveMQQueue(activeMqBean.getTestQueue());
  }

  @Bean
  public Topic topic() {
    return new ActiveMQTopic(activeMqBean.getTestTopic());
  }


}
