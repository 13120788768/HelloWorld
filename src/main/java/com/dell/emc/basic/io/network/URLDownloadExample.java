package com.dell.emc.basic.io.network;

import com.dell.emc.basic.io.IOConstant;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 *
 * class URL
 * 日常使用频率比较高的类，
 *
 * 它可以直接从 URL 中读取字节流数据,通常是一个网络通道地址,e.g.实现一个下载功能
 *  1. download index.html
 *  2. download a pic
 */
public class URLDownloadExample {

    public static void main(String[] args) throws Exception{
        // download html page
        URL url = new URL(IOConstant.URL_EXAMPLE_PROTOCOL);

        // create the input stream
        InputStream inputStream = url.openStream();
        // create the read stream
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");

        // create the read buffer object
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String currLine = "";
        FileOutputStream fileOutputStream = new FileOutputStream(IOConstant.WRITE_WITH_HTML_NEW);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        while ((currLine = bufferedReader.readLine()) != null) {
            outputStreamWriter.write(currLine);
            System.out.println("current line = " + currLine);
        }
        outputStreamWriter.flush();



        /**
         * 下载图片:
         *  1. 通过 网络地址获取网络资源的字节流
         *  2. 写入文件 - 创建文件输出流
         *  3. 通过 url打开输入流通道 imgUrl.openStream()
         *  4. 创建buffer缓冲区， 将字节写入buffer,
         *  5. 最后通过buffer缓冲区将内容写入目标输出流
         *  6. 关闭输出流通道
         */
        URL imgUrl = new URL("http://t7.baidu.com/it/u=4162611394,4275913936&fm=193&f=GIF");
        InputStream imgInputStream = new BufferedInputStream(imgUrl.openStream());
        FileOutputStream imgStream = new FileOutputStream(IOConstant.WRITE_WITH_PIC);

        byte[] buffer = new byte[1024];
        int currLength;
        while ((currLength = imgInputStream.read(buffer, 0 , buffer.length)) != -1) {
            imgStream.write(buffer, 0, currLength);
            System.out.println("currLength=" + currLength + ", buffer = " + buffer);
        }
        imgStream.flush();


        // -----------------------close-----------------------

        inputStream.close();
        inputStreamReader.close();
        bufferedReader.close();

        fileOutputStream.close();
        outputStreamWriter.close();

        imgInputStream.close();
        imgStream.close();
    }
}
