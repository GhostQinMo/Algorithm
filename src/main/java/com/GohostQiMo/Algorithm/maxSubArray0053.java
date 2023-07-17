package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: maxSubArray0053
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-04 13:23:29
 * @Description 力扣0053 最大子数组和
 **/
@Slf4j
public class maxSubArray0053 {
    @Test
    public void test01(){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        final int i = maxSubArray(nums);
        System.out.println(i);
    }

    /**
     * 暴力求解   java存在超时
     * @param nums
     * @return
     */
    public int maxSubArray_force(int[] nums) {
        int maxValue=nums[0];
        for (int i = 0; i < nums.length; i++) {
            int temp=0;
            for (int j = i; j < nums.length; j++) {
                temp+=nums[j];
                maxValue=Math.max(temp,maxValue);
            }
        }
        return maxValue;
    }


    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        //这里为什么一定需要一个最小负数？ 因为数组中连续最大和就是有可能是负数。
        int maxvalue=Integer.MIN_VALUE;
        int temp=0;
        for (int i = 0; i < nums.length; i++) {
             temp+=nums[i];
             maxvalue=Math.max(maxvalue,temp);
             if (temp<0){
                 temp=0;
             }
        }
        return maxvalue;
    }


    /**
     * 复习动态规划5部曲
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length==1){
            return  nums[0];
        }
        int maxvalue=nums[0];
        //dp五部曲：1.确定dp数组下标的意思，这里 dp[i]表示包括i之前的最大连续子序列和
        int dp[]=new int[nums.length];
        //dp五部曲：3.初始化dp数组  这里需要根据问题场景来确定
        dp[0]=nums[0];
        //dp五部曲：4.确定遍历顺序，这个也需要根据实际问题场景来确定，例如（一维从左至右还是从右至左、二维则需要考虑更多）
        for (int i = 1; i < nums.length; i++) {
            //dp五部曲：2.确定dp公式
            //dp五部曲：5.推到dp数组（举一个案例实际推导一下）
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);   //这里结果只要最大数据没有说需要由哪些数组成的
            maxvalue=Math.max(dp[i],maxvalue);
        }
        return maxvalue;
    }


}
