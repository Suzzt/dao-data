package com.junmo.web.resource;

import cn.hutool.core.util.RandomUtil;
import com.google.common.collect.Lists;
import com.junmo.web.model.DotRecordDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author: sucf
 * @date: 2022/8/26 16:52
 * @description: data resource storage manager
 */
@Component
public class StorageManager {
    /**
     * 节点数
     */
    @Value("#{T(java.lang.Integer).parseInt('${data-storage-node}')}")
    private Integer nodeNumber;
    /**
     * 资源存储节点
     */
    private List<StorageNode> resourceNodeList;

    public Integer getNodeNumber() {
        return nodeNumber;
    }

    public List<StorageNode> getResourceNodeList() {
        return resourceNodeList;
    }

    @PostConstruct
    private void initNodeHandler() {
        resourceNodeList = Lists.newArrayList();
        for (int i = 0; i < nodeNumber; i++) {
            resourceNodeList.add(new StorageNode("node-" + i));
        }
    }

    /**
     * 增加存储节点
     */
    public void addStorageNode() {}

    /**
     * 删除存储节点
     */
    public void removeStorageNode() {}

    /**
     * push data to queue
     *
     * @param dotRecordDTO
     * @return
     */
    public boolean push(DotRecordDTO dotRecordDTO) {
        //随机放入存储节点中
        StorageNode storageNode = resourceNodeList.get(RandomUtil.randomInt(nodeNumber));
        return storageNode.add(dotRecordDTO);
    }

    class StorageNode {
        /**
         * 节点名称
         */
        private String nodeName;

        public String getNodeName() {
            return nodeName;
        }

        /**
         * 积累的数据埋点数据资源队列
         */
        private final Queue<DotRecordDTO> RESOURCE_QUEUE = new ConcurrentLinkedQueue<>();

        public StorageNode(String nodeName) {
            this.nodeName = nodeName;
        }

        public boolean add(DotRecordDTO dotRecordDTO) {
            return RESOURCE_QUEUE.offer(dotRecordDTO);
        }

        public DotRecordDTO get() {
            return RESOURCE_QUEUE.poll();
        }
    }
}
