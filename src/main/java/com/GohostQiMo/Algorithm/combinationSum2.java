package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Black_ghost
 * @title: combinationSum2
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-28 18:10:10
 * @Description 力扣0040组合2  如何优雅的去重？
 **/
@Slf4j
public class combinationSum2 {
    public List<List<Integer>> result=new ArrayList<>();
    public List<Integer> path=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates,0,0,target,new boolean[candidates.length]);
        return  result;
    }

    /**
     * 递归函数
     * @param candidates
     * @param sum
     * @param startIndex
     * @param used
     */
    public void backtracking(int[] candidates,int sum,int startIndex,int target,boolean[] used){
        //回溯三部曲中的第二步：确定回调函数的终止条件
        if (sum ==target){
            result.add(new ArrayList<>(path));
            return;
        }
        //回溯三部曲中的第三步：确定单层搜索的逻辑
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum+candidates[i]>target) {
                break;
            }
            if (i> 0 && candidates[i]==candidates[i-1] && !used[i-1]){
                continue;
            }
            path.add(candidates[i]);
            used[i]=true;
            backtracking(candidates,sum+candidates[i],i+1,target,used);
            used[i]=false;
            path.remove(path.size()-1);
        }
    }



}
