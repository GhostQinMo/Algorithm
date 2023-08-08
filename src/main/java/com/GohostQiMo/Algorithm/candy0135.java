package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Black_ghost
 * @title: candy0135
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-08 10:13:25
 * @Description 力扣 135. 分发糖果   多次使用贪心
 **/
@Slf4j
public class candy0135 {
    /**
     * 注意：这个题再牛客101 中我已经写过了，这里只是复习一下，具体的题解请看candyBM95，这里我直接写最简洁版本了
     * @param ratings
     * @return
     */
    //如果同时考虑两边兼顾，就会顾此失彼。（人生如此，满足即可）
    public int candy(int[] ratings) {
        //两次贪心，第一次找出右边评分比左边大的需要分配的糖果，第二次找出左边评分比右边大的需要分配的糖果，去两者最大值
        int len=ratings.length;
        if(len==0){
            return 0;
        }
        //记录返回结果的数组和完成数组的初始化（每个小朋友必须一个糖果）
        int[] result=new int[len];
        Arrays.fill(result,1);
        //右边比左边大的
        for (int i = 1; i <len ; i++) {
            if (ratings[i]> ratings[i-1]){
                result[i]= result[i-1]+1;
            }
        }
        //左边比右边大的
        for (int i =len-2; i >=0 ; i--) {
            if (ratings[i]>ratings[i+1]){
                result[i]=Math.max(result[i],result[i+1]+1);
            }
        }
        //计算最终结果
        int min=0;
        for (int i = 0; i < len; i++) {
            min+=result[i];
        }
        return min;
    }

    /**
     * 测试
     */
    @Test
    public void test01(){
//        int[] score={1,2,2};
        int[] score={1,0,2};
        final int candy = candy(score);
        System.out.println("candy = " + candy);
    }
}
