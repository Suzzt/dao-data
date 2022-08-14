package com.junmo.record.service.impl;

import cn.hutool.core.util.StrUtil;
import com.google.gson.Gson;
import com.junmo.common.record.SimpleDotLog;
import com.junmo.common.result.ApiResult;
import com.junmo.common.result.CodeEnum;
import com.junmo.record.service.DataReceiverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author: sucf
 * @date: 2022/4/4 16:33
 * @description:
 */
@Service
@Slf4j
public class DataReceiverServiceImpl implements DataReceiverService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public ApiResult handle(SimpleDotLog dotLog, String warehouseType) {
        log.info("dotLog={}",new Gson().toJson(dotLog));
        kafkaTemplate.send("first-test", new Gson().toJson(dotLog));

        return ApiResult.buildSuccess();
    }

}
