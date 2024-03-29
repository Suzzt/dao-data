package com.junmo.web.controller;

import com.junmo.common.enums.WareHouseEnum;
import com.junmo.common.result.ApiResult;
import com.junmo.web.service.DataReceiverService;
import com.junmo.web.vo.DotRecordVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: sucf
 * @date: 2022/8/14 23:19
 * @description: 接收打点入mysql
 */
@RestController
@RequestMapping(value = "dot-record")
@Slf4j
public class DotRecordController {

    @Autowired
    private DataReceiverService dataReceiverService;

    /**
     * mysql 数据接收对象处理
     *
     * @param dotRecordVO
     * @return
     */
    @RequestMapping("data")
    public ApiResult data(DotRecordVO dotRecordVO) {
        return dataReceiverService.handle(dotRecordVO, WareHouseEnum.MYSQL);
    }
}
