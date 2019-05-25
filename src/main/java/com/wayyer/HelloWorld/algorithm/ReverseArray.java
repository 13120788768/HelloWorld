package com.wayyer.HelloWorld.algorithm;

/**
 * @Author: wayyer
 * @Description: reverse
 * @Program: HelloWorld
 * @Date: 2019.05.23
 */
public class ReverseArray {


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,5};
        int[] arr1 = reverse1(arr);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }


        int[] arr2 = reverse2(arr);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr2[i]);
        }
    }


    /**
     * 定义一个新数组，把老数组中的元素反向添加到新数组中
     * @param array
     * @return
     */
    public static int[] reverse1(int[] array){
        int[] newArr = new int[array.length];
        for(int i=array.length-1;i>=0;i--){
            newArr[newArr.length - 1 - i] = array[i];
        }
        return newArr;
    }

    /**
     * 修改或者说翻转原数组
     * @param array
     * @return
     */
    public static int[] reverse2(int[] array){
        for(int i=0;i<array.length/2;i++){
            int temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = temp;
        }
        return array;
    }



}
