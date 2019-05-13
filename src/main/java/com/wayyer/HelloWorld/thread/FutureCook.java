package com.wayyer.HelloWorld.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: wayyer
 * @Description: future task to implement
 * @Program: HelloWorld
 * @Date: 2019.05.12
 */
public class FutureCook {

    /**
     * 这个继承体系中的核心接口是Future。
     * Future的核心思想是：一个方法f，计算过程可能非常耗时，等待f返回，
     * 可以在调用f的时候，立马返回一个Future，可以通过Future这个数据结构去控制方法f的计算过程。
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        long startTime = System.currentTimeMillis();

        Callable<Tools> callable = new Callable<Tools>() {
            @Override
            public Tools call() throws Exception {
                System.out.println("    Callable BuyCookingTools.Tools 第一步：下单");
                System.out.println("    Callable BuyCookingTools.Tools 第一步：等待送货");
                try {
                    Thread.sleep(5000);  // 模拟送货时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("    Callable 5000mills later BuyCookingTools：快递送到");
                return new Tools();
            }
        };

        FutureTask<Tools> task = new FutureTask<>(callable);

        new Thread(task).start();

        System.out.println("step2 - wait 2000 millis");
        Thread.sleep(2000);
        System.out.println("step2 - completed\n");

        //第一步未完成处理
        while(!task.isDone()){
            System.out.println("isDone------- cost " + (System.currentTimeMillis() - startTime) + "ms");
            System.out.println("step3 - tools还没到，心情好就等着（心情不好就调用cancel方法取消订单）");
            Thread.sleep(3);
        }
        System.out.println("step4 - tools到了");
        Tools tools = task.get();
        cook(tools);

        System.out.println("ended------- cost " + (System.currentTimeMillis() - startTime) + "ms");

    }

    // 厨具类
    static class Tools {}

    private static void cook(Tools... tools){
        for (int i = 0; i < tools.length; i++) {
            System.out.println("Tools = "+ tools[i]);
        }
        System.out.println("Tools cook completed");
    }

}
