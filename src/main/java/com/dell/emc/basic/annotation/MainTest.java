package com.dell.emc.basic.annotation;

import lombok.extern.log4j.Log4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MainTest {
    public static void main(String[] args) throws Exception {
        // 内置反射
        Class<?> annoClass = null;
        // 获取对象
        annoClass = Class.forName("com.dell.emc.basic.annotation.AnnotationExampleTest");

        // 判断是否存在注解log1
        boolean isAnnoAnnotationExample = annoClass.isAnnotationPresent(AnnotationExample.class);
        System.out.println("anno AnnotationExample exist: " + isAnnoAnnotationExample); // true

        if (isAnnoAnnotationExample) {
            // 获取注解
            AnnotationExample annotation = annoClass.getAnnotation(AnnotationExample.class);
            System.out.println("info ----" + annotation.info()); //获取当时作用在类上的注解原信息annotation info & AnnotationExampleTest

        }

        //Method 2
        /**
         * Method[] methods = annoClass.getDeclaredMethods(); 这个是获取目标类上定义的方法
         * 紧接着遍历了方法, boolean isAnnoLog = declaredMethod.isAnnotationPresent(Log1.class); 判断了方法上是否有 「注解」 标记。
         * 然后获取了注解， Constructor<?> constructor = annoClass.getConstructor();这个意思是获取类的构造器，用于下边的实例化。
         * Object obj = constructor.newInstance(); 实例化类。
         * declaredMethod.invoke(obj, annotation.info()) 意思是执行具体的方法，并传参。
         */
        // 获取方法
        Method[] methods = annoClass.getDeclaredMethods();
        // 方法遍历:
        for (Method declaredMethod : methods) {
            // 判断方法是否存在注解
            boolean isAnnoLog = declaredMethod.isAnnotationPresent(AnnotationExample.class);
            if (isAnnoLog) {
                AnnotationExample annotation = declaredMethod.getAnnotation(AnnotationExample.class);
                // 获取构造器
                Constructor<?> constructor = annoClass.getConstructor();
                // 实例化
                Object obj = constructor.newInstance();
                // 执行方法 - 将注解的数据执行进去
                System.out.println("methods= " + declaredMethod.invoke(obj, annotation.info()));
            } else {
                System.out.println("no annotation declared for methods= " + declaredMethod);
            }
        }
        /**
         * tip 每个类都有一个 「Class」 对象，包含了与类有关的信息。当编译一个新类时，会产生一个同名的 .class 文件，
         * 该文件内容保存着 Class 对象。 类加载相当于Class 对象的加载，类在第一次使用时才动态加载到 JVM 中。
         * 也可以使用 「Class.forName("xxx")」。这种方式来控制类的加载，该方法会返回一个 「Class」 对象。
         * 反射可以提供运行时的类信息，并且这个类可以在运行时才加载进来，甚至在编译时期该类的 「.class」 不存在也可以加载进来。
         *
         * Class 和 java.lang.reflect 一起对反射提供了支持，java.lang.reflect 类库主要包含了以下三个类：
         *
         * 「Field」 ：可以使用 get() 和 set() 方法读取和修改 Field 对象关联的字段；
         * 「Method」 ：可以使用 invoke() 方法调用与 Method 对象关联的方法；
         * 「Constructor」 ：可以用 Constructor 的 newInstance() 创建新的对象;
         */
    }
}
