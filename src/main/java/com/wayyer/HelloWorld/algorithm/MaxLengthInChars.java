package com.wayyer.HelloWorld.algorithm;

/**
 * @Author: wayyer
 * @Description: 文件中包含有各种字符，找出其中长度最长的数字串
 * @Program: HelloWorld
 * @Date: 2019.05.23
 */
public class MaxLengthInChars {

    public static void main(String[] args) {

        int size = 0; //记录当前数字串的长度
        int maxsize = 0;//保存最长数字串的长度
        int end = 0; //记录最大数字串的结束位置
        char[] inputstr = "123abc12".toCharArray();
        for (int i = 0; i < inputstr.length - 1; i++) {
                size = 0;//每一趟先把size置0

                //若是数字，则累加size
                while ('0' <= inputstr[i] && inputstr[i] <= '9') {
                    size++;
//                    i++;
                }

                //比较判断最大数字串的长度和结束位置
                if (size >= maxsize) {
                    maxsize = size;
                    end = i - 1;
                }
                i++;
        }
        System.out.println("maxsize = " +maxsize);
    }


}
