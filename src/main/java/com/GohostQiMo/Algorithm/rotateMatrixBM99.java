package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Black_ghost
 * @title: rotateMatrixBM99
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-20 21:03:47
 * @Description 牛客101  BM99 顺时针旋转矩阵
 **/
@Slf4j
public class rotateMatrixBM99 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param mat int整型二维数组
     * @param n int整型
     * @return int整型二维数组
     */
    public int[][] rotateMatrix_old (int[][] mat, int n) {
        int[][] result=new int[n][n];
        //从下往上读，从左往右读
        //列遍历
        int i=0,j=0;
        for(int col=0;col<n;col++){
            //行遍历
            for(int row=n-1;row>=0;row--){
                result[i][j]=mat[row][col];
                j++;
            }
            i++;
            //注意了这里需要重置j
            j=0;
        }
        return result;
    }


    //最简写法  但是需要N平方的空间  需要算出来一个表达式
    public int[][] rotateMatrix (int[][] mat, int n) {
        int[][] result=new  int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result[j][n-i-1]=mat[i][j];
            }
        }
        return result;
    }
}
