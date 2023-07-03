package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Black_ghost
 * @title: dailyTemperatures0739
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-02 08:25:40
 * @Description 力扣0739每日温度    熟悉数据结构单调栈的使用和使用环境
 **/
@Slf4j
public class dailyTemperatures0739 {
    public static void main(String[] args) {
        final dailyTemperatures0739 dailyTemperatures0739 = new dailyTemperatures0739();
       int[] temperatures = {73,74,75,71,69,72,76,73};
        final int[] ints = dailyTemperatures0739.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 暴力解法 O(n2)  这种方法会超时
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures_old(int[] temperatures){
        int[] result=new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i+1; j <temperatures.length; j++) {
                if (temperatures[j]>temperatures[i]){
                    result[i]=j-i;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 单调栈的典型代表
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures){
        int[] result=new int[temperatures.length];
        Deque<Integer> temp_que=new LinkedList<>();
        temp_que.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[temp_que.peek()]>=temperatures[i]){
                temp_que.push(i);
                continue;
            }
            while (!temp_que.isEmpty() && temperatures[temp_que.peek()] <temperatures[i]){
                result[temp_que.peek()]=i-temp_que.peek();
                temp_que.pop();
            }
            temp_que.push(i);
        }
        return result;
    }

}
