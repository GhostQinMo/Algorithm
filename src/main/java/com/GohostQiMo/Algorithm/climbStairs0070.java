package com.GohostQiMo.Algorithm;

import org.junit.Test;

/**
 * @author Black_ghost
 * @title: climbStairs0070
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-05 14:01:34
 * @Description 力扣0070 爬楼梯
 **/
public class climbStairs0070 {
    @Test
    public void test01() {
        final int i = climbStairs(3);
        System.out.println("i = " + i);
    }

    /**
     * 动态规划今典例题  dp五部曲
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n==1){
            return 1;
        }
        //dp五部曲 1. 确定dp数组下标表示什么意思以及dp数组中的数值表示什么（这表示楼梯层数，数值表示爬到这层的方法数）
        int dp[] = new int[n+1];
        //dp五部曲 3. 初始化dp数组
        dp[0] = 0; //题目给出了n是一个正整数，0不是正整数，所以这不需要考虑他
        dp[1] = 1;
        dp[2] = 2;
        //dp五部曲 2.确定dp递推公式（三层=二层在跳一步+一层在跳两步）
        //pd五部曲 4.确定遍历顺序（这里是一维dp数组，直接从左至右）
        //dp五部曲 5.自己推到dp数组（自己在纸上举一个案例看看对不对）
        for (int i = 3; i <=n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
