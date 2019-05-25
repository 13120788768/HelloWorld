package com.wayyer.HelloWorld.algorithm;

/**
 * @Author: wayyer
 * @Description: 给定字符串，顺时针输出为正方形
 *
 * 输入一行，4K（k (1, 9)）个字母
 * 输出K+1行，正方形内部空格填充
 *
 * @Program: HelloWorld
 * @Date: 2019.05.24
 */
public class SquareWithString {

    /**
     * （1）首先分析一共是4*K个字符，需要拼成的矩形字符是K+1行，且每行K+1个字符；
     * （2）按照行分类：第1行和K+1行比较特殊，需要单独实现；第2-K行规律类似，看成一种情况，共三种情况分析：line=1；line=K+1;1<line<K+1;(代码中行号从0开始）；
     *  (3) 第 1行：nums[0]---nums[K];第K+1行：nums[2*K]--nums[3*K]逆序；
     *      第2-K行：nums[len-lineNum+1],K-1个空格，nums[K+lineNum-1]
     * @param args
     */
    public static void main(String[] args) {

        String strings = "abcdefgh";
        //输入
        char[] stringArray = strings.toCharArray();

        //K 标识行数
        int k = stringArray.length / 4;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < k-1; i++) {
            stringBuffer.append("*");
        }

        String spaces = stringBuffer.toString();
        for (int i = 0; i < k+1; i++) {
            if(i == 0){
                System.out.println(strings.substring(0, k+1));
            }else if(i == k){
                System.out.println(new StringBuffer(strings.substring(2*k,3*k+1)).reverse().toString());
            }else{
                System.out.println(stringArray[4*k-i]+spaces+stringArray[k+i]);
            }
        }
    }

}
