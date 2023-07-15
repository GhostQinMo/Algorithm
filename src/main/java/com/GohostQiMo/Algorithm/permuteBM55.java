package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @author Black_ghost
 * @title: permuteBM55
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-14 11:40:28
 * @Description 牛客101  BM55 没有重复项数字的全排列
 **/
@Slf4j
public class permuteBM55 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param num int整型一维数组
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> result=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permute (int[] num) {
        // write code here
        permuteHelper(num,new boolean[num.length]);
        return result;
    }

    //回溯三部曲
    ArrayList<Integer> one=new ArrayList<>();
    public void permuteHelper(int[] nums,boolean[] used){
        if(one.size()==nums.length){
            result.add(new ArrayList(one));
            return ;
        }
        //回溯三部曲：3确定单层遍历逻辑
        for(int i=0;i<nums.length;i++){
            if(used[i]==true) continue;
            one.add(nums[i]);
            used[i]=true;
            permuteHelper(nums,used);
            used[i]=false;
            one.remove(one.size()-1);
        }

    }
}
