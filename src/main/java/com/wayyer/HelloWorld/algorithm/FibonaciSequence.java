package com.wayyer.HelloWorld.algorithm;

/**
 * @Author: wayyer
 * @Description: the fibonacci algorithm
 * 斐波纳契数列以如下被以递归的方法定义：F(0)=0，F(1)=1, F(n)=F(n-1)+F(n-2)（n>=2，n∈N*）
 * @Program: HelloWorld
 * @Date: 2019.05.10
 */
public class FibonaciSequence {

    //斐波纳契数列以如下被以递归的方法定义：F(0)=0，F(1)=1, F(n)=F(n-1)+F(n-2)（n>=2，n∈N*）

    //the direct way to print out the array
    public static void fib(){
        //定义第一个加数a，初始值为1；定义第二个加数b，初始值为1；定义两个加数之和为c，初始值为0
        int a = 1;
        int b = 1;
        int c = 0;

        for (int i = 3; i < 10; i++) {
            //第三个数即为c，a+b等于c的值
            c = a + b;
            //将第一个加数a赋值为数列中的第二个数b的值
            a = b;
            //将第二个加数b赋值为数列中的第三个数c的值
            b = c;
            //在第二次循环打印时，将打印数列中的第四个数为：b + c = b + (a + b)
            System.out.print(c + "\t");
        }

    }


    public static void fibOptimized(){
        int a = 1;
        int b = 1;
        for(int i = 1;i <= 5;i++) {
            //循环打印a,b两个数，即两个两个打印
            System.out.print(a + "\t" + b + "\t");
            //打印第三、四个数
            a = a + b;
            b = a + b;
        }
    }

    public static void fibByArray(){
        //建立一个长度为10的数组用于存放数列中的数
        int[] arr = new int[10];
        //先定义数列中的第一个和第二个数
        arr[0] = 1;
        arr[1] = 1;
        //建立一个for循环，打印数组中的元素
        for(int i = 0;i < arr.length;i++) {
            //判断：当打印第三个数前，给第三个数赋值
            if(i > 1) {
                arr[i] = arr[i - 2] + arr[i - 1];
            }
            System.out.print(arr[i] + "\t");
        }
    }


    //建立一个函数，用于计算数列中的每一项
    public static int fib(int num) {
        int sum = num;
        //判断：是否是第一个数和第二个数
        if(num == 1 || num == 2) {
            return 1;
        }else {
            //循环调用本函数
            return fib(num - 2) + fib(num - 1);
//            sum = sum+fib(num -1);
//            return sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(fib(7));
    }

}
