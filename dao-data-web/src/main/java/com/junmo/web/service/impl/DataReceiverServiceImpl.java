package com.junmo.web.service.impl;

import com.google.gson.Gson;
import com.junmo.common.enums.WareHouseEnum;
import com.junmo.common.result.ApiResult;
import com.junmo.web.resource.ResourceManager;
import com.junmo.web.service.DataReceiverService;
import com.junmo.web.vo.DotRecordVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: sucf
 * @date: 2022/4/4 16:33
 * @description:
 */
@Service
@Slf4j
public class DataReceiverServiceImpl implements DataReceiverService {

    @Override
    public ApiResult handle(DotRecordVO dotRecordVO, WareHouseEnum warehouseType) {
        log.debug("report dot record data = {}", new Gson().toJson(dotRecordVO));
        ResourceManager.push(dotRecordVO.toDTO());
        return ApiResult.buildSuccess();
    }

}
