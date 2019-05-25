package com.wayyer.HelloWorld.algorithm;

import java.util.Scanner;

/**
 * @Author: wayyer
 * @Description: 给定N位数字的字符串，去掉k个数，返回最小的数，如N=6，k=4, "923781"，返回11
 * @Program: HelloWorld
 * @Date: 2019.05.23
 */
public class MinimumNumber {


    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,7,8,1};
        int[] minnum = min(num, 4);
//        num.
        for (int i = 0; i < num.length - 4; i++) {

            System.out.print(minnum[i]);
        }
    }



    public static int[] min(int[] num, int k){

        int[] nummi = new int[num.length-k];
        int min = 0;
        int p = 0;
        int q = 0;

        for (int i = 0; i < num.length - k; i++) {

            min = num[p];
            q = p+1;
            for (int j = p; j < k+i; j++) {
                if(num[j] < min){
                    min = num[j];
                    q = j;
                }
            }
            p = q;
            nummi[i] = min;
        }

        return nummi;
    }


}
