package com.wayyer.HelloWorld.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wayyer
 * @Description: HanNuoTower
 * @Program: HelloWorld
 * @Date: 2019.04.10
 */
public class HanNuoTower {
    List<Double> douList = null;
    List<String> aaList = new ArrayList<>();
    List<Integer> intList = new ArrayList<>();
    static int i = 1;
    public static void move(int n, char x, char y, char z){
        if(n == 1){
            i++;
            System.out.println("共"+i);
            System.out.println("x -> y");
        }else{
            i++;
            move(n -1, x, z, y); // 将n-1 从x 借助z 移动到y
            System.out.println(x +" -> "+ z); //将第n 从x 移动到z
            move(n -1, y, x, z); // 将n-1 从y 借助x 移动到z
        }
    }

    public static void main(String[] ar){
        move(10, 'x', 'y', 'z');

    }

}
