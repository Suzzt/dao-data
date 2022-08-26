package com.junmo.web.merge;

import com.google.common.collect.Lists;
import com.junmo.web.entity.DotRecord;
import com.junmo.web.mapper.DotRecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author: sucf
 * @date: 2022/8/26 17:32
 * @description: 资源提交任务
 */
@Slf4j
@Component
public class ResourcePushJob {

    @Autowired
    private DotRecordMapper dotRecordMapper;

    /**
     * merge number
     */
    @Value("#{T(java.lang.Integer).parseInt('${batch-push-number}')}")
    private Integer LIMIT_NUMBER;

    /**
     * 执行任务
     */
    @PostConstruct
    public void execute() {
        new Thread(()->{
            while (true) {
                List<DotRecord> list = Lists.newArrayList();
                for (int i = 0; i < LIMIT_NUMBER; i++) {
                    DotRecord dotRecord = ResourceManager.get();
                    if (dotRecord == null) {
                        if (i == 0) {
                            //歇一会.停车坐爱枫林晚,霜叶红于二月花
                            log.info("handler {}======no need to process data",Thread.currentThread().getName());
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    }
                    list.add(dotRecord);
                }
                if (list.size() != 0) {
                    //push data
                    dotRecordMapper.batchInsert(list);
                    log.info("handler {}>>>>>>insert data size = {}",Thread.currentThread().getName(),list.size());
                }
            }
        }).start();
    }

}
