package com.red.black.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/** @Author: Red @Descpription: @Date: 13:09 2019/11/23 */
@Configuration
@ConfigurationProperties(prefix = "my")
@Data
public class ActiveMqBean {

  private String testTopic;
  private String testQueue;

}
