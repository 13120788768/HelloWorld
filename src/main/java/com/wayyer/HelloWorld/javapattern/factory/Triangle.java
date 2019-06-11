package com.wayyer.HelloWorld.javapattern.factory;

/**
 * @Author: wayyer
 * @Description: triangle
 * @Program: HelloWorld
 * @Date: 2019.06.11
 */
public class Triangle implements Shape {


    @Override
    public void draw() {
        System.out.println("Triangle = draw a triangle!");
    }
}
