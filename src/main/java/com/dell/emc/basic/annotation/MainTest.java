package com.dell.emc.basic.annotation;

import lombok.extern.log4j.Log4j;

public class MainTest {
    public static void main(String[] args) {
        // 内置反射
        Class<?> annoClass = null;
        try {
            // 获取对象
            annoClass = Class.forName("com.dell.emc.basic.annotation.AnnotationExampleTest");

            // 判断是否存在注解log1
            boolean isAnnoAnnotationExample = annoClass.isAnnotationPresent(AnnotationExample.class);
            System.out.println("anno AnnotationExample exist: " + isAnnoAnnotationExample); // true

            if (isAnnoAnnotationExample) {
                // 获取注解
                AnnotationExample annotation = annoClass.getAnnotation(AnnotationExample.class);
                System.out.println("info ----" + annotation.info());

            }
        } catch(Exception e) {
            System.out.println("info ----" + e.getMessage());
        }
    }
}
