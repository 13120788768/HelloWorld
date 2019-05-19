package com.wayyer.HelloWorld.javaio;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

/**
 * @Author: wayyer
 * @Description: NIO demo
 * @Program: HelloWorld
 * @Date: 2019.05.19
 */
public class NIOServer {

    private Selector selector;

    public void init(int port) throws Exception{

        //new serverSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //non-block
        serverSocketChannel.configureBlocking(false);

        //bind this serverSocketChannel with given port
        serverSocketChannel.socket().bind(new InetSocketAddress(port));

        this.selector = Selector.open();

        /**
         * register the selector in serverSocketChannel
         * with accept
         */
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

    }

    public void listen() throws Exception{

        while(true){
            //blocking until the register event is coming
            selector.select();

            Iterator iterator = selector.selectedKeys().iterator();

            while(iterator.hasNext()){

            }
        }



    }

}
