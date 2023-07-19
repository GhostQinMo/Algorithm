package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: maxAreaBM93
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-19 20:24:12
 * @Description 牛客101  BM93 盛水最多的容器
 **/
@Slf4j
public class maxAreaBM93 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param height int整型一维数组
     * @return int整型
     */
    //贪心策略+双指针 （思想很重要）
    public int maxArea (int[] height) {
        //排除不能形成桶的输入
        if(height==null || height.length<2){
            return 0;
        }
        int len1=height.length;
        //左右指针
        int left=0;
        int right=len1-1;
        int result=Integer.MIN_VALUE;
        while(left<right){
            //每一次计算当前容量，记录
            int interval=right-left;
            if(height[left]<height[right]){
                //木桶的短板效应  选取短边*下边距
                result=Math.max(interval*height[left],result);
                left++;
            }else{
                result=Math.max(interval*height[right],result);
                right--;
            }
        }
        return result;
    }
}
