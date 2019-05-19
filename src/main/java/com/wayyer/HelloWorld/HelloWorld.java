package com.wayyer.HelloWorld;

import org.checkerframework.checker.units.qual.K;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: wayyer
 * @Description: hello world
 * @Program: HelloWorld
 * @Date: 2018.12.10
 */
public class HelloWorld {


    public static void main(String[] args){

        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");

        Set<Map.Entry<String, String>> entries = map.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            System.out.println("key = "+entry.getKey()+", value = " + entry.getValue());
        }

        System.out.println(map.entrySet());
        System.out.println(map.keySet());
        System.out.println(map.values());


        ConcurrentHashMap<String, String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("concurrentkey1", "concurrentvalue1");
        concurrentMap.put("concurrentkey2", "concurrentvalue2");
        concurrentMap.put("concurrentkey3", "concurrentvalue3");
        concurrentMap.put("concurrentkey4", "concurrentvalue4");
        concurrentMap.put("concurrentkey5", "concurrentvalue5");

        System.out.println(concurrentMap.entrySet());
        System.out.println(concurrentMap.keySet());
        System.out.println(concurrentMap.values());

        System.out.println("Hello world!");
    }

}
