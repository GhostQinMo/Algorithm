package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: mergeBM87
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-19 11:27:41
 * @Description 牛客101  BM87 合并两个有序的数组
 **/
@Slf4j
public class mergeBM87 {

    //看题解之前的（可以通过测试）
    public void merge_old(int A[], int m, int B[], int n) {
        int len=m+n;
        //从后往前遍历
        while(m>0 &&  n>0){
            if(A[m-1]>B[n-1]){
                A[len-1]=A[m-1];
                m--;
            }else{
                A[len-1]=B[n-1];
                n--;
            }
            //结果数组一起向左移动
            len--;
        }
        //A还有剩余
        if(m!=0){
            while(m>0){
                A[len-1]=A[m-1];
                m--;
                len--;
            }
        }else{
            //B还有剩余
            while(n>0){
                A[len-1]=B[n-1];
                n--;
                len--;
            }
        }
    }

    //看题解之后的
    public void merge(int A[], int m, int B[], int n) {
        int len = m + n;
        //从后往前遍历
        while (m > 0 &&  n > 0) {
            if (A[m - 1] > B[n - 1]) {
                A[len - 1] = A[m - 1];
                m--;
            } else {
                A[len - 1] = B[n - 1];
                n--;
            }
            //结果数组一起向左移动
            len--;
        }
        //A还有剩余 （这里A有剩余不需要考虑，A数组本来就是有序的，原本就在前面）

        //B还有剩余
        if (n!=0) {
            while (n > 0) {
                A[len - 1] = B[n - 1];
                n--;
                len--;
            }
        }
    }
}
