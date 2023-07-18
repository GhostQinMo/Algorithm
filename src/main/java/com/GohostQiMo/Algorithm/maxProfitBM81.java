package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Black_ghost
 * @title: maxProfitBM81
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-18 15:16:26
 * @Description 牛客101  BM81 买卖股票的最好时机(二)
 **/
@Slf4j
public class maxProfitBM81 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算最大收益
     * @param prices int整型一维数组 股票每一天的价格
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        int len1=prices.length;
        if(len1==0){
            return 0;
        }
        //dp 数组的含义还是和买卖股票的最好时机I一样的一次，当天持股和不持股的最佳效益
        int[][] dp=new int[len1][2];
        //初始化
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<len1;i++){
            //不持股 （没买或者卖了） 本金
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //持股 （持有以前的，拿现有的本金买了）
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        for (int[] item: dp
             ) {
            System.out.println(Arrays.toString(item));
        }
        return dp[len1-1][0]; //最后一定是不持股的
    }
    //dp五部曲：打印dp数组
    @Test
    public void test01(){
        int[] nums=new int[]{1,2,3,4,5};
        final int max_value = maxProfit(nums);
        System.out.println("max_value = " + max_value);
    }
}
