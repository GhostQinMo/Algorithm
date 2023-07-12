package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author Black_ghost
 * @title: maxSlidingWindow0239
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-02 09:25:01
 * @Description 力扣 0239 滑动窗口的大小
 **/

@Slf4j
public class maxSlidingWindow0239 {
    @Test
    public void  maxSlidingWindow0239Test(){
//        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        final int[] ints = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }
    /**
     * 暴力求解  超时
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow_old(int[] nums, int k) {
        int[] result=new int[nums.length-k+1];
        for (int i = 0; i < result.length; i++) {
            result[i]=getMaxOfK(Arrays.copyOfRange(nums,i,i+k));
        }
        return result;
    }
    public int getMaxOfK(int[] knum){
        int max =knum[0];
        for (int i = 1; i < knum.length; i++) {
            if (knum[i]>max){
                max=knum[i];
            }
        }
        return  max;
    }



    //------------------------------------------------

    /**
     * 使用deque来实现单调队列
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums,int k){
        //在牛客网上的这个题有个条件： 窗口大于数组长度或窗口长度为0的时候，返回空。
        int[] result=new int[nums.length-k+1];
        int idx=0;
        //单调递增队列中的存储的是元素的索引
        Deque<Integer> temp_que=new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //如果队列不为空，且单调队列的头中的元素不在当前滑动窗口中，则弹出
            //这里必须从右边开始弹出
            while (!temp_que.isEmpty() && temp_que.peek()<=i-k ){
               temp_que.poll();
            }
            //这里从左边开始弹出，开始我把这两个while合并了，出现了隐藏的错误
            while (!temp_que.isEmpty() && nums[temp_que.peekLast()] < nums[i]){
                temp_que.pollLast();
            }
            temp_que.offer(i);

            if (i>=k-1){
                result[idx++]=nums[temp_que.peek()];
            }
        }
        return  result;
    }
    


    @Test
    public void testDeque(){
        Deque<Integer> temp_que=new LinkedList<>();
        int[] ints=new int[]{1,2,3,4,5,6};
        final IntStream stream = Arrays.stream(ints);
        stream.forEach(temp_que::push);
        System.out.println(temp_que.pop());
        System.out.println(temp_que.poll());
        System.out.println("temp_que.peek() = " + temp_que.peek());
        System.out.println("temp_que.peekLast() = " + temp_que.peekLast());
        System.out.println("temp_que.pollLast() = " + temp_que.pollLast());
        temp_que.push(7);
        temp_que.offer(9);
        temp_que.stream().forEach(System.out::print);
    }
}
