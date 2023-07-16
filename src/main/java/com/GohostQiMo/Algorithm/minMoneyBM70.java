package com.GohostQiMo.Algorithm;

/**
 * @author Black_ghost
 * @title: minMoneyBM70
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-16 16:21:15
 * @Description 牛客101  BM70 兑换零钱(一)
 **/
public class minMoneyBM70 {
    //完全背包问题 （注意遍历遍历顺序，是顺序，如果是01背包的话是逆序）
    public int minMoney (int[] arr, int aim) {
        //使用一维dp数组代替二维dp数组（滚动数组）
        int[] dp=new int[aim+1];
        //初始化，这里是找最小值不能初始化为0，初始化为最大值
        for(int i=0;i<=aim;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        dp[0]=0;
        for(int i=0;i<arr.length;i++){//先遍历物品是组合
            //j=arr[i]是了防止dp[j-arr[i]]的时候溢出
            for(int j=arr[i];j<=aim;j++){     //完全背包先序遍历
                if(dp[j-arr[i]]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j-arr[i]]+1,dp[j]);
                }
            }
        }
        return dp[aim]==Integer.MAX_VALUE ?-1 : dp[aim];
    }
}
