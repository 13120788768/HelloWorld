package com.dell.emc.basic.enumexample;

import lombok.Data;

import java.util.LinkedHashMap;

public class MainTest {
    public static void main(String[] args) throws Exception {

        EnumExample enumExample = EnumExample.RED;

        System.out.println(enumExample);

        for (EnumExample enumExample1: EnumExample.values()) {
            System.out.println(enumExample1.getName());
        }

        Test<String> test1 = new Test<>();
        test1.setName("name");
        test1.setup("a", "b", "c");
        System.out.println(test1.getName());
        System.out.println(test1.getValue());


        Test<Integer> test2 = new Test<>();
        test2.setName(1);
        System.out.println(test2.getName());

        LinkedHashMap<String, Object> hashMap = new LinkedHashMap();
    }

    @Data
    static class Test<C> {
        private C name;
        private String value;

        public void setup(String... str) {
            this.value = str[0];
        }
    }



}
