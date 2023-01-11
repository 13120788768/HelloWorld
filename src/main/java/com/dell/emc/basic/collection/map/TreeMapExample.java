package com.dell.emc.basic.collection.map;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Map（key-value）映射表的数据结构，作用就是能高效通过key快速查找value（元素）,下边是常用的一些类:
 * TreeMap
 * 基于红黑树实现
 * 具有有序性
 *
 */
public class TreeMapExample {

    public static void main(String[] args) {


        Map<String, Object> treeMap = new TreeMap<>();
        treeMap.put("k1", 1);
        treeMap.put("k3", 3);
        treeMap.put("k2", 2);
        treeMap.put("k3", 33); // replace the old value 3 with 33 instead.


        System.out.println(treeMap);

        // remove
        System.out.println(treeMap.remove("k3"));
        System.out.println(treeMap.remove("k4"));
        System.out.println(treeMap);

        // get
        System.out.println(treeMap.get("k1"));
        System.out.println(treeMap.get("k5"));

        // keySet
        System.out.println(treeMap.keySet());


        // values
        System.out.println(treeMap.values());

        // entrySet
        System.out.println(treeMap.entrySet());
        for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
            System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());
        }
        System.out.println(treeMap);

        //entrySet().iterator()
        Iterator<Map.Entry<String, Object>> it = treeMap.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            System.out.println("Iterator key=" + entry.getKey() + ", value=" + entry.getValue());
        }
        System.out.println(treeMap);

        // lambda expression
        treeMap.forEach((k, v) -> {
            System.out.println("forEach key=" + k + ", value=" + v);
        });


        /**
         *
         * 通过迭代器 「entrySet().iterator()」:
         *
         * Iterator<Map.Entry<String, Integer>> it = m.entrySet().iterator();
         * while(it.hasNext()) {
         *     Log.info(it.next().getKey() + "-----" );
         * }
         */



    }

}
