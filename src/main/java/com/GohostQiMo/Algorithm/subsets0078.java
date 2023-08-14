package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Black_ghost
 * @title: subsets0078
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-14 16:31:25
 * @Description 力扣  78. 子集
 **/
@Slf4j
public class subsets0078 {
    /**
     * 题目：给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * @param nums
     * @return
     */
    //结果集
    List<List<Integer>> result=new ArrayList<>();
    //路径
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        recursion(nums,0);
        return result;
    }

    //递归函数
    public void recursion(int[] nums,int startIndex){
        //收集结果
        result.add(new ArrayList<>(path));
        //回溯三部曲中的第二步：确定回调函数的终止条件 （这个题比较特殊，不需要终止条件也可以，因为反正要遍历整棵树）
        if(startIndex==nums.length){
            return;
        }
        //遍历
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            recursion(nums,i+1);
            path.remove(path.size()-1);
        }
    }

    @Test
    public void test01(){
        int[] nums={1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        //遍历结果集
        for (List<Integer> subset : subsets) {
            log.info("{}",subset);
        }
    }
}
