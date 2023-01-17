package com.dell.emc.basic.io.network;

import com.dell.emc.basic.io.IOConstant;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 核心类主要是以下:
 *
 * Datagram
 * DatagramSocket：通信类
 * DatagramPacket：数据包类(平时说的丢包啥的，丢的就是数据包)
 *
 *
 */
public class UDPDatagramSocketExample {


    /**
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // create a new data packet and bind to port
        DatagramSocket datagramSocket = new DatagramSocket(1001);
        System.out.println("binded port = " + datagramSocket.getLocalAddress());

        // create input stream
        FileInputStream fileInputStream = new FileInputStream(IOConstant.WRITE_WITH_PIC);
        byte[] buffer = new byte[1024 * 2];

        // use buffer stream to read the big data input stream
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        int currLength = 0;
        while( (currLength = bufferedInputStream.read(buffer, 0, buffer.length)) != -1) {
            // package the input to packet
            DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, currLength);
            // send out the message
            datagramPacket.setData(buffer);
            // set the address who sends this message
            datagramPacket.setAddress(InetAddress.getLocalHost());
            // set the port of the remote address
            datagramPacket.setPort(1002);
            datagramSocket.send(datagramPacket);
            System.out.println("UDP is sending out the message... buffer = " + buffer);

        }
        System.out.println("UDP sent messages completely! - Successfully!!!!");



        // 发完后发送一个结束的指令
        byte[] successData = "FILE sending is OK".getBytes(IOConstant.CHAT_SET_UTF8);
        DatagramPacket successPak = new DatagramPacket(successData, 0, successData.length);
        successPak.setAddress(InetAddress.getLocalHost());
        successPak.setPort(1002);
        datagramSocket.send(successPak);
        System.out.println("FILE sending is OK - Successfully!!!!");

        // create a packet with 1M size
        //DatagramPacket packet = new DatagramPacket(new byte[1024], 2014);
        //
        //packet.setAddress(InetAddress.getLocalHost());
        //packet.setPort(1002);

        // receive the packet - once not received, it will be blocked.
        //datagramSocket.receive(packet);
        // 获取数据
        //System.out.println(packet.getAddress() + " ---> "+ new String(packet.getData(), "UTF-8"));

        bufferedInputStream.close();
        fileInputStream.close();
        datagramSocket.close();

    }

}
