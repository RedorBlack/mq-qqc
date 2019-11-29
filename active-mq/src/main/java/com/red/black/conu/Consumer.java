package com.red.black.conu;

import javax.jms.Message;
import javax.jms.MessageListener;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/** @Author: Red @Descpription: @Date: 11:12 2019/11/22 */
@Component
public class Consumer implements MessageListener {

  @JmsListener(destination = "test-topic", containerFactory = "topicListener")
  public void receiveQueuenode1(String text) {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    System.out.println("Consumer1 收到的报文为:" + text);
    stopWatch.stop();
  }

  @JmsListener(destination = "test-queue", containerFactory = "queueListener")
  @SendTo("return-queue")
  public String receiveQueuenode(String text) {
    System.out.println("Consumer收到的报文为:" + text);
    return text;
  }

  @JmsListener(destination = "return-queue", containerFactory = "queueListener")
  public void returnQueuenode(String text) {
    System.out.println("收到返回的信息:" + text);
  }

  @JmsListener(destination = "test-topic", containerFactory = "topicListener")
  public void receiveQueuenode2(String text) {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    System.out.println("Consumer 2 收到的报文为:" + text);
    stopWatch.stop();
  }

  @Override
  public void onMessage(Message message) {}
}
