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

    /**
     * 全排列2 有重复元素   题目：给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * @param nums
     * @return
     */
    //结果集
    List<List<Integer>> result=new ArrayList<>();
    //路径
    List<Integer> path=new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used=new boolean[nums.length];
        //给定数组有重复的元素，需要排序方便去重
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
        //回溯三部曲：确定单层遍历逻辑  注意：排列问题，没有startindex了
        for (int i = 0; i < nums.length; i++) {
            // used[i - 1] == true，说明同一树枝nums[i - 1]使用过
            // used[i - 1] == false，说明同一树层nums[i - 1]使用过
            // 如果同一树层nums[i - 1]使用过则直接跳过

            //去重逻辑，使用used数组（剪枝）  树同层去重
            //这里需要注意的是：1. 因为这里排列问题，每次i多是从0开始，所以这里需要判断used[i]当前元素是否被使用过
            //               2. i >0 && nums[i]==nums[i-1] && !used[i-1])  这里树的同层去重逻辑
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
    // 时间复杂度: 最差情况所有元素都是唯一的。复杂度和全排列1都是 O(n! * n) 对于 n 个元素一共有 n! 中排列方案。而对于每一个答案，我们需要 O(n) 去复制最终放到 result 数组
    // 空间复杂度: O(n) 回溯树的深度取决于我们有多少个元素
}
