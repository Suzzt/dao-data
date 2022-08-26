package com.junmo.web.merge;

import com.junmo.web.entity.DotRecord;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author: sucf
 * @date: 2022/8/26 16:52
 * @description: 资源管理
 */
public class ResourceManager {
    /**
     * 积累的数据埋点数据资源队列
     */
    private static final Queue<DotRecord> RESOURCE_QUEUE = new ConcurrentLinkedQueue<>();

    public static boolean add(DotRecord dotRecord) {
        return RESOURCE_QUEUE.offer(dotRecord);
    }

    public static DotRecord get() {
        return RESOURCE_QUEUE.poll();
    }
}
