package com.wayyer.HelloWorld.algorithm;

/**
 * @Author: wayyer
 * @Description: 输入一行，包含一个字符串形式的正整数
 * 输出一行，找出所有拆分和变化后的组合
 * 输入123 输出是4
 * 说明：可能的组合：
 *  [1, 23] [12, 3]
 *  [1, 2.3] [1.2, 3]
 *
 *  输入0011 输出2
 *  说明：
 *  [0, 0.11] [0.01, 1]
 *
 * @Program: HelloWorld
 * @Date: 2019.05.24
 */
public class NumberAlgorithm {

    /**
     * 提供halfCount函数，统计当前段的符合规范的情况。
     * 首先：一位数，返回1；
     * 若开头和结尾都是0，则返回0；
     * 若开头或结尾有一个为0，则返回1；因为开头为0，只能为0.xxx；结尾为0，只能为整数；
     * 最后，可能情况就是字符的个数，如203：203,2.03,20.3
     */
    public static void main(String[] args) {
        String numString = "123456789";

        char[] numStringArray = numString.toCharArray();
        int count = 0;
        for (int i = 0; i < numStringArray.length - 1; i++) {
            int leftCount = halfCount(numStringArray, 0, i);
            if(leftCount == 0){
                continue;
            }
            int rightCount = halfCount(numStringArray, i+1, numStringArray.length-1);
            System.out.println("leftCount = " + leftCount +", rightCount = " + rightCount);
            count += leftCount*rightCount;
        }
        System.out.println("count = " + count);
    }

    public static int halfCount(char[] nums, int from, int end) {
        //一位数，1
        if(from == end){
            return 1;
        }
        if(nums[from] == '0' && nums[end] == '0'){
            return 0;
        }
        if(nums[from] == '0' || nums[end] == '0'){
            return 1;
        }
        return end -from +1;

    }

}
