package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: findTargetSumWayso494
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-05 17:41:58
 * @Description 力扣0494 目标和
 **/
@Slf4j
public class findTargetSumWayso494 {
    @Test
    public void test01(){
        int[] nums={1,1,1,1,1};
         int targetSumWays = findTargetSumWays(nums, 3);
        System.out.println("targetSumWays = " + targetSumWays);
    }

    /**
     * 将问题转换为01背包问题，使用动态规划解题
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        //将问题简化为左右两个集合求解，一个集合是正集合，一个集合是负集合，则有下面的关系
        //对nums求和
        int sum=0;
        //这里为什么不用担心求和不会溢出，因为题目给出规定，nums求和不会超过1000
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        //如果target绝对值太大，返回0
        if (Math.abs(target)> sum){
            return 0;
        }
        //求左正集合
         int result = (target + sum) / 2;
        //这里的result可以为负数啊
        result=Math.abs(result);
        //如果这个推到公式不等于0，则没有符合target的组合，返回0
        if ((target+sum)%2!=0 ){
            return 0;
        }
        //dp五部曲求解  //这里使用滚动数组啊  1. 确定dp[j]表示什么，以及j表示什么(背包的最大容量)
        int dp[]=new int[result+1];
        //3. 初始dp数组  这里初始化需要根据实际情况来定
        dp[0]=1;
        // 2. 确定递推公式
        //4. 确定遍历顺序（这里有是背包问题，且物品元素不能重复去，是01背包，所有采用先遍历物品，在逆序遍历背包保证不重复性）
        for (int i = 0; i < nums.length; i++) {
            //这里使用了一维的dp数组，要保证如果加入了nums[i]的时候的，背包剩余的容量还可以最多有几种装法
            //如果不懂，请看二维的01背包问题，哪个更加容易理解
            for (int j = result; j >=nums[i] ; j--) {
                dp[j]+=dp[j-nums[i]];
            }
        }
        //5.举例导出dp数组
        return dp[result];
    }
}
