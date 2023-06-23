package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Black_ghost
 * @title: nextPermutation
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-23 16:58:35
 * @Description 力扣0031 下一个排列
 **/
@Slf4j
public class nextPermutation {
    public static void main(String[] args) {

    }
    @Test
    public void nextPermutation(int [] nums){
        for (int i = nums.length-1; i >=0 ; i--) {
            for (int j = nums.length-1 ; j >i ; j--) {
                if (nums[j]>nums[i]){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    //这里排序是前开后闭
                    Arrays.sort(nums,i+1,nums.length);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }

}
