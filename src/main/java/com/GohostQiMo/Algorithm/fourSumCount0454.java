package com.GohostQiMo.Algorithm;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Black_ghost
 * @title: fourSumCount0454
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-29 08:32:16
 * @Description 力扣 454. 四数相加 II
 **/
public class fourSumCount0454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //题目：这里需要统计的是有多少种就可以了，而不需要考虑索引问题
        //先统计nums1数组和nums2数组这两个数组组合有多少种结果，已经相同结果的个数
        Map<Integer,Integer> cantainer=new HashMap();
        for(int num1 : nums1){
            for(int num2 : nums2){
                //key为两数之和，value为有多少种组合
                cantainer.put(num1+num2,cantainer.getOrDefault(num1+num2,0) +1);
            }
        }
        int result=0;
        //查看0-num3-num4是否在map中出现，然后统计结果
        for(int num3:nums3){
            for(int num4:nums4){
                result+=cantainer.getOrDefault(-num3 - num4,0);
            }
        }
        return result;
    }


    @Test
    public void test01(){
        int[] nums1={1,2};
        int[] nums2={-2,-1};
        int[] nums3={-1,2};
        int[] nums4={0,2};
        System.out.println(fourSumCount(nums1,nums2,nums3,nums4));
    }


}
