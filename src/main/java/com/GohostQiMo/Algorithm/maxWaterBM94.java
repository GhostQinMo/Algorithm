package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Black_ghost
 * @title: maxWaterBM94
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-19 21:45:06
 * @Description 牛客101  BM94 接雨水问题
 **/
@Slf4j
public class maxWaterBM94 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * max water
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    //单调栈写法（使用行计算雨水）
    public long maxWater (int[] arr) {
        long result=0;
        //先排除边界
        if(arr==null || arr.length<3){
            return result;
        }
        //使用双端队列作为栈 (明确队列中的元素是索引)  这里找是一个元素的右边第一个大的元素，使用递增栈
        Deque<Integer> container=new ArrayDeque<>();
        //初始化
        container.push(0);
        for(int i=1;i<arr.length;i++){
            while(!container.isEmpty() && arr[i]>arr[container.peekFirst()]){
                //查看是否出现凹槽
                int mid=arr[container.pop()];
                //当前队列不空，出现凹槽 计算
                if(!container.isEmpty()){
                    int l=i-container.peek()-1;
                    int d=Math.min(arr[container.peek()],arr[i])-mid;
                    result+=l*d;
                }
            }
            //入栈当前元素（大于弹出在入栈，小于直接入栈维持了递增栈）
            container.push(i);
        }
        return result;
    }


    //上面处理等于的状态是在while中去除的，即当栈中的为7 5 5时，来了一个6 先去除第一个5，再while去除第二5
    @Test
    public void test01(){

    }
}
