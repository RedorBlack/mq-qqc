package com.red.black.cus;

import com.red.black.pro.KafkaProService;
import java.util.Optional;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/** @Author: Red @Descpription: @Date: 11:56 2019/11/29 */
@Component
public class ConsumerRecordService {

  private Logger logger = LoggerFactory.getLogger(ConsumerRecordService.class);

  @Autowired private KafkaTemplate kafkaTemplate;

  @KafkaListener(id = "processMessage1", topics = "mykafka")
  public void processMessage1(
      ConsumerRecord<?, ?> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
    Optional<?> kafkaMessage = Optional.ofNullable(record.value());

    if (kafkaMessage.isPresent()) {
      Object message = kafkaMessage.get();
      logger.info("Receive： +++++++++++++++ Topic:" + topic);
      logger.info("Receive： +++++++++++++++ Record:" + record);
      logger.info("Receive： +++++++++++++++ processMessage1:" + message);
    }
  }

  @KafkaListener(id = "processMessage2", topics = "mykafka")
  public void processMessage2(
      ConsumerRecord<?, ?> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
    Optional<?> kafkaMessage = Optional.ofNullable(record.value());

    if (kafkaMessage.isPresent()) {
      Object message = kafkaMessage.get();
      logger.info("Receive： +++++++++++++++ Topic:" + topic);
      logger.info("Receive： +++++++++++++++ Record:" + record);
      logger.info("Receive： +++++++++++++++ processMessage2:" + message);
    }
  }

  @KafkaListener(id = "processMessage3", topics = "mykafka")
  public void processMessage3(
      ConsumerRecord<?, ?> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
    Optional<?> kafkaMessage = Optional.ofNullable(record.value());

    if (kafkaMessage.isPresent()) {
      Object message = kafkaMessage.get();
      logger.info("Receive： +++++++++++++++ Topic:" + topic);
      logger.info("Receive： +++++++++++++++ Record:" + record);
      logger.info("Receive： +++++++++++++++ processMessage3:" + message);
    }
  }
}
