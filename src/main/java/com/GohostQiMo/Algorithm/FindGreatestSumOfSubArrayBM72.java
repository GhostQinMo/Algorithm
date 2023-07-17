package com.GohostQiMo.Algorithm;

/**
 * @author Black_ghost
 * @title: FindGreatestSumOfSubArrayBM72
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-16 17:25:12
 * @Description 牛客101  BM72 连续子数组的最大和
 **/
public class FindGreatestSumOfSubArrayBM72 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组
     * @return int整型
     */
    //这个用贪心写过，这里需要用动态规划
    public int FindGreatestSumOfSubArray (int[] array) {
        int len=array.length;
        //d五部曲：1.确定dp数组中的下标表示什么意思，以及dp数组中的元素表示什么意思
        // 这里dp[i]表示从头开始到array[i]（包含i）区间中的连续子数组的最大和
        int[] dp=new int[len];
        int max=array[0];
        dp[0]=array[0];
        for(int i=1;i<len;i++){
            dp[i]=Math.max(dp[i-1]+array[i],array[i]);
            if(dp[i] >max){
                max=dp[i];
            }
        }
        return max;
    }
}
