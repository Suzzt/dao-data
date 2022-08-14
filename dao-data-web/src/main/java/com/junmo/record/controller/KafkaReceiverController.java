package com.junmo.record.controller;

import com.junmo.common.record.SimpleDotLog;
import com.junmo.common.result.ApiResult;
import com.junmo.record.service.DataReceiverService;
import com.junmo.record.util.LogRecordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: sucf
 * @date: 2022/4/4 15:59
 * @description: 接收打点入kafka
 */
@RestController
@RequestMapping(value = "kafka")
public class KafkaReceiverController {
    @Autowired
    private DataReceiverService dataReceiverService;

    /**
     * kafka 数据接收对象处理
     *
     * @param dotLog
     * @return
     */
    @RequestMapping("dot-log")
    public ApiResult data(@RequestBody SimpleDotLog dotLog) {
        return dataReceiverService.handle(dotLog);
    }

    /**
     * kafka 数据接收文本处理
     *
     * @param dotLog    按字符顺序分割数据,请严格按这个来.
     *                  顺序：事件/affiliateId/userId/platform/version
     *                  示例: dot-log='index$77777777$1000100021$ios$12.0.8'
     * @param separator 分割符 默认按'$'
     * @return
     */
    @RequestMapping("dot-log-txt")
    public ApiResult data(@RequestParam String dotLog, String separator) {
        return dataReceiverService.handle(LogRecordUtils.conversion(dotLog, StringUtils.hasLength(separator) ? separator : "\\$"));
    }
}
