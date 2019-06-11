package com.wayyer.HelloWorld.javapattern.factory;

/**
 * @Author: wayyer
 * @Description: main
 * @Program: HelloWorld
 * @Date: 2019.06.11
 */
public class DemoMain {

    /**
     * 定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。
     * @param args
     */
    public static void main(String[] args) {
        ShapeFactory.getInstance("Circle").draw();
        ShapeFactory.getInstance("Shape").draw();
        ShapeFactory.getInstance("triangle").draw();

    }
}
