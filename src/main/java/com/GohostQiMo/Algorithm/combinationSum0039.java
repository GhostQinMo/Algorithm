package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

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
    public List<List<Integer>> combinationSum(int[] candidates,int target){
        final List<List<Integer>> result  = new ArrayList<>();
        final ArrayList path = new ArrayList();
        Arrays.sort(candidates);
        backtracking(result,path,candidates,0,target,0);
        return result;
    }

    /**
     *
     * @param result
     * @param path
     * @param candidates
     * @param sum
     * @param target
     * @param startIndex
     */
    //关于什么时候需要startIndex呢？ 一个集合中求组合的情况
    public void backtracking(List<List<Integer>> result,List<Integer> path,int[] candidates,int sum,int target, int startIndex){
        if(sum==target){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum+candidates[i]>target) break;
            path.add(candidates[i]);
            backtracking(result,path,candidates,sum+ candidates[i],target,i);
            path.remove(path.size() - 1);
        }
    }
}
