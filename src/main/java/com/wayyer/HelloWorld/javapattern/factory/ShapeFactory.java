package com.wayyer.HelloWorld.javapattern.factory;

/**
 * @Author: wayyer
 * @Description: factory
 * @Program: HelloWorld
 * @Date: 2019.06.11
 */
public class ShapeFactory {

    public static Shape getInstance(String shape){
        if(shape == null || "".equals(shape)){
            return new Default();
        }else if ("Circle".equalsIgnoreCase(shape)) {
            return new Circle();
        }else if ("Triangle".equalsIgnoreCase(shape)) {
            return new Triangle();
        }
        return new Default();
    }
}
