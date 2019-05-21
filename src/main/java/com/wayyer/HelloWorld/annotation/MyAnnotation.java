package com.wayyer.HelloWorld.annotation;

/**
 * @Author: wayyer
 * @Description: annotation
 * @Program: HelloWorld
 * @Date: 2019.05.21
 */
public @interface MyAnnotation {

    String name() default "Cao Wei";

    int age() default 28;

}
