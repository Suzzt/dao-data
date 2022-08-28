package com.junmo.web.resource.processor;

import com.google.common.collect.Lists;
import com.junmo.web.entity.DotRecord;
import com.junmo.web.mapper.DotRecordMapper;
import com.junmo.web.model.DotRecordDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: sucf
 * @date: 2022/8/28 22:22
 * @description:
 */
@Slf4j
public class MysqlDataProcessor implements DataProcessor{

    @Autowired
    private DotRecordMapper dotRecordMapper;

    private List<DotRecord> mergeResourceList = Lists.newArrayList();

    @Override
    public void collect(DotRecordDTO dotRecordDTO) {
        DotRecord dotRecordDO = new DotRecord();
        dotRecordDO.setTriggerTime(dotRecordDTO.getTriggerTime());
        dotRecordDO.setAnalysisMessage(dotRecordDTO.getAnalysisMessage());
        dotRecordDO.setEventType(dotRecordDTO.getEventType());
        mergeResourceList.add(dotRecordDO);
    }

    @Override
    public void commit(String storageNodeName) {
        dotRecordMapper.batchInsert(mergeResourceList);
        log.info("resource {} handler>>>>>>insert data size = {}", storageNodeName, mergeResourceList.size());
        mergeResourceList.clear();
    }
}
