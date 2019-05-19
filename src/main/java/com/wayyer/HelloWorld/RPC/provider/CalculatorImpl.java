package com.wayyer.HelloWorld.RPC.provider;

import com.wayyer.HelloWorld.RPC.Calculator;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wayyer
 * @Description: implement of calculator
 * @Program: HelloWorld
 * @Date: 2019.05.19
 */
public class CalculatorImpl implements Calculator {

    @Override
    public int add(int a, int b) throws Exception {
        return a+b;
    }
}
