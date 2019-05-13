package com.wayyer.HelloWorld.thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author: wayyer
 * @Description: connection pool
 * @Program: HelloWorld
 * @Date: 2019.05.13
 */
public class ConnectionPool {
    class Connection{

    }
    private ConcurrentHashMap<String, Connection> pool = new ConcurrentHashMap<>();

    /**
     * 我们用了ConcurrentHashMap，这样就不必把getConnection方法置为synchronized(当然也可以用Lock)，
     * 当多个线程同时调用getConnection方法时，性能大幅提升。
     *
     * 貌似很完美了，但是有可能导致多余连接的创建，推演一遍：
     *
     * 某一时刻，同时有3个线程进入getConnection方法，调用pool.containsKey(key)都返回false，
     * 然后3个线程各自都创建了连接。虽然ConcurrentHashMap的put方法只会加入其中一个，
     * 但还是生成了2个多余的连接。如果是真正的数据库连接，那会造成极大的资源浪费。
     *
     * 所以，我们现在的难点是：如何在多线程访问getConnection方法时，只执行一次createConnection。
     *
     * 结合之前Future模式的实现分析：当3个线程都要创建连接的时候，如果只有一个线程执行createConnection方法创建一个连接，其它2个线程只需要用这个连接就行了。再延伸，把createConnection方法放到一个Callable的call方法里面，然后生成FutureTask。我们只需要让一个线程执行FutureTask的run方法，其它的线程只执行get方法就好了。
     * @param key
     * @return
     */
    public Connection getConnection(String key){
        if(pool.containsKey(key)){
            return pool.get(key);
        }
        Connection connection = createConnection();
        pool.putIfAbsent(key, connection);
        return connection;
    }

    public Connection createConnection(){
        return new Connection();
    }




}
