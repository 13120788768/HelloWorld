package com.wayyer.HelloWorld.algorithm;

import java.util.*;

/**
 * @Author: wayyer
 * @Description: find the n-th(first / second / third) maximum value of given string
 * @Program: HelloWorld
 * @Date: 2019.05.19
 */
public class JudgeCount {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("abc");
        list.add("abcd");
        list.add("ab");
        list.add("abc");
        list.add("abcd");
        list.add("abc");
        list.add("abcd");
        list.add("abcd");
        Map<Integer, String> map = judge(list, 1);
        System.out.println("map = " + map);

//        System.out.println("请输入你要判断的字符串:");
//        Scanner s = new Scanner(System.in);
//        String str = s.nextLine();
//        char[] ch = str.toCharArray();
//        Arrays.sort(ch); // 对数组排序
//        char max = 'a'; // 记录出现次数最多元素
//        int maxcount = 0; // 记录最大出现次数
//        int count = 1; // 中间传值参数 判断当前元素出现次数
//        for (int i = 0; i < ch.length - 1; i++) { // 进行判断
//            if (ch[i] == ch[i + 1]) {
//                count++;
//            }
//            if (ch[i] != ch[i + 1]) {
//                if (count > maxcount) {
//                    maxcount = count;
//                    max = ch[i];
//                }
//                count = 1;
//            }
//        }
//        System.out.println("出现最多的元素是:" + max + " 次数为:" + maxcount);



    }


    /**
     * 输出出现次数前n次的元素
     * @param list
     * @param n
     * @return
     */
    public static Map<Integer, String> judge(List<String> list, int n){
        Map<Integer, String> map = new HashMap<>();
        String maxString = "";

        String currentString = "";
        //最大次数
        int maxCount = 0;

        //当前元素出现次数
        int count = 1;
        Collections.sort(list);
        for (int i = 0; i < list.size() -1; i++) {
            currentString = list.get(i);
            System.out.println(i + " - " + currentString);
            if(list.get(i) == list.get(i+1)){
                count++;
            }else {

                if(count > maxCount){
                    maxCount = count;
                    maxString = currentString;
                }
                map.put(count, currentString);
                System.out.println("字符串 " + list.get(i) +"， 次数 = " + count);
                count = 1;
            }
        }
        System.out.println("出现最多的元素是:" + maxString + " 次数为:" + maxCount);

        return map;
    }

}
