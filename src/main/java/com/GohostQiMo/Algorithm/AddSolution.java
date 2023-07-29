package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: AddSolution
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-29 19:19:32
 * @Description 不使用+号实现加法
 **/
@Slf4j
public class AddSolution {
    /**
     * 写法一：递归写法
     * @param a
     * @param b
     * @return
     */
    public int  add(int a ,int b){
        //a&b得到进位，a^b得到不进位的值，如果没有进位了，a^b就是a+b的值
        return (a&b)!=0 ? add((a&b)<<1,a^b) : a^b;
    }

    /**
     * 非递归写法
     * @param a
     * @param b
     * @return
     */
    public int add_prefer(int a,int b){
        int temp=0;
        while ((a&b)!=0){
            temp=a;
            a=(a&b)<<1;
            b^=temp;
        }
        return a^b;
    }


    @Test
    public void test01(){
//        final int result = add(5 , 6);
        final int result = add_prefer(5 , 6);
        System.out.println("result = " + result);
    }
}
