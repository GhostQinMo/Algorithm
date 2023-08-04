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
 * @Description 力扣0045 跳跃游戏2
 **/
@Slf4j
public class jump0045 {
    @Test
    public void test01(){
    int[] nums ={2,3,1,1,4};
//    int[] nums ={2,3,0,1,4};
        System.out.println("jump(nums) = " + jump(nums));
    }


    /**
     *  解法一:关于题解：去看代码随想录的贪心篇，这里我写到注释不是很明白
     * @param nums
     * @return
     */
    //这里不需要考虑不能跳到的情况。题目给出：生成的测试用例可以到达 nums[n - 1]。
    public int jump_old(int[] nums) {
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
                //复习：会过来看，这个的if可以不需要，见下面优化的
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


    /**
     * 题目给出：返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]，也就是一定可以跳到末尾
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int len=nums.length;
        if(len==1){
            return 0;
        }
        //当前覆盖的最远距离（索引）
        int curconver=0;
        //下一次覆盖的最远距离
        int nextconver=0;
        //返回结果
        int result=0;
        for(int i=0;i<len;i++){
            nextconver=Math.max(i+nums[i],nextconver);
            if(i==curconver){
                //更新跳数
                ++result;
                //更新当前最远距离
                curconver=nextconver;
                if(curconver>=len-1){
                    break;
                }
            }
        }
        return result;
    }
}
