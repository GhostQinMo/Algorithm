package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Black_ghost
 * @title: combinationSum20040
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-28 18:10:10
 * @Description 力扣0040组合2  如何优雅的去重？
 **/
@Slf4j
public class combinationSum20040 {
    public List<List<Integer>> result=new ArrayList<>();
    public List<Integer> path=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //一定要明确什么时候需要排序
        Arrays.sort(candidates);
        //review：什么时候需要startIndex呢？ 一个集合中求组合的情况
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
            //剪枝操作，条件是数组必须排序，从小到大
            if (sum+candidates[i]>target) {
                break;
            }
            //去重逻辑
            // used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            // 要对同一树层使用过的元素进行跳过
            if (i> 0 && candidates[i]==candidates[i-1] && !used[i-1]){
                //这里是continue，不是break
                continue;
            }
            path.add(candidates[i]);
            used[i]=true;
            //把sum+candidates[i]放到函数调用中比较好，可以避免在回溯的时候多做一次减法
            backtracking(candidates,sum+candidates[i],i+1,target,used);
            used[i]=false;
            path.remove(path.size()-1);
        }
    }


    /**
     * 测试方法
     */
    @Test
    public void test01(){
        int[] candidates={10,1,2,7,6,1,5};
        int target=8;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        log.info("lists:{}",lists);
    }
}
