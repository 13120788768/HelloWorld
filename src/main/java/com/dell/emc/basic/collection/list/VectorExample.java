package com.dell.emc.basic.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 和 「ArrayList」 类似，但它是线程安全的
 *  key point is that it introduces the [synchronzied] to keep the sync
 *
 * Vector 是同步的，因此开销就比 ArrayList 要大，访问速度更慢。最好使用 ArrayList 而不是 Vector
 * Vector 每次扩容请求其大小的 2 倍（也可以通过构造函数设置增长的容量），而 ArrayList 是 1.5 倍
 */
public class VectorExample {

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();

    }
}
