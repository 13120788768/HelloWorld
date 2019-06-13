package com.wayyer.HelloWorld.thread.daemon;

/**
 * @Author: wayyer
 * @Description: daemon test
 * @Program: HelloWorld
 * @Date: 2019.06.13
 */
public class DaemonThread implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DaemonThread());
        //thread.start();
//        thread.setDaemon(true);
        System.out.println("thread.isDaemon() = " + thread.isDaemon());
        thread.start();
        Thread.sleep(10);
        System.out.println("thread out!" );
    }


    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            System.out.println("1+1=" + (1+1));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
