package com.junmo.common.record;

import lombok.Data;

/**
 * @author: sucf
 * @date: 2022/4/17 15:19
 * @description: 基础公共打点日志数据
 */
@Data
public class BaseDotLog {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 所属类  用于user的归属
     * 比如用户所属企业、单位、分类......
     */
    private String affiliateId;

    /**
     * 打点来自平台端
     * ios、web、h5、android、pc
     */
    private String platform;

    /**
     * 客户端版本
     */
    private String version;

    /**
     * 请求事件(会对该字段前后去除空格处理)
     */
    private String event;
}
