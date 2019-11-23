package com.red.black.controller;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.red.black.pro.Producer;
import com.red.black.model.Red;
import java.util.Map;
import javax.jms.Queue;
import javax.jms.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** @Author: Red @Descpription: @Date: 11:30 2019/11/22 */
@RestController
public class TestController {

  @Autowired private Producer producer;

  @Autowired private Queue queue;

  @Autowired private Topic topic;

  @GetMapping("/qu")
  public long index() {

    Red red = new Red().setVersion(0).setMessage("你好 activemq").setName("Red");
    Gson gson = new Gson();

    Map<String, Object> map = Maps.newHashMap();
    map.put("user", red);
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    for (int i = 0; i < 2; i++) {
      producer.sendMessage(this.queue, map.toString());
    }
    stopWatch.stop();
    System.out.println("发送消息耗时: " + stopWatch.getTotalTimeMillis());
    return stopWatch.getTotalTimeMillis();
  }

  @GetMapping("/top")
  public long top() {

    Red red = new Red().setVersion(0).setMessage("你好 activemq").setName("Red");
    Gson gson = new Gson();
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    for (int i = 0; i < 2; i++) {
      producer.sendMessage(this.topic, gson.toJson(red));
    }
    stopWatch.stop();
    System.out.println("发送消息耗时: " + stopWatch.getTotalTimeMillis());
    return stopWatch.getTotalTimeMillis();
  }
}
