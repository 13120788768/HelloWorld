package com.wayyer.HelloWorld.javapattern.prototype;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: wayyer
 * @Description: cache
 * @Program: HelloWorld
 * @Date: 2019.06.11
 */
public class ShapeCache {

    public static Map<String, Shape> shapeCache = new ConcurrentHashMap();

    public static Shape getShape(String shapeId){
        Shape shape = shapeCache.get(shapeId);
//        shape.clone();
        return shape;
    }


}
