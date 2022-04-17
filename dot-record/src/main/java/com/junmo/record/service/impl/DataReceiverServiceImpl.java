package com.junmo.record.service.impl;

import cn.hutool.core.util.StrUtil;
import com.google.gson.Gson;
import com.junmo.common.record.SimpleDotLog;
import com.junmo.common.result.ApiResult;
import com.junmo.common.result.CodeEnum;
import com.junmo.record.service.DataReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
    public ApiResult handle(SimpleDotLog dotLog) {
        kafkaTemplate.send("first-test", dotLog);
        System.out.println("send data = " + new Gson().toJson(dotLog));
        return ApiResult.buildSuccess();
    }

    @Override
    public ApiResult handle(String dotLog, String separator) {
        //分解dotLog日志信息
        String[] data = dotLog.split(separator);
        if (data.length < 5) {
            //不可能小于5个数
            return ApiResult.buildFail(CodeEnum.PARAM_SEPARATOR_LENGTH_SHORT);
        }
        SimpleDotLog dotLogVO = new SimpleDotLog();
        dotLogVO.setEvent(StrUtil.trim(data[0]));
        dotLogVO.setAffiliateId(data[1]);
        dotLogVO.setUserId(data[2]);
        dotLogVO.setPlatform(data[3]);
        dotLogVO.setVersion(data[4]);
        return handle(dotLogVO);
    }
}
