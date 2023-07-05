package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: combinationSum40337
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-05 21:40:58
 * @Description 力扣0337组合总和IV
 **/
@Slf4j
public class combinationSum40337 {
    @Test
    public void test01(){
        int[] nums={1,2,3};
        final int i = combinationSum4(nums, 4);
        System.out.println("i = " + i);
    }
    /**
     * 完全背包排列问题（注意遍历顺序先背包后物品即可）
     *
     * @param nums
     * @param target
     * @return
     */
    //如果本题要把排列都列出来的话，只能使用回溯算法爆搜。
    //做到这里我已经完全熟悉了dp和背包问题，所有什么dp五部曲没写了
    public int combinationSum4(int[] nums, int target) {
        //确定dp数组和初始化
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //确定遍历顺序
        for (int j = 0; j <=target ; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >=nums[i]){
                    dp[j]+=dp[j-nums[i]];
                }
            }
        }
        //返回结果
        return dp[target];
    }
}
