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
    static Value value = new Value(2);


    public static void main(String[] args){

        //重写了equals必须重写hash

        /**
         * 为什么重写equals()的同时还得重写hashCode()
         * 这个问题主要是针对映射相关的操作（Map接口）。
         * 学过数据结构的同学都知道Map接口的类会使用到键对象的哈希码，
         * 当我们调用put方法或者get方法对Map容器进行操作时，都是根据键对象的哈希码来计算存储位置的，
         * 因此如果我们对哈希码的获取没有相关保证，就可能会得不到预期的结果。
         * 在java中，我们可以使用hashCode()来获取对象的哈希码，其值就是对象的存储地址，
         * 这个方法在Object类中声明，因此所有的子类都含有该方法。那我们先来认识一下hashCode()这个方法吧。
         */
        Map<String, Value> map1 = new HashMap<>();
        String s1 = "1";
        String s2 = "1";
        map1.put(s1, value);
        System.out.println("s1.equals(s2):"+s1.equals(s2));
        System.out.println("map1.get(s1):"+map1.get(s1));
        System.out.println("map1.get(s2):"+map1.get(s2));

        Map<Key, Value> map2 = new HashMap<>();
        Key key1 = new Key("1");
        Key key2 = new Key("1");
        map2.put(key1, value);
        System.out.println("key1.equals(key2):"+key1.equals(key2));
        System.out.println("map2.get(key1):"+map2.get(key1));
        System.out.println("map2.get(key2):"+map2.get(key2));

        System.out.println("-----------------------");



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

    static class Key{
        private String k;
        public Key(String key){
            this.k=key;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Key){
                Key key=(Key)obj;
                return k.equals(key.k);
            }
            return false;
        }
    }

    static class Value{
        private int v;

        public Value(int v){
            this.v=v;
        }

        @Override
        public String toString() {
            return "类Value的值－－>"+v;
        }
    }

}
