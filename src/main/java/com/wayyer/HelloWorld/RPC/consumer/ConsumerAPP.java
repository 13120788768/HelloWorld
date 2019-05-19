package com.wayyer.HelloWorld.RPC.consumer;

import com.wayyer.HelloWorld.RPC.Calculator;

/**
 * @Author: wayyer
 * @Description: request the rpc main test
 * @Program: HelloWorld
 * @Date: 2019.05.19
 */
public interface ConsumerAPP {

    public static void main(String[] args) throws Exception {
        Calculator calculator = new CalculatorRemoteImpl();
        int result = calculator.add(1, 2);

    }

}
