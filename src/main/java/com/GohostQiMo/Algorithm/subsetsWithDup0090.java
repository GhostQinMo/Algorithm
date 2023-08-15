package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Black_ghost
 * @title: subsetsWithDup0090
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-14 19:25:31
 * @Description 力扣  90. 子集 II
 **/
@Slf4j
public class subsetsWithDup0090 {
    /**
     * 题目：给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
     *
     * @param nums
     * @return
     */
    //结果集
    List<List<Integer>> result = new ArrayList<>();
    //路径
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //先排序
        Arrays.sort(nums);
        recursion(nums, 0);
        return result;
    }
    //递归函数

    /**
     * @param num        给定数组
     * @param startIndex 当前遍历的起始位置
     */
    public void recursion(int[] num, int startIndex) {
        //这里也不需要终止条件，和求子集I是一样的，剪枝在for循环中处理
        result.add(new ArrayList<>(path));
        //遍历
        for (int i = startIndex; i < num.length; i++) {
            //去重剪枝，因为这里是组合不是排列，所以不需要used数组也可以去重，直接写成下面这样也可以了
           /* if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }*/
            //i>startIndex可以保证与nums[i]相同的元素在同层一定会出现一次，
            // num[i] == num[i - 1]可以保证与nums[i]相同的元素在同层只出现一次
            if (i > startIndex && num[i] == num[i - 1]) {
                continue;
            }
            //递归
            path.add(num[i]);
            recursion(num,i+1);
            path.remove(path.size()-1);
        }
    }


    @Test
    public void test01(){
        int[] nums={1,2,2};
        List<List<Integer>> subsets = subsetsWithDup(nums);
        //遍历结果集
        for (List<Integer> subset : subsets) {
            log.info("{}",subset);
        }
    }
}
