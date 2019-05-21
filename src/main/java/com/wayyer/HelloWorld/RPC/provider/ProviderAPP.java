package com.wayyer.HelloWorld.RPC.provider;

import com.wayyer.HelloWorld.RPC.Calculator;
import com.wayyer.HelloWorld.RPC.CalculatorRequest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: wayyer
 * @Description: the provider
 * @Program: HelloWorld
 * @Date: 2019.05.19
 */
public class ProviderAPP {

    private Calculator calculator = new CalculatorImpl();

    public static void main(String[] args) throws Exception {
        new ProviderAPP().run();
    }

    private void run() throws Exception{
        ServerSocket serverSocket = new ServerSocket(8099);

        while(true){
            Socket socket = serverSocket.accept();

            // 将请求反序列化
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object object = objectInputStream.readObject();

            // 调用服务
            int result = 0;
            if (object instanceof CalculatorRequest) {
                CalculatorRequest calculatorRequest = (CalculatorRequest) object;
                if ("add".equals(calculatorRequest.getMethod())) {
                    result = calculator.add(calculatorRequest.getA(), calculatorRequest.getB());
                } else {
                    throw new UnsupportedOperationException();
                }
            }

            // 返回结果
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(new Integer(result));
        }


    }
}
