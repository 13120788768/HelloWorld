package com.dell.emc.basic.io.network;

import com.dell.emc.basic.io.IOConstant;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPDatagramSocketServerExample {

    public static void main(String[] args) throws Exception{
        // create a packet and binded to target port
        DatagramSocket socket = new DatagramSocket(1002);
        System.out.println("server address: " + socket.getLocalAddress());

        // create the output stream object
        FileOutputStream fileOutputStream = new FileOutputStream("./target/dog-udp.jpg");
        // create a output stream
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] buffer = new byte[1024];
        while (true) {
            // receive and unpackage the packet
            DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);
            datagramPacket.setPort(1001);
            datagramPacket.setAddress(InetAddress.getLocalHost());
            socket.receive(datagramPacket);

            // 判断是否接收到文件上传完毕指令
            if(new String(datagramPacket.getData(), "UTF-8").contains("FILE sending is OK")) {
                System.out.println("File received completed!-----Successfully!");
                break;
            }

            // write the file
            bufferedOutputStream.write(buffer, 0, buffer.length);
            bufferedOutputStream.flush();

            System.out.println("Receiving the file now...");
        }

        // set the response signal
        byte[] result = "我已经下载好了文件".getBytes(IOConstant.CHAT_SET_UTF8);
        DatagramPacket resPck = new DatagramPacket(result, 0, result.length);
        resPck.setPort(1001);
        resPck.setAddress(InetAddress.getLocalHost());
        // 发送数据给客户端 - 发包
        socket.send(resPck);
        System.out.println("UDPDatagramSocketServerExample result is sent.");

        // 关闭输出流
        bufferedOutputStream.close();
        System.out.println("bufferedOutputStream is closed.");
        socket.close();
    }
}
