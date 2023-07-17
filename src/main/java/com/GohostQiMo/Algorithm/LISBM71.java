package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author Black_ghost
 * @title: LISBM71
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-16 16:57:50
 * @Description 牛客101  BM71 最长上升子序列(一)
 **/
@Slf4j
public class LISBM71 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 给定数组的最长严格上升子序列的长度。
     * @param arr int整型一维数组 给定的数组
     * @return int整型
     */
    //题解见： 力扣300
    public int LIS (int[] arr) {
        int len=arr.length;
        if(len==0){
            return 0;
        }
        int[] dp=new int[len];
        //初始化，因为每个元素自己就是一个上升子序列  即使是只有一个数的0也是递增序列
        int result=1;
        //fill函数不能传入null
        Arrays.fill(dp,1);
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(arr[i]> arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            if(dp[i]>result){
                result=dp[i];
            }
        }
        return result;
    }
}
