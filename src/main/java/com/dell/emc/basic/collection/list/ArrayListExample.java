package com.dell.emc.basic.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 有序，允许重复
 * 基于动态数组实现，支持随机访问
 * 与普通数组的区别就是它是没有固定大小的限制，我们可以添加或删除元素
 * ArrayList 继承了 AbstractList ，并实现了 List 接口
 *  非线程安全
 */
public class ArrayListExample {

    public static void main(String[] args) {
        ArrayList<Integer> s = new ArrayList<>();
        //添加元素 「add()」
        s.add(1);
        s.add(3);
        s.add(2);
        System.out.println(s);

        // get with index, from 0 -> size()-1
        System.out.println(s.get(1));

        // set, return old value
        System.out.println(s.set(0, 111));
        System.out.println(s);

        System.out.println(s.remove(0));
        System.out.println(s);
        System.out.println(s.size());

        for (int i=0; i<s.size(); i++) {
            System.out.println("index="+i + ", value=" + s.get(i));
        }

        // 线程安全
        // 可以使用 Collections.synchronizedList(); 得到一个线程安全的 ArrayList
        List<Integer> synList = Collections.synchronizedList(s);

        // concurrent 并发包下的 「CopyOnWriteArrayList」 类:
        List<String> list = new CopyOnWriteArrayList<>();
        /**
         * CopyOnWriteArrayList 在写操作的同时允许读操作，大大提高了读操作的性能，因此很适合读多写少的应用场景
         *缺陷:
         * 内存占用：在写操作时需要复制一个新的数组，使得内存占用为原来的两倍左右
         * 数据不一致：读操作不能读取实时性的数据，因为部分写操作的数据还未同步到读数组中
         * 所以 CopyOnWriteArrayList 不适合内存敏感以及对实时性要求很高的场景。
         */


        // mainly use ReetrantLock to keep sync. e.g. add()
        /**
         * final ReentrantLock lock = this.lock;
         *         lock.lock();
         *         try {
         *             Object[] elements = getArray();
         *             int len = elements.length;
         *             Object[] newElements = Arrays.copyOf(elements, len + 1);
         *             newElements[len] = e;
         *             setArray(newElements);
         *             return true;
         *         } finally {
         *             lock.unlock();
         *         }
         */

    }
}
