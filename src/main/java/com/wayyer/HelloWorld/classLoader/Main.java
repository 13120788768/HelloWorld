package main.java.com.wayyer.HelloWorld.classLoader;

/**
 * @Author: wayyer
 * @Description: test loader
 * @Program: HelloWorld
 * @Date: 2019.04.22
 */
import java.lang.reflect.Method;

public class Main {

    ///Users/wcao12/HelloWorld/target/classes/main/java/com/wayyer/HelloWorld/classLoader
    public static void main(String args[]) throws Exception {
        MyClassLoader classLoader = new MyClassLoader("/Users/wcao12/HelloWorld/target/classes/main/");
        Class clazz = classLoader.loadClass("main.java.com.wayyer.HelloWorld.classLoader.Test");
        Object obj = clazz.newInstance();
        Method helloMethod = clazz.getDeclaredMethod("hello", null);
        helloMethod.invoke(obj, null);
    }
}
