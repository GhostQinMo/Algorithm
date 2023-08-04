package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: canJump0055
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-03 16:05:50
 * @Description 力扣0055 跳跃游戏
 **/
@Slf4j
public class canJump0055 {
    @Test
    public void canJump0055Test(){
//        int[] nums = {2,3,1,1,4};
        int[] nums={3,2,1,0,4};
        System.out.println("canJump(nums) = " + canJump(nums));
    }

    public boolean  canJump(int[] nums){
        if (nums.length==1) return true;
        int conver=nums[0];
        //我开始没有看题解的写法：
        /*for (int i = 1; i <nums.length ; i++) {
            if (i+nums[i]>conver && i<=conver){
                conver=i+nums[i];
            }
            if (conver>=nums.length-1){
                return true;
            }
        }*/
        //题解之后的写法
        for (int i = 1; i <=conver; i++) {
            if (i+nums[i]>conver){
                conver=i+nums[i];
            }
            if (conver>=nums.length-1){
                return true;
            }
        }
        return false;
    }

}
