package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: maxProfit0112
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-04 16:37:18
 * @Description 力扣 122. 买卖股票的最佳时机 II
 **/
@Slf4j
public class maxProfit0112 {
    /**
     * 说明：这个题我在牛客101几经写过了，这里只是复习一下，所以没有用动态规划来写了，直接使用贪心算法了
     * 如想看dp的可以去public class maxProfitBM81 这个类中看
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //贪心思路：将最大的利润拆分为多天的利润
        int len=prices.length;
        if(len==1){
            return 0;
        }
        int result=0;
        //第一天买入第一天卖出没有利润，所以这里直接从第二天开始
        for (int i=1;i<len;i++){
            int cur_profit=prices[i]-prices[i-1];
            if (cur_profit>0){
                result+=cur_profit;
            }
        }
        return result;
    }

    /**
     * 自测
     */
    @Test
    public void test01(){
        int[] nums={7,1,5,3,6,4};
         int maxProfit = maxProfit(nums);
         log.info("maxProfit={}",maxProfit);
    }
}
