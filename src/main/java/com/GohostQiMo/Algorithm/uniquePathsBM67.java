package com.GohostQiMo.Algorithm;

/**
 * @author Black_ghost
 * @title: uniquePathsBM67
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-16 10:36:09
 * @Description 牛客101  BM67 不同路径的数目(一)
 **/
public class uniquePathsBM67 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param m int整型
     * @param n int整型
     * @return int整型
     */
    public int uniquePaths (int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=n;i++){
            dp[1][i]=1;
        }
        for(int i=1;i<=m;i++){
            dp[i][1]=1;
        }
        //确定遍历顺序
        for(int i=2;i<=m;i++){
            for(int j=2;j<=n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}
