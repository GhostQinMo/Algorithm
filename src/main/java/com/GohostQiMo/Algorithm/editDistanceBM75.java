package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Black_ghost
 * @title: editDistanceBM75
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-17 11:36:43
 * @Description 牛客101  BM75 编辑距离(一)
 **/
@Slf4j
public class editDistanceBM75 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str1 string字符串
     * @param str2 string字符串
     * @return int整型
     */
    //动态规划经典例题
    public int editDistance (String str1, String str2) {
        //动规五部曲：1.确定dp数组和dp数组中索引和值的含义
        //这里采用二位dp数组，为什么呢？因为对于两个字符串的比较一般是二维dp数组(经验所得)
        int len1 = str1.length();
        int len2 = str2.length();
        //这里dp[i][j]表示子串str1.substring(0,i)（不包括i）与str2.substring(0,j)相等要操作的最小次数
        //这里为什么不包括i和j呢？原因是包括的话在这类问题上的初始话操作很麻烦
        int[][] dp = new int[len1 + 1][len2 + 1];

        //dp五部曲：3.初始化操作  （明白dp[i][j]）表示什么意思
        //如果dp[i][0]表示 str1.substring(0,i)（不包括i）与str2.substring(0,j),str2区间是一个空串，所以直接等于str1的长度
        //初始化第一行
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        //初始化第一列
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        //dp五部曲： 4.遍历顺序，自己画个图，用推导公式一下就推出来了（这里从左至右从上至下）
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                //dp五部曲：2.确定dp推导公式（dp方程）
                //分为两种情况，i-1位置与j-1位置上的字符相等和不相等的情况
                //相等 （无需操作）
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //不相等又分为种情况一：1.删除str1当前元素，2.删除str2当前元素 3.删除str1和str2当前元素
                    int temp1 = Math.min(dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1); //这里是由于删除str1和str2当前元素包括在前面两个中了，所以忽略    dp[i][j-1]+1=d[i-1][j-1]+2;
                    //（因为添加一个元素和删除一个元素的操作次数是一样的，这里没有考虑添加了）
                    //              情况二：替换当前元素使之相等
                    int temp2 = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(temp1, temp2);
                }
            }
        }
        //dp五部曲：5.推导dp数组，打印dp数组
        for (int[] temp:dp) {
            System.out.println(Arrays.toString(temp));
        }
        return dp[len1][len2];
    }

    //dp五部曲：5.打印dp数组
    @Test
    public void test01(){
        final int min_ops = editDistance("hores", "ros");
        System.out.println("min_ops = " + min_ops);
    }
}
