package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Black_ghost
 * @title: minNumberDisappearedBM53
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-13 21:45:27
 * @Description 牛客101  BM53 缺失的第一个正整数
 **/
@Slf4j
public class minNumberDisappearedBM53 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    //进阶:空间复杂度0(1),时间复杂度0(n
    public int minNumberDisappeared (int[] nums) {
        HashSet<Integer> container=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            container.add(nums[i]);
        }
        int result=1;
        while (container.contains(result)){
            result++;
        }
        return result;
    }
}
