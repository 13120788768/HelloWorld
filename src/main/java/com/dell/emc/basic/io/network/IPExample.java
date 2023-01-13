package com.dell.emc.basic.io.network;

import com.dell.emc.basic.io.IOConstant;

import java.net.InetAddress;

/**
 * InetAddress 用于表示网络上的硬件资源，即 IP 地址
 */
public class IPExample {


    public static void main(String[] args) throws Exception {
        // can initiate instance with default
        InetAddress ip = InetAddress.getByName(IOConstant.URL_EXAMPLE);

        // instant ip=www.baidu.com/180.97.34.96
        System.out.println("ip=" + ip);
        // ipv4 get from local cache, not DNS server
        System.out.println("ip getHostAddress=" + ip.getHostAddress());

        // alias name for server
        System.out.println("ip getHostName=" + ip.getHostName());

        // real name from DNS server
        System.out.println("ip getCanonicalHostName=" + ip.getCanonicalHostName());








    }








}
