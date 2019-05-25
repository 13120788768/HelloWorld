package com.wayyer.HelloWorld.algorithm;

/**
 * @Author: wayyer
 * @Description: 合并两个有序数组，合并后仍然有序
 * @Program: HelloWorld
 * @Date: 2019.05.25
 */
public class MergedTwoSortedArrays {

    /**
     * 合并两个有序数组，合并之后仍然有序
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {2,3,5,7,8,10};
        int[] c = new int[a.length+b.length];
        int lengthA = a.length;
        int lengthB = b.length;

        int indexA = 0;
        int indexB = 0;
        int indexC = 0;

        while(indexA < lengthA && indexB < lengthB){
            if(a[indexA] < b[indexB]){
                c[indexC++] = a[indexA++];
            }else{
                c[indexC++] = b[indexB++];
            }
        }

        while(indexA < lengthA){
            c[indexC++] = a[indexA++];
        }
        while (indexB < lengthB) {
            c[indexC++] = b[indexB++];
        }

        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]+",");
        }
    }


}
