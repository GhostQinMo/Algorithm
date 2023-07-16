package com.GohostQiMo.Algorithm;

/**
 * @author Black_ghost
 * @title: minPathSum
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-16 11:46:33
 * @Description 牛客101 BM68 矩阵的最小路径和
 **/
public class minPathSum {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum (int[][] matrix) {
        int x=matrix.length;
        int y=matrix[0].length;
        int[][] dp=new int[x][y];
        dp[0][0]=matrix[0][0];
        //初始化操作
        for(int i=1;i<x;i++){
            dp[i][0]=matrix[i][0]+dp[i-1][0];
        }
        for(int i=1;i<y;i++){
            dp[0][i]=matrix[0][i]+dp[0][i-1];
        }
        for(int i=1;i<x;i++){
            for(int j=1;j<y;j++){
                dp[i][j]=matrix[i][j]+(dp[i-1][j]>dp[i][j-1] ? dp[i][j-1] : dp[i-1][j]);
            }
        }
        return dp[x-1][y-1];
    }
}
