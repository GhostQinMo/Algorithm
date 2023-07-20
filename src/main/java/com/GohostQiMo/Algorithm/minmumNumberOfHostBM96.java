package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Black_ghost
 * @title: minmumNumberOfHostBM96
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-20 15:53:35
 * @Description 牛客101  BM96 主持人调度（二）
 **/
@Slf4j
public class minmumNumberOfHostBM96 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算成功举办活动需要多少名主持人
     * @param n int整型 有n个活动
     * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
     * @return int整型
     */
    //这个很难想到
    public int minmumNumberOfHost (int n, int[][] startEnd) {
        int[] start = new int[n];
        int[] end = new int[n];
        //分别得到活动起始时间
        for(int i = 0; i < n; i++){
            start[i] = startEnd[i][0];
            end[i] = startEnd[i][1];
        }
        //单独排序
        Arrays.sort(start, 0, start.length);
        Arrays.sort(end, 0, end.length);
        int res = 0;
        int j = 0;
        for(int i = 0; i < n; i++){
            //新开始的节目大于上一轮结束的时间，主持人不变
            if(start[i] >= end[j])
                j++;
            else
                //主持人增加
                res++;
        }
        return res;
    }

    @Test
    public void test01(){
        int[][] nums=new int[][]{
                {0,9},
                {2,4},
                {6,7},
//                {9,13},
//                {9,13}
        };
        final int i = minmumNumberOfHost(3, nums);
        log.info("i={}",i);
    }


    //在题解中看到的一种写法，这种写法更好理解  其实这种和上面的贪心是一样的过程，只不过这里用优先队列来排序，上面用的是Arrays.sort来排序
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算成功举办活动需要多少名主持人
     * @param n int整型 有n个活动
     * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
     * @return int整型
     */
    public int minmumNumberOfHost_understand(int n, int[][] startEnd) {
        //如果开始时间相同，按结束时间从小到大排序，否则按开始时间排序
        Arrays.sort(startEnd,(o1,o2)->o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);

        //初始化优先队列
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int[] activity:startEnd){
            //如果当前开始时间大于等于之前某个活动的结束时间，说明可以让之前那个主持人继续主持当前的活动
            if(!queue.isEmpty()&&queue.peek()<=activity[0]){
                queue.poll();
            }
            //如果不满足，需要新派一个主持人
            queue.offer(activity[1]);
        }

        return queue.size();
    }
}
