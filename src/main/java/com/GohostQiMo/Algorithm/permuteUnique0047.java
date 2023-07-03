package com.GohostQiMo.Algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Black_ghost
 * @title: permuteUnique0047
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-03 19:57:42
 * @Description 力扣0047 全排列2
 **/
public class permuteUnique0047 {
    @Test
    public void test01(){
       int[]  nums = {1,1,2};
        final List<List<Integer>> lists = permuteUnique(nums);
        lists.forEach(System.out::print);
    }
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    /**
     * 全排列2
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used=new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums,used);
        return result;
    }

    //回溯三部曲：确定递归函数的参数
    public void backtracking(int[] nums,boolean[] used){
        //回溯三部曲：确定终止条件
        if (path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //回溯三部曲：确定单层遍历逻辑
        for (int i = 0; i < nums.length; i++) {
            //去重逻辑，使用used数组（剪枝）
            if (used[i] || (i >0 && nums[i]==nums[i-1] && !used[i-1])){
                continue;
            }
            used[i]=true;
            path.add(nums[i]);
            backtracking(nums,used);
            path.remove(path.size()-1);
            used[i]=false;
        }
    }


}
