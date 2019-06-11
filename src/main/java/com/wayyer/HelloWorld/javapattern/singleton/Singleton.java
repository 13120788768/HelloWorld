package com.wayyer.HelloWorld.javapattern.singleton;

/**
 * @Author: wayyer
 * @Description: singleton
 * @Program: HelloWorld
 * @Date: 2019.06.11
 */
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton(){
    }

    /**
     * 双锁机制，安全且在多线程情况下能保持高性能。
     *
     * @return
     */
    public static Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    return new Singleton();
                }
            }
        }
        return singleton;
    }

}
