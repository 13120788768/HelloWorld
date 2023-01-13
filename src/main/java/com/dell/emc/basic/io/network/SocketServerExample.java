package com.dell.emc.basic.io.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server
 */
public class SocketServerExample {

    public static void main(String[] args) throws Exception{
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
                System.out.println("exception message=" + e.getMessage());
            }
        }
    }
}
