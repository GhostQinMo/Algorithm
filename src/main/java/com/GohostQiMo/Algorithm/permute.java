package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Black_ghost
 * @title: permute
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-03 17:21:11
 * @Description 力扣0046 全排列
 **/
@Slf4j
public class permute {
    @Test
    public void test01() {
        int[] nums = {1, 2, 3};
        final List<List<Integer>> permute = permute(nums);
        permute.forEach(System.out::print);
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums, new boolean[nums.length]);
        return result;
    }

    /**
     * 回溯函数
     *
     * @param nums
     * @param used
     */
    public void backtracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
