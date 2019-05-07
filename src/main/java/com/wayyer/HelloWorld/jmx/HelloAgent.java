package com.wayyer.HelloWorld.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
//import com.sun.jdmk.comm.HtmlAdaptorServer;
/**
 * @Author: wayyer
 * @Description: agent to test the jms
 * @Program: HelloWorld
 * @Date: 2019.05.07
 */
public class HelloAgent {

    /**
     * 1、首先在自己的本地路径下：
     * java bin找到jconsole
     * 打开我们的本地进程：HelloAgent
     * 程序中HelloMBean的属性赋值，也可以调用其中的方法：
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("jmxBean:name=hello");
        //create mbean and register mbean
        server.registerMBean(new Hello(), helloName);
        Thread.sleep(60*60*1000);


        //通过JMX提供的工具页访问
//        ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8082");
//        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
//        server.registerMBean(adapter, adapterName);
//        adapter.start();


    }

}
