package com.GohostQiMo.Algorithm.南京端点科技补的笔试;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Black_ghost
 * @title: Solution0088
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-09-11 21:43:09
 * @Description
 **/
public class Solution0088 {
    /**
     * 笔试时写的，没有改了，看了题解好像都差不多
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count1 = m + n;
        int temp = m;
        int temp1 = n;
        while (temp > 0 && temp1 > 0) {
            if (nums1[temp - 1] > nums2[temp1 - 1]) {
                nums1[count1 - 1] = nums1[temp - 1];
                temp--;
            } else {
                nums1[count1 - 1] = nums2[temp1 - 1];
                temp1--;
            }
            count1--;
        }
        if (temp1 != 0) {
            while (temp1 > 0) {
                nums1[count1 - 1] = nums2[temp1 - 1];
                count1--;
                temp1--;
            }
        }
    }

    @Test
    public void test3() {
        int[] nums1 = {1};
        int[] nums2 = {10};
        merge(nums1, 1, nums2, 0);
        System.out.println(Arrays.toString(nums1));
    }
}
