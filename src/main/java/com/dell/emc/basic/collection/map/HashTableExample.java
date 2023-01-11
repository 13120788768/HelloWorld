package com.dell.emc.basic.collection.map;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  HashMap 类似，但它是线程安全的,
 *  同一时刻多个线程同时写入 HashTable 不会导致数据不一致,它是java old版本
 */
public class HashTableExample {
    public static void main(String[] args) {
        Map<String, Integer> hashtable = new Hashtable<>();

        // 一般使用ConcurrentHashMap，ConcurrentHashMap 的效率会更高
        // Segment extends ReentrantLock 分段锁:
        Map<String, Integer> m1 = new ConcurrentHashMap<>();

    }
}
