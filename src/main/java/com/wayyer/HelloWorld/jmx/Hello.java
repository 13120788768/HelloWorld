package com.wayyer.HelloWorld.jmx;

/**
 * @Author: wayyer
 * @Description: hello
 * @Program: HelloWorld
 * @Date: 2019.05.07
 */
public class Hello implements HelloMBean{

    public void setHello(String hello) {
        System.out.println("Hello.setHello");
        System.out.println("hello = [" + hello + "]");
        System.out.println("hello = " + hello);
        this.hello = hello;
    }

    public String getHello() {
        return hello;
    }

    private String hello;



}
