package com.junmo.web.resource;

import cn.hutool.core.util.RandomUtil;
import com.google.common.collect.Lists;
import com.junmo.web.model.DotRecordDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: sucf
 * @date: 2022/8/26 17:32
 * @description: data resource commit manager
 */
@Slf4j
@Component
public class ResourceManager {

    /**
     * process number
     */
    //@Value("#{T(java.lang.Integer).parseInt('${batch-push-number}')}")
    private static Integer limit = 1000;

    /**
     * node number
     */
    //@Value("#{T(java.lang.Integer).parseInt('${data-storage-node}')}")
    private static Integer nodeNumber = 5;

    /**
     * storage data storage node
     */
    private static final List<StorageNode> storageNodeList;

    /**
     * initialize
     */
    static {
        storageNodeList = Lists.newArrayListWithCapacity(nodeNumber);
        //启动处理器
        for (int k = 0; k < nodeNumber; k++) {
            StorageNode storageNode = new StorageNode("node-" + k, limit);
            storageNodeList.add(storageNode);
            ResourceHandler resourceHandler = new ResourceHandler(storageNode);
            //错开时间启动
            new Thread(resourceHandler).start();
//            try {
//                Thread.sleep(150);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    /**
     * push data to queue
     *
     * @param dotRecordDTO
     * @return
     */
    public static boolean push(DotRecordDTO dotRecordDTO) {
        //随机放入存储节点中
        StorageNode storageNode = storageNodeList.get(RandomUtil.randomInt(nodeNumber));
        return storageNode.add(dotRecordDTO);
    }

    /**
     * add node
     */
    public static void addStorageNode() {
    }

    /**
     * delete node
     */
    public static void removeStorageNode() {
    }
}
