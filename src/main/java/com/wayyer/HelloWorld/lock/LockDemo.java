package com.wayyer.HelloWorld.lock;

/**
 * @Author: wayyer
 * @Description: a test case to test the private lock
 * @Program: HelloWorld
 * @Date: 2019.05.17
 */
public class LockDemo {

    Lock lock = new Lock();

    /**
     * 当调用print()方法时，获得了锁，这时就无法再调用doAdd()方法，
     * 这时必须先释放锁才能调用，所以称这种锁为不可重入锁，也叫自旋锁。
     * @throws Exception
     */
    public void print() throws Exception{
        lock.lock();
        System.out.println("LockDemo print!!!");
        //doSomething();
        lock.unlock();

    }

    public void doSomething() throws Exception{
        lock.lock();
        System.out.println("LockDemo doSomething!!!");
        //print();
        lock.unlock();
    }

    public static void main(String[] args) throws Exception {
        LockDemo demo = new LockDemo();
        demo.print();

    }

}
