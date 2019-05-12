package com.wayyer.HelloWorld.javapattern.dispatcher;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wayyer
 * @Description: the leader of employees
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


