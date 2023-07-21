package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Black_ghost
 * @title: solveBM97
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-20 18:01:13
 * @Description 牛客101   BM97 旋转数组
 **/
@Slf4j
public class solveBM97 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 旋转数组
     * @param n int整型 数组长度
     * @param m int整型 右移距离
     * @param a int整型一维数组 给定数组
     * @return int整型一维数组
     */
    public int[] solve (int n, int m, int[] a) {
        //这里需要注意如果m大于整个数组的长度，需要取模
        m=m%n;
        //翻转全部
        reverse(a,0,n-1);
        //翻转前m个
        reverse(a,0,m-1);
        //翻转剩余的
        reverse(a,m,n-1);
        return a;
    }

    //start end 全部是索引
    public void reverse(int[] a,int start,int end){
        while(start<end){
            a[start]=a[end]+a[start];
            a[end]=a[start]-a[end];
            a[start]=a[start]-a[end];
            start++;
            end--;
        }
    }

    //优雅的测试
    @Test
    public void test(){
        int[] nums=new int[]{5,2,0,0,2,5};
        final int[] solve = solve( 6, 3,nums);
        System.out.println("Arrays.toString(solve) = " + Arrays.toString(solve));
    }
}
