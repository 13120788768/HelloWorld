package com.wayyer.HelloWorld.proxy.dynamicproxy;

import com.wayyer.HelloWorld.proxy.IUserService;

/**
 * @Author: wayyer
 * @Description: dynamic proxy
 * @Program: HelloWorld
 * @Date: 2019.05.07
 */
public class ProxyFactory {

    private IUserService userService;


    public ProxyFactory(IUserService userService) {
        this.userService = userService;
    }





}
