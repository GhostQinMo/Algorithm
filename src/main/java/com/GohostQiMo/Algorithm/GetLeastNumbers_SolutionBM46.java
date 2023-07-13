package com.GohostQiMo.Algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Black_ghost
 * @title: GetLeastNumbers_SolutionBM46
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-13 09:17:56
 * @Description 牛客101 BM46最小的K个数
 **/
public class GetLeastNumbers_SolutionBM46 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param input int整型一维数组
     * @param k int整型
     * @return int整型ArrayList
     */
    //做这个题首先要知道优先队列，什么是大顶堆什么是小顶堆，最初我以为要自己堆化呢
    public ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {
        ArrayList<Integer> result=new ArrayList<>();
        if (k==0 || input.length==0){
            return result;
        }
        //使用大顶堆优先队列（注意优先队列中不能有null）
        PriorityQueue<Integer> container=new PriorityQueue<>(Comparator.reverseOrder());
        //初始化操作
        for (int i = 0; i < k; i++) {
            container.add(input[i]);
        }
        //找出最小k个数
        for (int i = k; i <input.length ; i++) {
            if (container.peek()>input[i]){
                container.poll();
                container.add(input[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(container.poll());
        }
        return result;
    }
}
