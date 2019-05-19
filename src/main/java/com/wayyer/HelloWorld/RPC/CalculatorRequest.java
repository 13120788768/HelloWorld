package com.wayyer.HelloWorld.RPC;

import java.io.Serializable;

/**
 * @Author: wayyer
 * @Description: the serializator of consumer and provider
 * @Program: HelloWorld
 * @Date: 2019.05.19
 */
public class CalculatorRequest implements Serializable {

    private int a;
    private int b;
    private String method;

    public CalculatorRequest(int a, int b){
        this.a = a;
        this.b = b;
    }

    public CalculatorRequest(int a, int b, String method){
        this(a, b);
        this.method = method;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

}
