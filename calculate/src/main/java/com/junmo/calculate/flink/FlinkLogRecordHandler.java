package com.junmo.calculate.flink;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;

import java.util.Properties;

/**
 * @author: sucf
 * @date: 2022/4/10 16:29
 * @description:
 */
public class FlinkLogRecordHandler {
    private static final String KAFKA_CONNECT_INFO = "192.168.1.12:9092";
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_CONNECT_INFO);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "first-1");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.springframework.kafka.support.serializer.JsonSerializer");
        FlinkKafkaConsumer<String> consumer = new FlinkKafkaConsumer<>("first-test", new SimpleStringSchema(), properties);
        DataStreamSource<String> source = env.addSource(consumer);
        source.print();
        env.execute();
    }
}

