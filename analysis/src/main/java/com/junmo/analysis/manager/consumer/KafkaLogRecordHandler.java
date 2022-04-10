package com.junmo.analysis.manager.consumer;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author: sucf
 * @date: 2022/4/4 17:31
 * @description:
 */
@Component
public class KafkaLogRecordHandler {
    @KafkaListener(topics = {"first-test"})
    public void listen(ConsumerRecord record) {
        System.out.println(record.topic() + ":" + record.value());
    }
}
