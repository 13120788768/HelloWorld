package com.wayyer.HelloWorld.javapattern.strategy;

/**
 * @Author: wayyer
 * @Description: implements2 of strategy
 * @Program: HelloWorld
 * @Date: 2019.05.13
 */
public class Strategy2 implements IStrategy{


    @Override
    public void provideService() {
        System.out.println("Strategy2 - provideService");
    }
}
