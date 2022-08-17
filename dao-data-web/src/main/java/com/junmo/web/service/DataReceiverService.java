package com.junmo.web.service;


import com.junmo.common.enums.WareHouseEnum;
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
     * @param warehouseType 数仓类型
     * @return
     */
    ApiResult handle(SimpleDotLog dotLog, WareHouseEnum warehouseType);

}
