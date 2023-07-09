package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: findPeakElementBM19
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-09 20:13:35
 * @Description 牛客101 BM19 寻找峰值
 **/
@Slf4j
public class findPeakElementBM19 {
    @Test
    public void test01(){
        int[] nums={2,4,1,2,7,8,4};
//        int[] nums={1};
//        int[] nums={1,1}; // 这种值怎么办，题目给出了要求 对于所有有效的 i 都有 nums[i] != nums[i + 1]
        final int peakElement = findPeakElement(nums);
        System.out.println("peakElement = " + peakElement);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * @param nums int整型一维数组
     * @return int整型
     */
    //个人思路：我前面做个单调栈，单调栈用于寻找比当前元素大的第一个值或者比自己小的第一个值
    //题目进阶：你可以使用O(logN)的时间复杂度实现此问题吗？  但是使用单调栈无法完成这个要求
    //看题解：二分法解题（分而治之）
    public int findPeakElement (int[] nums) {
        //全部使用索引
        int left=0;
        int right=nums.length-1;
        //这里到底是小于还是小于等于需要根据场景来定，二分查找一定是的是小于等于，这里一定是小于
        while (left<right){
            int mid=left+(right-left)/2;
            if (nums[mid] > nums[mid+1]){
                //当前位置的柱子高于它左边 ，目标是往上走
                right=mid;
            }else {
                //当前位置的柱子小于等于它左边的
                left=mid+1;
            }
        }
        //右边是一直往上走的
        return right;
    }
}
