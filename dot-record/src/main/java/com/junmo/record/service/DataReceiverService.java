package com.junmo.record.service;


import com.junmo.common.record.SimpleDotLog;
import com.junmo.common.result.ApiResult;

/**
 * @author: sucf
 * @date: 2022/4/4 16:00
 * @description: 数据接收处理
 */
public interface DataReceiverService {
    /**
     * 处理数据走向
     *
     * @param dotLog
     * @return
     */
    ApiResult handle(SimpleDotLog dotLog);

    /**
     * 处理数据走向
     *
     * @param dotLog
     * @param separator
     * @return
     */
    ApiResult handle(String dotLog, String separator);
}
