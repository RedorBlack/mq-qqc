package com.red.black.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.red.black.model.Red;
import com.red.black.pro.KafkaProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** @Author: Red @Descpription: @Date: 11:58 2019/11/29 */
@RestController
public class TestCOntroller {

  @Autowired private KafkaProService proService;

  @GetMapping("/send")
  public void sengMessage() throws JsonProcessingException {
    Red red = new Red().setName("kafka").setMessage("hello kafka").setVersion(2);

    ObjectMapper objectMapper = new ObjectMapper();
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    objectMapper.writeValueAsString(red);
    proService.sendMessage("mykafka", objectMapper.writeValueAsString(red));
    stopWatch.stop();

    System.out.println(stopWatch.getTotalTimeMillis());
  }
}
