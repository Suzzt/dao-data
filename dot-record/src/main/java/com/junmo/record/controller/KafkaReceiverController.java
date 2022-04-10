package com.junmo.record.controller;

import com.junmo.common.result.ApiResult;
import com.junmo.record.service.DataReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: sucf
 * @date: 2022/4/4 15:59
 * @description: 接收打点入kafka
 */
@RestController
public class KafkaReceiverController {
    @Autowired
    private DataReceiverService dataReceiverService;

    /**
     * kafka 数据接收处理
     * @param data
     * @return
     */
    @RequestMapping("kafka-dot-data")
    public ApiResult data(@RequestParam String data){
        return dataReceiverService.handle(data);
    }
}
