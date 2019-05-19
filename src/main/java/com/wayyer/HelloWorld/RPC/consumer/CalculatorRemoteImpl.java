package com.wayyer.HelloWorld.RPC.consumer;

import com.wayyer.HelloWorld.RPC.Calculator;
import com.wayyer.HelloWorld.RPC.CalculatorRequest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wayyer
 * @Description: implement of calculator
 * @Program: HelloWorld
 * @Date: 2019.05.19
 */
public class CalculatorRemoteImpl implements Calculator {

    public static int PORT = 9000;

    @Override
    public int add(int a, int b) throws Exception{
        /**
         * 分布式应用下，一个服务可能有多个实例，
         * 比如Service B，可能有ip地址为198.168.1.11和198.168.1.13两个实例，
         *
         * lookupProviders，其实就是在寻找要调用的服务的实例列表。
         * 在分布式应用下，通常会有一个服务注册中心，来提供查询实例列表的功能。
         */
        List<String> addressList = lookupProviders("Calculator.add");

        /**
         * 查到实例列表之后要调用哪一个实例呢，
         * 就需要chooseTarget了，其实内部就是一个负载均衡策略。
         */
        String address = chooseTarget(addressList);
        Socket socket = new Socket(address, PORT);

        // 将请求序列化
        CalculatorRequest calculateRpcRequest = generateRequest(a, b, "add");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

        /**
         * ObjectOutputStream的writeObject和
         * ObjectInputStream的readObject，来实现序列化和反序列化。
         */

        // 将请求发给服务提供方
        objectOutputStream.writeObject(calculateRpcRequest);

        // 将响应体反序列化
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Object response = objectInputStream.readObject();


        if (response instanceof Integer) {
                return (Integer) response;
            } else {
                throw new InternalError();
            }

    }

    public static List<String> lookupProviders(String remoteURL){
        return new ArrayList<>();

    }

    public static String chooseTarget(List<String> remoteAddr){
        return "127.0.0.1";
    }

    public static CalculatorRequest generateRequest(int a, int b, String method){

        return new CalculatorRequest(a, b, method);
    }

}
