package com.wayyer.HelloWorld.javapattern.factory;

/**
 * @Author: wayyer
 * @Description: default
 * @Program: HelloWorld
 * @Date: 2019.06.11
 */
public class Default implements Shape {


    @Override
    public void draw() {
        System.out.println("Default = draw a line as default!");
    }
}
