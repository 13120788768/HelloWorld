package com.wayyer.HelloWorld.javapattern.prototype;

/**
 * @Author: wayyer
 * @Description:
 * @Program: HelloWorld
 * @Date: 2019.06.11
 */
public class Triangle extends Shape {

    public Triangle(){
        type = "Triangle";
    }


    @Override
    public void draw() {

        System.out.println("Triangle = draw");
    }
}
