package com.wayyer.HelloWorld.mock;

/**
 * @Author: wayyer
 * @Description: entity
 * @Program: HelloWorld
 * @Date: 2019.05.28
 */
public class Person {

    private final int id;
    private final String name;
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
