package com.wayyer.HelloWorld.proxy;

import com.wayyer.HelloWorld.proxy.cglib.CglibProxyFactory;
import com.wayyer.HelloWorld.proxy.dynamicproxy.ProxyFactory;

/**
 * @Author: wayyer
 * @Description: test the dynamic proxy
 * @Program: HelloWorld
 * @Date: 2019.05.07
 */
public class CglibProxyMainTest {

    /**
     * 当调用目标方法时候，实际上是调用该回调函数 intercept()
     * proxy 代理对象
     * method 目标方法
     * args 目标方法参数
     * methodProxy 代理方法
     *
     */
    public static void main(String[] args) {

        CglibProxyFactory.proxy();

    }

}
