package com.wayyer.HelloWorld.proxy.cglib;

import com.wayyer.HelloWorld.proxy.IUserService;
import com.wayyer.HelloWorld.proxy.staticproxy.UserService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: wayyer
 * @Description: cglib proxy
 * @Program: HelloWorld
 * @Date: 2019.05.30
 */
public class CglibProxyFactory {

    private static IUserService userService = new UserService();

    public static void proxy(){
        //cglib enhancer
        Enhancer enhancer = new Enhancer();

        //set up the class
        enhancer.setSuperclass(userService.getClass());

        //set up the call back
        /**
         * 当调用目标方法时候，实际上是调用该回调函数 intercept()
         * proxy 代理对象
         * method 目标方法
         * args 目标方法参数
         * methodProxy 代理方法
         *
         */
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib proxy 开始。。。");
                Object result = method.invoke(userService, args);
                System.out.println("cglib proxy 结束。。。");
                return result;
            }
        });

        //创建代理对象
        IUserService proxy = (UserService)enhancer.create();
        proxy.eat();

    }


}
