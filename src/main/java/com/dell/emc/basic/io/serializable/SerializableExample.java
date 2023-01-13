package com.dell.emc.basic.io.serializable;

import com.dell.emc.basic.io.IOConstant;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Serializable
 * 一个对象想要被序列化，那么它的类就要实现此接口或者它的子接口。
 * 这个对象的所有属性（包括private属性、包括其引用的对象）都可以被序列化和反序列化来保存、传递。
 *
 * 不想序列化的字段可以使用transient修饰。
 *
 *
 * 由于Serializable对象完全以它存储的二进制位为基础来构造，因此并不会调用任何构造函数，
 * 因此Serializable类无需默认构造函数，但是当Serializable类的父类没有实现Serializable接口时，
 * 反序列化过程会调用父类的默认构造函数，因此该父类必需有默认构造函数，否则会抛异常。
 * 使用transient关键字阻止序列化虽然简单方便，但被它修饰的属性被完全隔离在序列化机制之外，
 * 导致了在反序列化时无法获取该属性的值，而通过在需要序列化的对象的Java类里
 *  加入writeObject()方法与readObject()方法可以控制如何序列化各属性，
 *      甚至完全不序列化某些属性或者加密序列化某些属性。
 *
 * 「序列化不会对静态变量进行序列化，因为序列化只是保存对象的状态，静态变量属于类的状态」
 *
 *
 * ArrayList 底层数据结构中的数组 elementData变量就是 「transient」,
 *  这么做主要是因为这个数组是动态扩展的，并不是所有的空间都被使用，因此就不需要所有的内容都被序列化。
 *  通过重写序列化和反序列化方法，使得可以只序列化数组中有内容的那部分数据
 * private transient Object[] elementData;
 *
 */
public class SerializableExample implements Serializable {
    /**
     * serialVersionUID 是实现 Serializable 接口而来的，
     *  而 Serializable 则是应用于Java 对象序列化/反序列化。
     * 对象的序列化主要有两种用途:
     *
     * 1. 把对象序列化成字节码，保存到指定介质上(如磁盘等)
     * 2. 用于网络传输
     *
     *
     * serialVersionUID 是 Java 为每个序列化类产生的版本标识，
     * 可用来保证在反序列时，发送方发送的和接受方接收的是可兼容的对象。
     *  如果接收方接收的类的 serialVersionUID 与发送方发送的 serialVersionUID 不一致，
     *      进行反序列时会抛出 InvalidClassException
     *
     */
    private static final long serialVersionUID = 1L;


    private int a;
    private String b;
    // transient means this field will not be serialized
    private transient String c;

    private static final String NAME = "Cao Wei - Jackie";

    public SerializableExample(int a, String b) {
        this.a = a;
        this.b = b;
        this.c = "transient string c";
    }

    public SerializableExample(int a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void main(String[] args) throws Exception{

        SerializableExample serializableExample = new SerializableExample(0, "serializableExample string b");

        /**
         * 序列化:
         *   1. 创建出输出流，即目标对象，比如磁盘
         *   2. 创建对象输出流
         *   3. 写入对象
         *   4. 关闭对象输出流
         */
        // create output stream: file
        FileOutputStream fileOutputStream = new FileOutputStream(IOConstant.WRITE_WITH_NEW);
        // create the object stream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(serializableExample);
        // 发现apple.txt文件打开后是乱码，因为被序列化了，对于敏感信息的对象可以使用序列化操作
        // file contents like:  �� sr 6com.dell.emc.basic.io.serializable.SerializableExample        I aL bt Ljava/lang/String;xp    t serializableExample string b

        /**
         *  反序列化
         *  与序列化相反:
         *    1. 创建输入流
         *    2. 创建对象输入流
         *    3. 读取对象
         *    4. 关闭对象输入流
         */
        // create input stream: file
        FileInputStream fileInputStream = new FileInputStream(IOConstant.WRITE_WITH_NEW);
        // create the target object stream
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        // read object
        SerializableExample seri = (SerializableExample) objectInputStream.readObject();

        // expectation =
        //SerializableExample{a=0, b='serializableExample string b', c='null', name='Cao Wei - Jackie'}
        // c is not serialized by using transient, hence c=null
        // 「序列化不会对静态变量进行序列化，因为序列化只是保存对象的状态，静态变量属于类的状态」
        // name='Cao Wei - Jackie' 这个是toString()中 从类属性中获取name=xxx的，不是序列化的一部分。
        System.out.println(seri);


        fileOutputStream.close();
        objectOutputStream.close();
        fileInputStream.close();
        objectInputStream.close();

    }

    @Override
    public String toString() {
        return "SerializableExample{" +
                "a=" + a +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", name='" + NAME + '\'' +
                '}';
    }
}
