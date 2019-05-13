package com.wayyer.HelloWorld.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

/**
 * @Author: wayyer
 * @Description: use future
 * a connection pool used by future with reusing the createConnection
 *  * 一个简单的数据库连接池，能够复用数据库连接，并且能在高并发情况下正常工作。
 *  https://www.cnblogs.com/cz123/p/7693064.html
 * @Program: HelloWorld
 * @Date: 2019.05.13
 */
public class FutureConnectionPool {
    private ConcurrentHashMap<String, FutureTask<Connection>> connectionPool =
            new ConcurrentHashMap<>();


    /**
     * 当3个线程同时进入else语句块时，各自都创建了一个FutureTask，但是ConcurrentHashMap只会加入其中一个。
     * 第一个线程执行pool.putIfAbsent方法后返回null，
     * 然后connectionTask被赋值，接着就执行run方法去创建连接，最后get。
     * 后面的线程执行pool.putIfAbsent方法不会返回null，就只会执行get方法。
     *
     * 在并发的环境下，通过FutureTask作为中间转换，成功实现了让某个方法只被一个线程执行。
     * @param key
     * @return
     * @throws Exception
     */
    public Connection getConnection(String key) throws Exception{
        FutureTask<Connection> connectionTask = connectionPool.get(key);
        if(connectionTask != null){
            return connectionTask.get();
        }else{

            Callable<Connection> callable = new Callable<Connection>() {
                @Override
                public Connection call() throws Exception {
                    return createConnection();
                }
            };

            FutureTask<Connection> newTask = new FutureTask<>(callable);
            connectionTask = connectionPool.putIfAbsent(key, newTask);
//            new Thread(newTask).start();
            if(connectionTask == null){
                connectionTask = newTask;
                connectionTask.run();
            }

            return connectionTask.get();
        }
    }


    public Connection createConnection() {
        return new Connection();
    }

    class Connection{

    }




}
