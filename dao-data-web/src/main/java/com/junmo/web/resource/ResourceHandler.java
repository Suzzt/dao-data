package com.junmo.web.resource;

import com.google.common.collect.Lists;
import com.junmo.web.entity.DotRecord;
import com.junmo.web.mapper.DotRecordMapper;
import com.junmo.web.model.DotRecordDTO;
import com.junmo.web.util.DaoSpringUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author: sucf
 * @date: 2022/09/05 12:33
 * @description: resource handler
 */
@Slf4j
public class ResourceHandler implements Runnable {
    private StorageNode storageNode;

    public ResourceHandler(StorageNode storageNode) {
        this.storageNode = storageNode;
    }

    @Override
    public void run() {
        ProcessorManager processorManager = new ProcessorManager();
        while (true) {
            List<DotRecord> list = Lists.newArrayList();
            for (int i = 0; i < storageNode.limit; i++) {
                DotRecordDTO dotRecordDTO = storageNode.get();
                if (dotRecordDTO == null) {
                    if (i == 0) {
                        //歇一会.停车坐爱枫林晚,霜叶红于二月花
                        log.info("resource {} handler======no need to process data", storageNode.nodeName);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                }
                //mysql
                DotRecord dotRecordDO = new DotRecord();
                dotRecordDO.setTriggerTime(dotRecordDTO.getTriggerTime());
                dotRecordDO.setAnalysisMessage(dotRecordDTO.getAnalysisMessage());
                dotRecordDO.setEventType(dotRecordDTO.getEventType());
                list.add(dotRecordDO);
                //text

                //hive

            }
            //统一提交
            //mysql
            if (list.size() != 0) {
                //push data
                DotRecordMapper dotRecordMapper = DaoSpringUtils.getBean("dotRecordMapper");
                dotRecordMapper.batchInsert(list);
                log.info("resource {} handler>>>>>>insert data size = {}", storageNode.nodeName, list.size());
            }
            //hive

            //text
        }
    }
}