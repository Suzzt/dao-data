package com.junmo.web.service.impl;

import com.google.gson.Gson;
import com.junmo.common.enums.WareHouseEnum;
import com.junmo.common.result.ApiResult;
import com.junmo.web.mapper.DotRecordMapper;
import com.junmo.web.merge.StorageManager;
import com.junmo.web.service.DataReceiverService;
import com.junmo.web.vo.DotRecordVO;
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

    @Autowired
    private DotRecordMapper dotRecordMapper;

    @Autowired
    private StorageManager storageManager;

    @Override
    public ApiResult handle(DotRecordVO dotRecordVO, WareHouseEnum warehouseType) {
        log.info("report dot record data = {}", new Gson().toJson(dotRecordVO));
        storageManager.push(dotRecordVO.toDTO());
        return ApiResult.buildSuccess();
    }

}
