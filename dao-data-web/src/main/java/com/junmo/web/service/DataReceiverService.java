package com.junmo.web.service;


import com.junmo.common.enums.WareHouseEnum;
import com.junmo.common.record.SimpleDotLog;
import com.junmo.common.result.ApiResult;
import com.junmo.web.vo.DotRecordVO;

/**
 * @author: sucf
 * @date: 2022/4/4 16:00
 * @description: 数据接收处理
 */
public interface DataReceiverService {
    /**
     * 处理数据走向
     *
     * @param dotRecordVO
     * @param warehouseType 数仓类型
     * @return
     */
    ApiResult handle(DotRecordVO dotRecordVO, WareHouseEnum warehouseType);

}
