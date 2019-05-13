package com.wayyer.HelloWorld.javapattern.dispatcher;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wayyer
 * @Description: the leader of employees
 * 从上面可以看出来委派模式就是静态代理和策略模式的一种特殊组合，代理模式注重的是过程，委派模式注重的是结果。
 * 策略模式注重的是可扩展（外部扩展），委派模式注重的是内部的灵活和复用。
 * @Program: HelloWorld
 * @Date: 2019.05.12
 */
public class LeaderDispatcher implements ITarget {
    private Map<String, ITarget> employees = new HashMap<>(2);

    public LeaderDispatcher() {
        employees.put("加密工作", new EmployeeA());
        employees.put("解密工作", new EmployeeB());

    }

    @Override
    public void doSomething(String command) {
        ITarget ta = this.employees.get(command);
        if(ta == null){
            employees.put(command, new EmployeeA());
        }
        this.employees.get(command).doSomething(command);
    }

}


