package com.wayyer.HelloWorld.proxy;

import com.wayyer.HelloWorld.proxy.dynamicproxy.ProxyFactory;
import com.wayyer.HelloWorld.proxy.staticproxy.UserService;
import com.wayyer.HelloWorld.proxy.staticproxy.UserServiceProxy;

/**
 * @Author: wayyer
 * @Description: test the dynamic proxy
 * @Program: HelloWorld
 * @Date: 2019.05.07
 */
public class DynamicProxyMainTest {

    /**
     * 动态代理Proxy类 newProxyInstance()
     *  代理类的类加载器，同目标类的类加载器
     *  代理类要实现的目标接口，同目标类的接口
     *  回调 InvocationHandler接口，当调用代理对象中的方法时候，执行invoke方法
     *@param args
     */
    public static void main(String[] args) {

        ProxyFactory.proxy();

    }

}
