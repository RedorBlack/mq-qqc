package com.red.black;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/** @Author: Red @Descpription: @Date: 11:06 2019/11/22 */
@SpringBootApplication
public class ActiveMQApplication {

  public static void main(String[] args) {
    SpringApplication.run(ActiveMQApplication.class);
  }
}
