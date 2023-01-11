package com.dell.emc.basic.collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 基于哈希表实现
 * 是一个散列表，它存储的内容是键值对(key-value)映射
 * 实现了 Map 接口，根据键的 HashCode 值存储数据，具有很快的访问速度，最多允许一条记录的键为 null，不支持线程同步
 * 是无序的，即不会记录插入的顺序
 * 继承于AbstractMap，实现了 Map、Cloneable、java.io.Serializable 接口
 */
public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();

        // 实现有序的hashMap
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();

    }
}
