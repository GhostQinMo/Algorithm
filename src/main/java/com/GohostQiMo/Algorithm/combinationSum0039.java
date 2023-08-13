package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Black_ghost
 * @title: combinationSum
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-26 09:29:05
 * @Description 力扣0039组合总和
 **/
@Slf4j
public class combinationSum0039 {
    public static void main(String[] args) {

    }

    /**
     * 组合总和（数组元素不重复，数组中的单个元素可以使用多次）
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        final List<List<Integer>> result = new ArrayList<>();
        final ArrayList path = new ArrayList();
        //如果添加了剪枝操作的话，数组必须排序，从小到大。（如果不添加剪枝操作的话，可以不需要排序 (见57行的剪枝操作)），如果看不懂，自己debug一下就知道了
        Arrays.sort(candidates);
        backtracking(result, path, candidates, 0, target, 0);
        return result;
    }

    /**
     * @param result     结果集
     * @param path       路径
     * @param candidates 候选集
     * @param sum        当前的和
     * @param target     目标和
     * @param startIndex 当前开始的位置
     */
    //关于什么时候需要startIndex呢？ 一个集合中求组合的情况
    public void backtracking(List<List<Integer>> result, List<Integer> path, int[] candidates, int sum, int target, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            //如果添加了剪枝操作的话，数组必须排序，从小到大
            if (sum + candidates[i] > target) break; //因为是有序数组，如果当前和加上当前元素大于目标值的话，后面的元素肯定也会大于目标值，所以直接break
            path.add(candidates[i]);
            backtracking(result, path, candidates, sum + candidates[i], target, i);
            path.remove(path.size() - 1);
        }
    }


    @Test
    public void test01(){
        //测试案例：测试为什么需要排序
        int target=11;
        int[] nums={8,7,4,3};
        List<List<Integer>> lists = combinationSum(nums, target);
    }
}
