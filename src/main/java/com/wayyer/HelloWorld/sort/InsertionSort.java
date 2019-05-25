package com.wayyer.HelloWorld.sort;

/**
 * @Author: wayyer
 * @Description: insert sort
 * @Program: HelloWorld
 * @Date: 2019.05.08
 */
public class InsertionSort {

    /**
     * int i,j,v;
     *     for (i=1; i<n; i++) {
     * 　　　　  //如果第i个元素小于第j个，则第j个向后移动
     *         for (v=a[i], j=i-1; j>=0&&v<a[j]; j--)
     *             a[j+1]=a[j];
     *         a[j+1]=v;
     *     }
     * @param strs
     */
    void sort(int[] strs){
        int temp = 0;
        //iterate the array
        for (int i = 0; i < strs.length; i++) {

            //将后面的元素与前面的元素进行比较
            for (int v = strs[i], j = i-1; j >0 ; j--) {
                if(strs[i] > strs[j-1]){
                    temp = strs[j];
                    strs[j] = strs[j-1];
                    strs[j-1] = temp;
                }
                strs[j+1]=v;
            }

        }
    }
}
