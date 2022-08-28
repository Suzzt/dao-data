package com.junmo.web.resource.processor;

import com.junmo.web.model.DotRecordDTO;

/**
 * @author: sucf
 * @date: 2022/8/27 23:07
 * @description: 数据处理器接口
 */
public interface DataProcessor {

    /**
     * collect data
     *
     * @param dotRecordDTO
     */
    void collect(DotRecordDTO dotRecordDTO);

    /**
     * commit data
     *
     * @param storageNodeName
     */
    void commit(String storageNodeName);
}
