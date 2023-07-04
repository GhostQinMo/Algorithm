package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Black_ghost
 * @title: totalNQueens0052
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-04 13:17:22
 * @Description 力扣0052 N皇后2
 **/
@Slf4j
public class totalNQueens0052 {

    @Test
    public void test04(){
        final int total = totalNQueens(4);
        System.out.println("total = " + total);
    }

    int count=0;
    public int totalNQueens(int n) {
        char[][] chessboard = new char[n][n];
        //棋盘初始化操作
        for (char[] cchar : chessboard) {
            Arrays.fill(cchar, '.');
        }
        backtracking(0,  chessboard, n);
        return count;
    }

    /**
     * 回溯函数
     *
     * @param curn
     * @param chessboard
     * @param n
     */
    public void backtracking(int curn,  char[][] chessboard, int n) {
        //回溯三部曲：终止条件
        if (curn == n) {
           count++;
            //找到一个返回，接着寻找下一个
            return;
        }
        //回溯三部曲：确定单层遍历逻辑
        for (int j = 0; j < n; j++) {
            chessboard[curn][j] = 'Q';
            if (isvalid(curn, j, chessboard, n)) {
                backtracking(curn + 1,  chessboard, n);
            }
            chessboard[curn][j] = '.';
        }
    }


    /**
     * 判单是否符合当前的N皇后的规则
     * @param curn  当前行
     * @param curl  当前列
     * @param chessboard
     * @param n
     * @return
     */
    public boolean isvalid(int curn, int curl, char[][] chessboard, int n) {
        //检测列
        for (int i = 0; i < curn; i++) {
            if (chessboard[i][curl]=='Q'){
                return false;
            }
        }
        //检测45度
        for (int i =curn-1, j = curl+1 ; i >=0 && j < n; i--,j++){
            if (chessboard[i][j]=='Q'){
                return false;
            }
        }
        //检测135度
        for (int i= curn-1,j=curl-1; i>=0 && j>=0; i--,j-- ) {
            if (chessboard[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

}
