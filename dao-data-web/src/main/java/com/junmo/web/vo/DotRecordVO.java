package com.junmo.web.vo;

import cn.hutool.core.date.DateUtil;
import com.junmo.common.enums.WareHouseEnum;
import com.junmo.web.entity.DotRecord;
import com.junmo.web.model.DotRecordDTO;
import lombok.Data;

/**
 * @author: sucf
 * @date: 2022/8/26 15:54
 * @description:
 */
@Data
public class DotRecordVO {
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
    private Long triggerTime;

    /**
     * 发送处理数仓类型
     */
    private String wareHouse;

    public DotRecord toDO() {
        DotRecord dotRecordDO = new DotRecord();
        dotRecordDO.setEventType(eventType);
        dotRecordDO.setAnalysisMessage(analysisMessage);
        dotRecordDO.setTriggerTime(DateUtil.date(triggerTime));
        return dotRecordDO;
    }

    public DotRecordDTO toDTO() {
        DotRecordDTO dotRecordDTO = new DotRecordDTO();
        dotRecordDTO.setEventType(eventType);
        dotRecordDTO.setAnalysisMessage(analysisMessage);
        dotRecordDTO.setTriggerTime(DateUtil.date(triggerTime));
        dotRecordDTO.setWareHouseEnum(WareHouseEnum.getWareHouseEnumByName(wareHouse));
        return dotRecordDTO;
    }
}
