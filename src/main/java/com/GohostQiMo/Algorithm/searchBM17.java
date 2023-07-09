package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: searchBM17
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-09 19:27:04
 * @Description BM17 二分查找-I
 **/
@Slf4j
public class searchBM17 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     */
    //思路：坚持循环不变量就行（左闭右开）
    public int search (int[] nums, int target) {
        //统一使用索引
        int left=0;
        int right=nums.length-1;
        //这即使是nums没有一个值也不用担心，因为当nums是null是left=0,right=-1
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]<target){
                left=mid+1;
            }else if (nums[mid] > target){
                right=mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
