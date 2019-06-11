package com.wayyer.HelloWorld.javapattern.prototype;

/**
 * @Author: wayyer
 * @Description:
 * @Program: HelloWorld
 * @Date: 2019.06.11
 */
public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Circle = draw");

    }
}
