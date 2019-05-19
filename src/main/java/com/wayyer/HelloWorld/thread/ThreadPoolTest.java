package com.wayyer.HelloWorld.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: wayyer
 * @Description: demo for thread pool
 * @Program: HelloWorld
 * @Date: 2019.05.19
 */
public class ThreadPoolTest {
    static int poolSize = 5;
    static ExecutorService executorService;

    public static void main(String[] args) throws Exception{
        Date date1 = new Date();


        //单线程的Executors
        executorService = Executors.newSingleThreadExecutor();

        //如果有可用的就重用；没有就创建一个新的并加入缓存。终止并移除60s未使用的线程
        executorService = Executors.newCachedThreadPool();

        //创建一个周期性的任务线程
        executorService = Executors.newScheduledThreadPool(poolSize);

        //固定大小的线程池
        executorService = Executors.newFixedThreadPool(poolSize);


        List<Future> list = new ArrayList<>();
        for (int i = 0; i < poolSize; i++) {

            Callable callable = new MyCallable("task "+i + ": ");
            Future future = executorService.submit(callable);
            list.add(future);

        }

        for(Future future: list){
            System.out.println("list = "+future.get().toString());
        }
//        list.forEach(future -> System.out.println(future));
        executorService.shutdown();

        //executorService.execute();
        System.out.println("总用时： " + (System.currentTimeMillis() - date1.getTime()));
    }


    static class MyCallable implements Callable {

        private String taskName;

        public MyCallable(String taskName){
            this.taskName = taskName;
        }

        @Override
        public Object call() throws Exception {
            System.out.println(">>>" + taskName + "任务启动");
            Date dateTmp1 = new Date();
            Thread.sleep(1000);
            Date dateTmp2 = new Date();
            long time = dateTmp2.getTime() - dateTmp1.getTime();
            System.out.println(">>>" + taskName + "任务终止");
            return taskName + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
        }
    }
}
