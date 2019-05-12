package com.wayyer.HelloWorld.javapattern.dispatcher;

/**
 * @Author: wayyer
 * @Description: implement the ITarget
 * @Program: HelloWorld
 * @Date: 2019.05.12
 */
public class EmployeeA implements ITarget {

    @Override
    public void doSomething(String command) {

        System.out.println("I am EmployeeA, I doSomething "+  command);


    }
}
