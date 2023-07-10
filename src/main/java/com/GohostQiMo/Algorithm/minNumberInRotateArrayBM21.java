package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: minNumberInRotateArrayBM21
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-10 20:02:50
 * @Description 牛客101 BM21旋转数组的最小数字
 **/
@Slf4j
public class minNumberInRotateArrayBM21 {
    @Test
    public void test(){
//        int[] nums={3,4,5,1,2};
        int[] nums={1,1,1,0,1};  //如果不懂等于时要右移，dbug这个案例
        final int i = minNumberInRotateArray(nums);
        System.out.println("i = " + i);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    //还是二分法，因为给的还是一个类有序数组
    public int minNumberInRotateArray(int[] nums) {
        //这里先不考虑要不要考虑nums.length==1的情况，如果等于1,left==right，返回结果也正确
        //全部使用索引
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid =left + (right-left)/2;
            //如果中间值大于右边值，移动左边
            if (nums[mid]>nums[right]){
                left=mid+1;
                //如果中间值小于右边值，移动右边
            }else if (nums[mid]<nums[right]){
                right=mid;
            }else {
                //如果中间值等于右边值
                right--;
            }
        }
        return nums[left];
    }
}
