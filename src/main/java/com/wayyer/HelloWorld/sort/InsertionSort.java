package com.wayyer.HelloWorld.sort;

/**
 * @Author: wayyer
 * @Description: insert sort
 * @Program: HelloWorld
 * @Date: 2019.05.08
 */
public class InsertionSort {

    void sort(int[] strs){
        int temp = 0;
        //iterate the array
        for (int i = 0; i < strs.length; i++) {

            //将后面的元素与前面的元素进行比较
            for (int j = i; j >0 ; j--) {

                if(strs[j] > strs[j-1]){
                    temp = strs[j];
                    strs[j] = strs[j-1];
                    strs[j-1] = temp;
                }else{
                    break;
                }

            }
        }
    }
}
