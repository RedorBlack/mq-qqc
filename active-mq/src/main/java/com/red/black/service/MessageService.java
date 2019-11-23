package com.red.black.service;

import java.util.Map;
import javax.jms.Destination;

/** @Author: Red @Descpription: @Date: 13:07 2019/11/23 */
public interface MessageService {

  void sendMessage(Destination destination, String message);

  void sendMessage(Destination destination, Map message);
}
