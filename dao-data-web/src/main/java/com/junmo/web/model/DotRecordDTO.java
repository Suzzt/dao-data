package com.junmo.web.model;

import java.util.Date;

import com.junmo.common.enums.WareHouseEnum;
import lombok.Data;

/**
 * @author: sucf
 * @date: 2022/8/27 12:23
 * @description:
 */
@Data
public class DotRecordDTO {

    /**
     * 事件类型
     */
    private String eventType;

    /**
     * 参数信息
     */
    private String analysisMessage;

    /**
     * 触发时间点
     */
    private Date triggerTime;

    /**
     * 发送处理数仓类型
     */
    private WareHouseEnum wareHouseEnum;
}