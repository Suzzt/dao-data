package com.junmo.calculate.flink;

import com.junmo.common.record.SimpleDotLog;
import org.apache.flink.api.common.serialization.DeserializationSchema;
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
    private static final String KAFKA_CONNECT_INFO = "192.168.1.9:9092";
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_CONNECT_INFO);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "first-1");
        FlinkKafkaConsumer<SimpleDotLog> kafkaConsumer = new FlinkKafkaConsumer<>("first-test", (DeserializationSchema<SimpleDotLog>) new SimpleDotLog(), properties);
        DataStreamSource<SimpleDotLog> source = env.addSource(kafkaConsumer);
        source.print();
        env.execute();
    }
}

