package com.GohostQiMo.Algorithm;

/**
 * @author Black_ghost
 * @title: FibonacciBM62
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-16 07:31:20
 * @Description 牛客101  BM62 斐波那契数列
 **/
public class FibonacciBM62 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型
     * @return int整型
     */
    public int Fibonacci (int n) {
        if(n==1 || n==2){
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
}
