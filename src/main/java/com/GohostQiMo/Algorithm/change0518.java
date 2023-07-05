package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: change0518
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-05 21:18:39
 * @Description 力扣0518 零钱兑换   完全背包的变种，dp解决
 **/
@Slf4j
public class change0518 {
    @Test
    public void test01(){
        int[] nums={1, 2, 5};
        final int change = change(5, nums);
        System.out.println("change = " + change);
    }

    /**
     * 完全背包的变种
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        //dp五部曲 1.确定dp数组（dp数组中的值表示什么，dp数组的下标表示什么）
        //dp数组表示当下标为i时，有dp[i]种组合方法可以组合成总数为i
        int[] dp=new int[amount+1];
        //dp五部曲 3.初始化dp数组，这里使用的是一维dp数组，dp[0]的初始化需要根据情况而定 这里初始化为1
        dp[0]=1;
        //dp五部曲 2. 确定递推公式
//        dp[j]+=dp[j-coins[i]];
        //dp五部曲 4.确定遍历顺序（这里是组合，先物品后背包，别问我怎么知道的，这里需要经验）
        for (int i = 0; i < coins.length; i++) {
            //这里为什么是从coins[i]开始，因为，小于conis[i]的背包装不下这个物品
            for (int j = coins[i]; j <=amount ; j++) {
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
        //推导dp数组

    }
}