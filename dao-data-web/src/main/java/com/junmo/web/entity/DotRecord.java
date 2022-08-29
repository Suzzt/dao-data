package com.junmo.web.entity;

import java.util.Date;
import lombok.Data;

/**
 * DotRecord
 * @author sucf
 */
@Data
public class DotRecord {
    /**
     * 埋点标记主键唯一.绝对禁止修改
     */
    private Long id;

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
}