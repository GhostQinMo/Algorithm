package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: maxProfitBM82
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-18 16:07:34
 * @Description 牛客101  BM82 买卖股票的最好时机(三)
 **/
@Slf4j
public class maxProfitBM82 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 两次交易所能获得的最大收益
     * @param prices int整型一维数组 股票每一天的价格
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        // dp[i]0]表示到第i天为止没有买过股票的最大收益
        // dp[i][1]表示到第i天为止买过一次股票还没有卖出的最大收益
        // dp[i][2]表示到第i天为止买过一次也卖出过次股票的最大收益
        // dp[i][3)]表示到第i天为止买过两次只卖出过一次股票的最大收益
        // dp[i][4]表示到第i天为止买过两次同时也买出过两次股票的最大收益
        int len1=prices.length;
        if(len1==0){
            return 0;
        }
        int[][] dp=new  int[len1][5];
        //初始化
        dp[0][1]=-prices[0];
        dp[0][3]=-prices[0];  //初始化一定要细致，如果这里没有初始化的话，答案不正确
        //这个题只要你逻辑清楚，
        for(int i=1;i<len1;i++){
            //第一行已经初始化好了
            //dp[i][0]这个不需要管，因为是没买过一次
            // 买一次（继承上次的，或者自己买，用剩余的前）

            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
            //必须卖一次
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
            //必须买第二次
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            //必须卖第二次
            dp[i][4]=Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        }
        //返回没买过没买过的 、卖了一次买了一次  、卖了两次卖了两次的 最大值
        return Math.max(dp[len1-1][0],Math.max(dp[len1-1][2],dp[len1-1][4]));
    }

}
