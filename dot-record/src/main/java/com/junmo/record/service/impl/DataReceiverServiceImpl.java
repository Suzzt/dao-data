package com.junmo.record.service.impl;

import com.junmo.common.result.ApiResult;
import com.junmo.record.service.DataReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author: sucf
 * @date: 2022/4/4 16:33
 * @description:
 */
@Service
public class DataReceiverServiceImpl implements DataReceiverService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public ApiResult handle(String data) {
        kafkaTemplate.send("first-test", data);
        System.out.println("send data = "+data);
        return ApiResult.buildSuccess();
    }
}
