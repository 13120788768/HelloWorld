package com.dell.emc.basic.io.network;

import com.dell.emc.basic.io.IOConstant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * socket
 * 听到 **socket**，大家都不陌生，但是到底啥是 socket呢？
 * 我们平时日常开发大部分都是处理 「http」 请求,这都是应用层的
 *
 * ::: tip 所谓套接字(Socket)，就是对网络中不同主机上的应用进程之间进行双向通信的端点的抽象。
 *  一个套接字就是网络上进程通信的一端，提供了应用层进程利用网络协议交换数据的机制。
 *  从所处的地位来讲，套接字上联应用进程，下联网络协议栈，是应用程序通过网络协议进行通信的接口，
 *  是应用程序与网络协议栈进行交互的接口 :::
 *
 * 套接字就是我们的 **socket**，还记得网络七层模型是哪七个吗？从下往上：
 * ::: tip 物理层（硬件） -> 数据链路层(网卡) -> 网络层(ip) -> 传输层 (tcp/udp ...)
 *          -> 会话层 -> 表示层 -> 应用层 :::
 *
 * 其中 「socket」 属于传输层(基于tcp/ip)，好了有多了一个概念，啥是tcp?
 *
 * TCP
 * 是一种面向连接的、可靠的、基于字节流的传输层通信协议，TCP 层是位于 IP 层之上，应用层之下的中间层。
 * TCP保障了两个应用程序之间的可靠通信。通常用于互联网协议，被称 TCP / IP。
 *
 * socket是基于应用服务与TCP/IP通信之间的一个抽象，他将TCP/IP协议里面复杂的通信逻辑进行分装，
 * 对用户来说，只要通过一组简单的API就可以实现网络的连接。
 *
 * UDP
 * 既然tcp是可靠的链接，那么有不可靠的吗？有
 *
 * 其中UDP是一种面向无连接的传输层协议。UDP不关心对端是否真正收到了传送过去的数据。
 * 如果需要检查对端是否收到分组数据包，或者对端是否连接到网络，则需要在应用程序中实现。
 * UDP常用在分组数据较少或多播、广播通信以及视频通信等多媒体领域。
 *
 *
 *
 * --------------------socket 编程实现------------------------------
 *
 * socket 编程实现
 * 套接字使用TCP提供了两台计算机之间的通信机制。
 *  客户端程序创建一个套接字，并尝试连接服务器的套接字。
 *  当连接建立时，服务器会创建一个 Socket 对象。客户端和服务器现在可以通过对各自 Socket 对象的写入和读取来进行通信。
 *
 * java.net.Socket 类代表一个套接字，
 *  并且 java.net.ServerSocket 类为服务器程序提供了一种来监听客户端，并与他们建立连接的机制。
 *  实现步骤：
 *   Server:
 *      服务器实例化一个 ServerSocket 对象，表示通过服务器上的端口通信
 *      服务器调用 ServerSocket 类的 accept() 方法，该方法将一直等待，直到客户端连接到服务器上给定的端口
 *      服务器正在等待时，一个客户端实例化一个 Socket 对象，指定服务器名称和端口号来请求连接
 *   Client:
 *      Socket 类的构造函数试图将客户端连接到指定的服务器和端口号。如果通信被建立，则在客户端创建一个 Socket 对象能够与服务器进行通信
 *      在服务器端，accept() 方法返回服务器上一个新的 socket 引用，该 socket 连接到客户端的 socket
 *      连接建立后，通过使用 I/O 流在进行通信，每一个socket都有一个输出流和一个输入流，客户端的输出流连接到服务器端的输入流，而客户端的输入流连接到服务器端的输出流。
 *
 * TCP 是一个双向的通信协议，因此数据可以通过两个数据流在同一时间发送
 *
 * Client
 */
public class SocketExample {

    public static void main(String[] args) throws Exception {
        // create a client with socket
        int port = 1000;
        String host = "localhost";

        // create
        Socket socket = new Socket(host, port);
        // 如果链接不上会报错  Connection refused (Connection refused)
        System.out.println("链接到远程主机地址： " + socket.getRemoteSocketAddress());

        // 获取套接字输出流
        OutputStream outputStream = socket.getOutputStream();
        // 建立数据输出流
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        // 写入数据 - 写入字符数据
        dataOutputStream.writeUTF("我是客户端 socket");



        // 获取服务端的响应
        // 获取输入流
        InputStream inputStream = socket.getInputStream();
        // 创建数据输入流
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        // 读取数据
        System.out.println("input is = "+dataInputStream.readUTF());

        // 关闭客户端
        socket.close();
    }


    public static void client() throws Exception {
        // create a client with socket
        int port = 1000;
        String host = IOConstant.URL_EXAMPLE;

        // create
        Socket socket = new Socket(host, port);
        // 如果链接不上会报错  Connection refused (Connection refused)
        System.out.println("链接到远程主机地址： " + socket.getRemoteSocketAddress());

        // 获取套接字输出流
        OutputStream outputStream = socket.getOutputStream();
        // 建立数据输出流
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        // 写入数据 - 写入字符数据
        dataOutputStream.writeUTF("我是客户端 socket");



        // 获取服务端的响应
        // 获取输入流
        InputStream inputStream = socket.getInputStream();
        // 创建数据输入流
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        // 读取数据
        System.out.println("input is = "+dataInputStream.readUTF());

        // 关闭客户端
        socket.close();

    }


    public static void server() throws Exception {
        // create server
        ServerSocket serverSocket = new ServerSocket(1000);
        // 设置超时时间 ms - 30s 内未收到消息自动退出
        serverSocket.setSoTimeout(30000);

        while(true) {
            try {
                System.out.println("等待远程连接---->" + serverSocket.getLocalPort()); // 等待远程连接---->1000

                // 获取服务端套接字
                Socket socket = serverSocket.accept();

                System.out.println("远程主机地址: ---->" + socket.getRemoteSocketAddress());

                // 获取客户端响应
                // 创建输入流
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                System.out.println("客户端说了: ---->" + dataInputStream.readUTF());

                // 发送消息给客户端
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.writeUTF("我收到了你的消息 / server Socket");

                socket.close();

// 相关输出:

//  服务端:
//                等待远程连接---->1000
//                远程主机地址: ---->/127.0.0.1:59773
//                客户端说了: ---->我是客户端 socket
//                等待远程连接---->1000
//                远程主机地址: ---->/127.0.0.1:59778
//                客户端说了: ---->我是客户端 socket
//                等待远程连接---->1000


// 客户端:
//                链接到远程主机地址： localhost/127.0.0.1:1000
//                我收到了你的消息 / server Socket
            } catch (Exception e) {
                System.out.println("exception");
            }
        }
    }
}
