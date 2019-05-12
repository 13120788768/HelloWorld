package com.wayyer.HelloWorld.javapattern.dispatcher;

/**
 * @Author: wayyer
 * @Description: service of assign tasks
 * @Program: HelloWorld
 * @Date: 2019.05.12
 */
public class Boss {

    /**
     * 委派模式就是静态代理和策略模式的一种特殊组合，
     * 代理模式注重的是过程，
     * 委派模式注重的是结果。
     * 策略模式注重的是可扩展（外部扩展），委派模式注重的是内部的灵活和复用。
     * @param args
     */
    public static void main(String[] args) {
        new LeaderDispatcher().doSomething("加密工作");
        new LeaderDispatcher().doSomething("解密工作");
        new LeaderDispatcher().doSomething("其他工作");
    }


}
