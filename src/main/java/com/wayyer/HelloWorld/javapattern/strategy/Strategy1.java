package com.wayyer.HelloWorld.javapattern.strategy;

/**
 * @Author: wayyer
 * @Description: implements of strategy
 * @Program: HelloWorld
 * @Date: 2019.05.13
 */
public class Strategy1 implements IStrategy{


    @Override
    public void provideService() {
        System.out.println("Strategy1 - provideService");
    }
}
