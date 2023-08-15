package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Black_ghost
 * @title: permute0046
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-03 17:21:11
 * @Description 力扣0046 全排列
 **/
@Slf4j
public class permute0046 {
    @Test
    public void test01() {
        int[] nums = {1, 2, 3};
        final List<List<Integer>> permute = permute(nums);
        permute.forEach(System.out::print);
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    /**
     * 题目：给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        //需要使用一个数组来标记元素是否被使用过
        //这里题目给定的元素就是不重复的，所以不需要排序也可以
        backtracking(nums, new boolean[nums.length]);
        return result;
    }

    /**
     * 回溯函数
     *
     * @param nums 题目给定的数组
     * @param used 用来标记元素是否被使用过
     */
//    时间复杂度: O(n!)  我理解中学中的插入法，第一个元素可以有n种选择，第二个元素可以有n-1种选择，第三个元素可以有n-2种选择，以此类推，所以时间复杂度为O(n!)
//      空间复杂度: O(n)
    public void backtracking(int[] nums, boolean[] used) {
        //回溯三部曲中的第二步：确定回调函数的终止条件
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return; //因为收集的是到叶子节点的路径，所有这里可以返回
        }
        //这里的i不是重startIndex开始了，因为这里是排列问题，所以每次都是从0开始
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
