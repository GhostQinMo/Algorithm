package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Black_ghost
 * @title: robBM78
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-18 09:40:24
 * @Description 牛客101  BM78 打家劫舍(一)
 **/
@Slf4j
public class robBM78 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int rob (int[] nums) {
        int result=0;
        if(nums==null || nums.length==0){
            return result;
        }
        int[] dp=new int[nums.length];
        //dp[i]初始化
        dp[0]=nums[0];
        //细节决定成败：注意越界
        if(nums.length==1){
            return nums[0];
        }
        dp[1]=Math.max(dp[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        //dp五部曲：5.打印dp数组验证是否合理（这也是检查错误的好办法）
        System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));
        return dp[nums.length-1];
    }


    @Test
    public void test01(){
        int[] nums=new int[]{2,10,5};
        final int rob = rob(nums);
        System.out.println("rob = " + rob);
    }
}
