package com.junmo.web.resource.processor;

import com.junmo.web.model.DotRecordDTO;

/**
 * @author: sucf
 * @date: 2022/9/2 23:10
 * @description:
 */
public class FileDataProcessor implements DataProcessor{
    private final String filePath = "/data/logs/dot-record";

    private final String prefixName = "log";

    private final String spilt = "\t";

    @Override
    public void collect(DotRecordDTO dotRecordDTO) {

    }

    @Override
    public void commit(String storageNodeName) {

    }
}
