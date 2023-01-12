package com.dell.emc.basic.io;

/**
 * 常见的编码格式:
 *
 * 「GBK」 编码中，中文字符占 2 个字节，英文字符占 1 个字节；
 * 「UTF-8」 编码中，中文字符占 3 个字节，英文字符占 1 个字节；
 * 「UTF-16be」 编码中，中文字符和英文字符都占 2 个字节。
 *
 * ::: tip char 类型占 16 位，也就是两个字节，Java 使用这种双字节编码是为了让一个中文或者一个英文都能使用一个 char 来存储 :::
 * 在调用无参数 「getBytes()」 方法时，默认的编码方式不是 **UTF-16be**。
 * 双字节编码的好处是可以使用一个 「char」 存储中文和英文，而将 「String」 转为 「bytes[]」 字节数组就不再需要这个好处，
 * 因此也就不再需要双字节编码。 「getBytes()」 的默认编码方式与平台有关，一般为 **UTF-8**。
 */
public class EncodeDecodeStringExample {

    public static void main(String[] args) throws Exception{
        String hello = "Hello 我是谁";
        System.out.println(hello);

        // encode UTF-8
        byte[] bytes = hello.getBytes("UTF-8");

        // decode with UTF-8
        String hello1 = new String(bytes, "UTF-8");
        System.out.println(hello1);

        // decode with GBK which would be something wrong
        String hello2 = new String(bytes, "GBK");
        System.out.println(hello2);
    }
}
