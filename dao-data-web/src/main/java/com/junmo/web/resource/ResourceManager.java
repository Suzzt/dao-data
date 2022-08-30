package com.junmo.web.resource;

import com.google.common.collect.Lists;
import com.junmo.web.entity.DotRecord;
import com.junmo.web.mapper.DotRecordMapper;
import com.junmo.web.model.DotRecordDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author: sucf
 * @date: 2022/8/26 17:32
 * @description: data resource commit manager
 */
@Slf4j
@Component
public class ResourceManager {

    @Autowired
    private StorageManager storageManager;

    @Autowired
    private DotRecordMapper dotRecordMapper;

    /**
     * process number
     */
    @Value("#{T(java.lang.Integer).parseInt('${batch-push-number}')}")
    private Integer limit;

    /**
     * initialize processor
     */
    @PostConstruct
    public void initHandler() {
        //启动处理器
        for (int k = 0; k < storageManager.getNodeNumber(); k++) {
            ResourceHandler resourceHandler = new ResourceHandler(storageManager.getResourceNodeList().get(k));
            //错开时间启动
            new Thread(resourceHandler).start();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class ResourceHandler implements Runnable {
        private StorageManager.StorageNode storageNode;

        public ResourceHandler(StorageManager.StorageNode storageNode) {
            this.storageNode = storageNode;
        }

        @Override
        public void run() {
            ProcessorManager processorManager = new ProcessorManager();
            while (true) {
                List<DotRecord> list = Lists.newArrayList();
                for (int i = 0; i < limit; i++) {
                    DotRecordDTO dotRecordDTO = storageNode.get();
                    if (dotRecordDTO == null) {
                        if (i == 0) {
                            //歇一会.停车坐爱枫林晚,霜叶红于二月花
                            log.info("resource {} handler======no need to process data", storageNode.getNodeName());
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
                }
                //责任链
                if (list.size() != 0) {
                    //push data
                    dotRecordMapper.batchInsert(list);
                    log.info("resource {} handler>>>>>>insert data size = {}", storageNode.getNodeName(), list.size());
                }
            }
        }
    }

}
