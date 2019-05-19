package com.wayyer.HelloWorld.lock;

/**
 * @Author: wayyer
 * @Description: 不可重入锁demo
 * @Program: HelloWorld
 * @Date: 2019.05.17
 */
public class Lock {

    private boolean isLocked = false;

    public synchronized void lock() throws Exception{

        while(isLocked){
            wait();
        }
        isLocked = true;
    }


    public synchronized void unlock(){
        isLocked = false;
        notify();
    }




}
