package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Black_ghost
 * @title: permuteUniqueBM56
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-14 21:34:19
 * @Description 牛客101  BM56 有重复项数字的全排列
 **/
@Slf4j
public class permuteUniqueBM56 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param num int整型一维数组
     * @return int整型ArrayList<ArrayList<>>
     */
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permuteUnique (int[] num) {
        // write code here
        Arrays.sort(num);
        permuteUniqueHelper(num, new boolean[num.length]);
        return result;
    }
    private ArrayList<Integer> path = new ArrayList<>();
    public void permuteUniqueHelper(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                permuteUniqueHelper(nums, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
