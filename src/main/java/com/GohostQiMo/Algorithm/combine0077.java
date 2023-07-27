package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Black_ghost
 * @title: combine0077
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-27 10:24:08
 * @Description 力扣  0077 组合
 **/
@Slf4j
public class combine0077 {

    public List<List<Integer>> combine(int n, int k) {
        //数组无重复元素，已经排好顺序了
        recursion(n,k,1); //为什么从1开始，因为题目是一个从1开始的数组
        return result;

    }
    public List<List<Integer>> result=new ArrayList<>();

    //递归方法
    public List<Integer> path=new ArrayList<>();
    //关于什么时候需要startindex，在一个集合中求组合问题的时候
    public void recursion(int n,int k,int startindex){
        //终止条件
        if(path.size()==k){
            result.add(new ArrayList(path));
            return;
        }
        //这里做了剪枝操作，如果没做，直接小于等于n也可以通过测试  ,因为数组是从1开始的，所以经过带入测试需要+1
        for(int i=startindex;i<=n-(k-path.size())+1;i++){
            path.add(i);
            //递归
            recursion(n,k,i+1);  //注意startindex表示下一次开始的地方，不要写成第一次开始的数值
            //回溯
           path.remove(path.size()-1);
        }
    }

    @Test
    public void test01(){
        final List<List<Integer>> result = combine(4, 2);
        result.forEach((item)->{
            System.out.println(Arrays.toString(item.toArray()));
        });
    }
}
