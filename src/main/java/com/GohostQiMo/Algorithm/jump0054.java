package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: jump0054
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-03 16:36:16
 * @Description 力扣0054 跳跃游戏2
 **/
@Slf4j
public class jump0054 {
    @Test
    public void test01(){
    int[] nums ={2,3,1,1,4};
//    int[] nums ={2,3,0,1,4};
        System.out.println("jump(nums) = " + jump(nums));
    }


    /**
     *  解法一
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int curConver = 0;
        int nextConver=0;
        int jumpCount = 0;
        for (int i = 0; i < nums.length; i++) {
            //这里求得的时当前位置可以跳跃到的最大的下标
            nextConver = Math.max(i + nums[i], nextConver);
            if (i == curConver) {
                if (curConver < nums.length - 1) {
                    //更新最少步数
                    jumpCount++;
                    //更新覆盖距离
                    curConver = nextConver;
                    if (nextConver >= nums.length-1) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return jumpCount;
    }
}
