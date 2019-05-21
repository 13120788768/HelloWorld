package com.wayyer.HelloWorld.annotation;

/**
 * @Author: wayyer
 * @Description: test MyAnnotation
 * @Program: HelloWorld
 * @Date: 2019.05.21
 */
@MyAnnotation
public class MyAnnotationTest {

    public static void main(String[] args) {
        info(MyAnnotationTest.class);
    }


    public static void info(Class clazz) {
        System.out.println(clazz.getName());
        System.out.println("MyAnnotation is annotation = " + MyAnnotation.class.isAnnotation());
        System.out.println("MyAnnotation is = " + MyAnnotationTest.class.getAnnotation(MyAnnotation.class));
//        boolean isExist = clazz.isAnnotationPresent(MyAnnotation.class);

//        MyAnnotation myAnnotation = (MyAnnotation) clazz.getAnnotation(MyAnnotation.class);
//        System.out.println("age = "+myAnnotation.age());
    }

}
