package com.wayyer.HelloWorld.thread;

/**
 * @Author: wayyer
 * @Description: bean
 * @Program: HelloWorld
 * @Date: 2019.05.12
 */
public class BuyCookingTools extends Thread {

    Tools tools;

    @Override
    public void run() {
        System.out.println("    BuyCookingTools 第一步：下单");
        System.out.println("    BuyCookingTools 第一步：等待送货");
        try {
            Thread.sleep(5000);  // 模拟送货时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tools = new Tools();
        System.out.println("    5000mills later BuyCookingTools：快递送到");
    }

    // 厨具类
    static class Tools {}
}
