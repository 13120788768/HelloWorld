package com.wayyer.HelloWorld.javapattern.strategy;

/**
 * @Author: wayyer
 * @Description: test the strategy
 * @Program: HelloWorld
 * @Date: 2019.05.13
 */
public class StrategyClient {

    public static void main(String[] args) {
        //1.创建具体测策略实现
        IStrategy strategy = new Strategy2();
        StrategyContext context = new StrategyContext(strategy);
        context.context();
    }

}
