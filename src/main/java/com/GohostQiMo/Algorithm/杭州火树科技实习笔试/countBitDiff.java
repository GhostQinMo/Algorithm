package com.GohostQiMo.Algorithm.杭州火树科技实习笔试;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: countBitDiff
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-09-03 15:05:25
 * @Description
 **/
@Slf4j
public class countBitDiff {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param m int整型
     * @param n int整型
     * @return int整型
     */
    public int countBitDiff (int m, int n) {
        int result=0;
        int temp=m^n;
        int i=0;
        while (i<=Integer.toBinaryString(temp).length()){
            if (((1<<i)&temp)>0){
                ++result;
            }
            i++;
        }
        return result;
    }

    @Test
    public void test(){
        countBitDiff(3,5);
    }
}
