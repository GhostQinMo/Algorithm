package com.GohostQiMo.Algorithm;

/**
 * @author Black_ghost
 * @title: searchInsert
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-25 22:28:46
 * @Description  力扣0035搜索掺入位置
 **/
public class searchInsert {
    /*给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    你可以假设数组中无重复元素*/

    /**
     * 方法一：暴力，直接遍历
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert1(int[] nums, int target) {
        if (nums.length == 0) {
            throw new NullPointerException(nums + " length is zero ");
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 方法二：二分法
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            throw new NullPointerException("nums length is 0");
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return right + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        final searchInsert searchInsert = new searchInsert();
        final int index = searchInsert.searchInsert(nums, 0);
        System.out.println(index);

    }

}
