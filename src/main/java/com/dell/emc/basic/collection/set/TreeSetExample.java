package com.dell.emc.basic.collection.set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 有序集合
 * 基于红黑树实现，支持有序性操作，
 * 例如根据一个范围查找元素的操作。但是查找效率不如 HashSet，
 *  HashSet 查找的时间复杂度为 O(1)，TreeSet 则为 O(logN)。
 */
public class TreeSetExample {

    public static void main(String[] args) {

        TreeSet<Integer> integers = new TreeSet<>();
        integers.add(1);
        integers.add(3);
        integers.add(2);
        integers.add(4);
        integers.add(5);
        integers.add(3);
        integers.add(1);

        // ordered, no duplicated.
        System.out.println(integers);

        // contains.
        System.out.println(integers.contains(5));
        System.out.println(integers.contains(6));

        // remove / removeAll
        System.out.println(integers.remove(5));
        System.out.println(integers.remove(6));
        System.out.println(integers.remove(5));
        System.out.println(integers.removeAll(new ArrayList<>()));

        // size()
        System.out.println(integers.size());
        System.out.println(integers.isEmpty());

        // first.
        System.out.println(integers.first());

        // last
        System.out.println(integers.last());

        //集合选取，在区间内选取元素, 包含from，不含to:
        System.out.println("integers.subSet="+integers.subSet(1, 2));
        //选取指定小于值的元素 「headSet()」 :
        System.out.println("选取指定小于值的元素 「headSet()」="+integers.headSet(4));

        System.out.println("integers=" + integers);
        //与之相反的是, 选取指定大于1, 「tailSet()」 :
        System.out.println("与之相反的是, 选取指定大于1, 「tailSet()」="+integers.tailSet(1));


        //返回迭代器对象 「iterator()」 :
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            System.out.println("返回迭代器对象 「iterator()」="+iterator.next());
        }

        //降序输出 「descendingIterator()」 , 同时迭代器对象也有方法:

        Iterator<Integer> itr = integers.descendingIterator();
        while (itr.hasNext()) {
            System.out.println("降序输出 「descendingIterator()」="+itr.next());
            // 迭代器删除 - 不报错
            itr.remove();

            // 原始删除 - 会报错 ConcurrentModificationException
            //integers.remove(itr.next());

            System.out.println(integers.size());
        }

        // clear.
        integers.clear();
        System.out.println(integers.isEmpty());
        System.out.println(integers.size());


    }
}
