package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author Black_ghost
 * @title: NqueenBM59
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-15 17:28:10
 * @Description 牛客101  N皇后问题  (这个与力扣上的题就是返回值不同)
 **/
@Slf4j
public class NqueenBM59 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型 the n
     * @return int整型
     */
    int result=0;
    //题目要求：1<=n<=9;
    public int Nqueen (int n) {
        //初始化棋盘
        char[][] boradchess=new char[n][n];
        for(char[] curn : boradchess){
            Arrays.fill(curn,'.');
        }
        recursion(0,boradchess,n);
        return result;
    }

    /**
     */           //当前行       当前棋盘    N皇后
    public void recursion(int curn, char[][] boardchess,int n){
        //终止条件
        if(curn==n){
            result++;
            return;  //如果没有这个返回终止条件就需要用if else
        }
        //遍历当前层当前位置放入Q是否合理
        for(int i=0;i<n;i++){
            boardchess[curn][i]='Q';
            if(isValid(curn,i,boardchess,n)){
                recursion(curn+1,boardchess,n);
            }
            //回溯
            boardchess[curn][i]='.';
        }
    }

    //判断当前皇后位置是否合理
    public boolean isValid(int curn,int curl, char[][] boardchess,int n){
        //当前列
        for(int i=0;i<curn;i++){
            if(boardchess[i][curl]=='Q'){
                return false;
            }
        }
        //判断45度角
        for(int i=curn-1,j=curl+1;i>=0 && j<n; i--,j++){
            if(boardchess[i][j]=='Q'){
                return false;
            }
        }
        //判断135度角
        for(int i=curn-1,j=curl-1;i>=0 && j>=0;i--,j--){
            if(boardchess[i][j]=='Q')
                return false;
        }

        return true;
    }
}
