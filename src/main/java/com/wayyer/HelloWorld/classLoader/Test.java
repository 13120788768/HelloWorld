package main.java.com.wayyer.HelloWorld.classLoader;

/**
 * @Author: wayyer
 * @Description: test class loader
 * @Program: HelloWorld
 * @Date: 2019.04.22
 */
public class Test {
    public void hello() {
        System.out.println("恩，是的，我是由 " + getClass().getClassLoader().getClass()
                + " 加载进来的");
        System.out.println("恩，是的，我父类加载器 " + getClass().getClassLoader().getParent()
                + " 加载进来的");
        System.out.println("恩，是的，我父类加载器 " + getClass().getClassLoader().getParent().getParent()
                + " 加载进来的");

    }

}
