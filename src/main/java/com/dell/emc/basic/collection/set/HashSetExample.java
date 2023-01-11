package com.dell.emc.basic.collection.set;

import java.util.HashSet;

/**
 * 基于哈希表实现，支持快速查找，但不支持有序性操作。并且失去了元素的插入顺序信息，
 *  也就是说使用 「Iterator」 遍历 「HashSet」 得到的结果是不确定的。
 * HashSet 基于 HashMap 来实现的，是一个不允许有重复元素的集合。
 * HashSet 允许有 null 值。
 * HashSet 是无序的，即不会记录插入的顺序。不能根据范围去查找元素
 * HashSet 不是线程安全的， 如果多个线程尝试同时修改 HashSet，则最终结果是不确定的。
 *  您必须在多线程访问时显式同步对 HashSet 的并发访问
 */
public class HashSetExample {

    public static void main(String[] args) {
        HashSet<Integer> integers = new HashSet<>();
        // add, remove, size, isEmpty, first, last, removeAll, iterator
    }
}
