package com.junmo.web.vo;

import cn.hutool.core.date.DateUtil;
import com.junmo.web.entity.DotRecord;
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

    public DotRecord toDO() {
        DotRecord dotRecordDO = new DotRecord();
        dotRecordDO.setEventType(eventType);
        dotRecordDO.setAnalysisMessage(analysisMessage);
        dotRecordDO.setTriggerTime(DateUtil.date(triggerTime));
        return dotRecordDO;
    }
}
