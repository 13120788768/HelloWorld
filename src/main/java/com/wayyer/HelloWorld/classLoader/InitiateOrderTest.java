package main.java.com.wayyer.HelloWorld.classLoader;

/**
 * @Author: wayyer
 * @Description: test the static code and non-static
 * @Program: HelloWorld
 * @Date: 2019.04.22
 */
public class InitiateOrderTest {
    public static String STATIC_FIELD = "静态属性";
    public String field = "非静态属性";

    public InitiateOrderTest() {
        System.out.println("无参构造函数");
    }

    // 静态块
    static {
        System.out.println(STATIC_FIELD);
        System.out.println("静态代码块");
    }

    // 非静态块
    {
        System.out.println(field);
        System.out.println("非静态代码块");
    }


    public static void main(String[] a){
        new InitiateOrderTest();
        //静态属性
        //静态代码块
        //非静态代码块
        //无参构造函数
    }
}

