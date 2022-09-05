package com.junmo.web.resource;

import com.junmo.web.model.DotRecordDTO;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author: sucf
 * @date: 2022/09/05 14:22
 * @description: storage node
 */
public class StorageNode {
    /**
     * node name
     */
    protected String nodeName;

    /**
     * batch process number
     */
    protected Integer limit = 1000;

    /**
     * accumulated data buried point data resource queue
     */
    private final Queue<DotRecordDTO> RESOURCE_QUEUE = new ConcurrentLinkedQueue<>();

    public StorageNode(String nodeName, Integer limit) {
        this.nodeName = nodeName;
        this.limit = limit;
    }

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