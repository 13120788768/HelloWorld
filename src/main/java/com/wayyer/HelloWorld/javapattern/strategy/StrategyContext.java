package com.wayyer.HelloWorld.javapattern.strategy;


import java.util.Hashtable;
import java.util.Objects;

/**
 * @Author: wayyer
 * @Description: the context of strategy
 * @Program: HelloWorld
 * @Date: 2019.05.13
 */
public class StrategyContext {
    private IStrategy strategy;

    public StrategyContext(IStrategy strategy) {
        //Objects.hash()
        this.strategy = strategy;
    }

    public void context(){
        strategy.provideService();
    }
}
