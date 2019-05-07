package main.java.com.wayyer.HelloWorld.classLoader;

/**
 * @Author: wayyer
 * @Description: the parent class of InitiateOrderTest
 * @Program: HelloWorld
 * @Date: 2019.04.22
 */
public class ParentOrderTest {
    public static String PARENT_STATIC_FIELD = "父类-静态属性";

    // 父类-静态块
    static {
        System.out.println(PARENT_STATIC_FIELD);
        System.out.println("父类-静态代码块");
    }

    public static String parentField = "父类-非静态属性";

    // 父类-非静态块
    {
        System.out.println(parentField);
        System.out.println("父类-非静态代码块");
    }

    public ParentOrderTest() {
        System.out.println("父类—无参构造函数");
    }

    static class InitiateOrderTest extends ParentOrderTest {
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


        public static void main(String[] a) {
            new main.java.com.wayyer.HelloWorld.classLoader.InitiateOrderTest();
            //静态属性
            //静态代码块
            //非静态代码块
            //无参构造函数
        }
    }
}
