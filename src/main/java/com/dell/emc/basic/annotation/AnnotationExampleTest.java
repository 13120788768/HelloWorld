package com.dell.emc.basic.annotation;

@AnnotationExample(info = "annotation info & AnnotationExampleTest")
public class AnnotationExampleTest {

    @AnnotationExample(info = "annotation info & AnnotationExampleTest with level method hello1")
    public String hello1(String msg) {
        System.out.println("动态设置 --- " +  msg);
        return "返回值---->" + msg;
    }

    @AnnotationExample(info = "annotation info & AnnotationExampleTest with level method hello2")
    public String hello2(String msg) {
        System.out.println("动态设置 --- " +  msg);
        return "返回值---->" + msg;
    }

    @AnnotationExample(info = "annotation info & AnnotationExampleTest with level method hello3")
    public String hello3(String msg) {
        System.out.println("动态设置 --- " +  msg);
        return "返回值---->" + msg;
    }

    public String noAnnotation(String msg) {
        System.out.println("动态设置 --- " +  msg);
        return "返回值---->" + msg;
    }

}
