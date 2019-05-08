package com.wayyer.HelloWorld.sort;

/**
 * @Author: wayyer
 * @Description: quick sort
 * @Program: HelloWorld
 * @Date: 2019.05.08
 */
public class QuickSort {

    void quickSort(int[] strs, int left, int right){


        int l = left;
        int r = right;
        int key = strs[left];

        while (l < r){

            //右边找小的
            while(strs[r]>=key && l<r){

                r--;
            }

            //左边找大的
            while(strs[l]<=key && l<r){
                l++;
            }

            if(l<r){
                int temp = strs[l];
                strs[l] = strs[r];
                strs[r] = temp;
            }
            strs[left] = strs[l];
            strs[l] = key;

            if(l > left){
                quickSort(strs, left, l-1);
            }

            if(r < right){
                quickSort(strs, r+1, right);
            }
        }
    }
}
