package com.wayyer.HelloWorld.javapattern.factory;

/**
 * @Author: wayyer
 * @Description: one implement of shape
 * @Program: HelloWorld
 * @Date: 2019.06.11
 */
public class Circle implements Shape{


    @Override
    public void draw() {
        System.out.println("Circle = draw a circle!");
    }
}
