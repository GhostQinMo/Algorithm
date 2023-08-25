package com.GohostQiMo.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Black_ghost
 * @title: intersection0349
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-25 21:57:19
 * @Description 力扣 349. 两个数组的交集
 **/
public class intersection0349 {
    /**
     * 题目：见力扣 349
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> temp = new HashSet();
        for (int i = 0; i < nums1.length; i++) {
            if (!temp.contains(nums1[i])) {
                temp.add(nums1[i]);
            }
        }
        ArrayList<Integer> result = new ArrayList();
        for (int i = 0; i < nums2.length; i++) {
            if (temp.contains(nums2[i])&&!result.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
