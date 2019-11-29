package com.red.black.pro;

import com.red.black.service.MessageService;
import java.util.Map;
import javax.jms.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/** @Author: Red @Descpription: 生产者 @Date: 11:10 2019/11/22 */
@Service
public class Producer implements MessageService {

  // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装

  @Autowired
  private JmsMessagingTemplate jmsTemplate;

  @Override
  public void sendMessage(Destination destination, final String message) {
    jmsTemplate.convertAndSend(destination, message);
  }

  @Override
  public void sendMessage(Destination destination, Map message) {
    jmsTemplate.convertAndSend(destination, message);
  }

}
