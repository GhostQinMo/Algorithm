package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: maxProfitBM80
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-18 14:37:58
 * @Description 牛客101  BM80 买卖股票的最好时机(一)
 **/
@Slf4j
public class maxProfitBM80 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param prices int整型一维数组
     * @return int整型
     */
    //贪心
    public int maxProfit_old (int[] prices) {
        int result=0;
        int cur_min=Integer.MAX_VALUE;   //取最大值
        if(prices.length==0){
            return 0;
        }
        for(int i=0;i<prices.length;i++){
            cur_min=Math.min(cur_min,prices[i]);
            result=Math.max(result,prices[i]-cur_min);
        }
        return result;
    }

    //dp
    //dp  当天存在两种状态持股（最大收益）和不持股（最大收益） 这里很难想到呀，既然需要一个二维数组
    public int maxProfit (int[] prices) {
        int len1=prices.length;
        if(len1==1){
            return 0;
        }
        //如果这里看不懂dp数组的含义请看题解，dp[i][j]表示第i天持股或者不持股的最大收益
        int[][] dp=new int[len1][2];
        dp[0][0]=0;dp[0][1]=-prices[0];
        for(int i=1;i<len1;i++){
            //如果当天为止不持股（没买或者卖了） 前一天未持股  今天卖了
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //如果当天持股（继续持有，或者买入）  持前一天的股  前面没有买，今天买 只能买一次
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
        }
        //这个股票最后一天肯定需要卖了
        return dp[len1-1][0];
    }

}
