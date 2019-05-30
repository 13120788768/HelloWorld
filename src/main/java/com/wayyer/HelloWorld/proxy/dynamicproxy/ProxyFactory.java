package com.wayyer.HelloWorld.proxy.dynamicproxy;

import com.wayyer.HelloWorld.proxy.IUserService;
import com.wayyer.HelloWorld.proxy.staticproxy.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: wayyer
 * @Description: dynamic proxy
 * @Program: HelloWorld
 * @Date: 2019.05.07
 */
public class ProxyFactory {

    private static IUserService userService = new UserService();

    public ProxyFactory(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 动态代理Proxy类 newProxyInstance()
     *  代理类的类加载器，同目标类的类加载器
     *  代理类要实现的目标接口，同目标类的接口
     *  回调 InvocationHandler接口，当调用代理对象中的方法时候，执行invoke方法
     *
     */
    public static void proxy(){
        IUserService proxy = (IUserService)Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("事务开始。。。");
                        Object result = method.invoke(userService, args);
                        System.out.println("事务开始。。。");
                        return result;
                    }
                });
        //代理对象
        proxy.eat();

    }

}
