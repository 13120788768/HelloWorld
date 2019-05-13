package com.wayyer.HelloWorld.thread;

/**
 * @Author: wayyer
 * @Description: use common steps to demonstrate the thread
 * @Program: HelloWorld
 * @Date: 2019.05.12
 */
public class CommonCook {

    /**
     * join() keep all the child thread sequenced
     * join方法阻塞主线程
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        //1.第一步 网购厨具
        System.out.println("step1 - buyCookingTools");
        BuyCookingTools buyCookingTools = new BuyCookingTools();
        buyCookingTools.start();
        buyCookingTools.join();
        cook(buyCookingTools.tools);
        System.out.println("step1 - buyCookingTools thread completed\n");

        System.out.println("step2 - wait 2000 millis");
        Thread.sleep(2000);
        System.out.println("step2 - completed\n");

        System.out.println("step3 - buyCookingTools2");
        BuyCookingTools buyCookingTools2 = new BuyCookingTools();
        buyCookingTools2.start();
        buyCookingTools2.join();
        cook(buyCookingTools2.tools);
        System.out.println("step3 - buyCookingTools2 completed\n");
        System.out.println("step4 - cook");
        cook(buyCookingTools.tools, buyCookingTools2.tools);
        System.out.println("step4 - cook completed\n");


        System.out.println("ended------- cost " + (System.currentTimeMillis() - startTime) + "ms");

    }

    private static void cook(BuyCookingTools.Tools... tools){
        for (int i = 0; i < tools.length; i++) {
            System.out.println("BuyCookingTools = "+ tools[i]);
        }
        System.out.println("cooking completed");
    }
}
