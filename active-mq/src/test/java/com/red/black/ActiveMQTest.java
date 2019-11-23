package com.red.black;

import com.red.black.pro.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/** @Author: Red @Descpription: @Date: 11:13 2019/11/22 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveMQTest {

  @Autowired private Producer producer;

  @Test
  public void test() {


  }
}
