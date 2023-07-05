package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: uniquePaths0062
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-04 17:07:34
 * @Description 力扣0062  不同路径（问题转换为组合问题）
 **/
@Slf4j
public class uniquePaths0062 {
    @Test
    public void test01(){
        final int i = uniquePaths(3, 2);
        System.out.println("i = " + i);
    }
    /**
     * 组合问题需要注意的是溢出问题，稍不注意就会纯在溢出
     * @param m
     * @param n
     * @return
     */
    //使用的数论的方法
    public int uniquePaths(int m, int n) {
        //注意这里传入的m和n多需要减一的
        //循环的次数
        int count=m-1;
        //分子
        long numerator=1;
        int temp=m+n-2;
        //分母
        int denominator=m-1;
        while (count>0){
            numerator*=(temp--);
            while (denominator!=0 && numerator%denominator==0){
                numerator/=denominator;
                denominator--;
            }
            count--;
        }
        return (int) numerator;
    }


}
