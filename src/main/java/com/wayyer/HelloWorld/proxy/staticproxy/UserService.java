package com.wayyer.HelloWorld.proxy.staticproxy;

import com.wayyer.HelloWorld.proxy.IUserService;

/**
 * @Author: wayyer
 * @Description: implement of interface
 * @Program: HelloWorld
 * @Date: 2019.05.07
 */
public class UserService implements IUserService {

    @Override
    public void eat() {
        System.out.println("method eat() for implement of interface");
    }
}
