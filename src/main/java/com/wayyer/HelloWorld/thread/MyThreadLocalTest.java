package com.wayyer.HelloWorld.thread;

/**
 * @Author: wayyer
 * @Description: threadlocal demo
 * @Program: HelloWorld
 * @Date: 2019.05.20
 */
public class MyThreadLocalTest {


    /**
     * ThreadLocal没有被当前线程赋值时
     * 或当前线程刚调用remove方法后调用get方法，返回此方法值
     */
    private static final ThreadLocal<Object> threadLocal = new ThreadLocal<Object>(){
        @Override
        public Object initialValue(){

            System.out.println("调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值！");
            return null;
        }
    };

    public static void main(String[] args){
        new Thread(new MyIntegerThread("IntegerTask1")).start();
        new Thread(new MyStringThread("StringTask1")).start();
        new Thread(new MyIntegerThread("IntegerTask2")).start();
        new Thread(new MyStringThread("StringTask2")).start();
    }

    static class MyIntegerThread implements Runnable{

        private String threadName;

        public MyIntegerThread(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {

            for (int i = 0; i < 5; i++) {

                if(MyThreadLocalTest.threadLocal.get() == null){
                    // ThreadLocal.et方法设置线程变量
                    MyThreadLocalTest.threadLocal.set(0);
                    System.out.println("线程" + threadName + ": 0");
                }else {
                    int num = (Integer)MyThreadLocalTest.threadLocal.get();
                    MyThreadLocalTest.threadLocal.set(num + 1);
                    System.out.println("线程" + threadName + ": " + MyThreadLocalTest.threadLocal.get());
                    if(i == 3)
                    {
                        MyThreadLocalTest.threadLocal.remove();
                    }
                }
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }
        }
    }


    static class MyStringThread implements Runnable{

        private String threadName;

        public MyStringThread(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {

            for (int i = 0; i < 5; i++) {

                if(MyThreadLocalTest.threadLocal.get() == null){
                    // ThreadLocal.et方法设置线程变量
                    MyThreadLocalTest.threadLocal.set("a");
                    System.out.println("线程" + threadName + ": a");
                }else {
                    String string = (String)MyThreadLocalTest.threadLocal.get();
                    MyThreadLocalTest.threadLocal.set(string + "a");
                    System.out.println("线程" + threadName + ": " + MyThreadLocalTest.threadLocal.get());

                }
                try
                {
                    Thread.sleep(800);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }
        }
    }



}
