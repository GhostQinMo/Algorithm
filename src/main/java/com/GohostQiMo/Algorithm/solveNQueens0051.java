package com.GohostQiMo.Algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Black_ghost
 * @title: solveNQueens0051
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-03 21:29:44
 * @Description 力扣 0051 N皇后问题  回溯经典案例
 **/
public class solveNQueens0051 {

    @Test
    public void test04(){
        final List<List<String>> lists = solveNQueens(4);
        lists.forEach(System.out::print);
    }

    List<List<String>> result = new ArrayList<>();
    /**
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        //棋盘初始化操作
        for (char[] cchar : chessboard) {
            Arrays.fill(cchar, '.');
        }
        backtracking(0,  chessboard, n);
        return result;
    }
    /**
     * 回溯函数
     *
     * @param curn  当前到了哪一行
     * @param chessboard
     * @param n
     */
    public void backtracking(int curn,  char[][] chessboard, int n) {
        //回溯三部曲：终止条件
        if (curn == n) {
            uplocd(chessboard);
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
     * 工具类，二位数组转一维
     *
     * @param chessboard
     */
    public void uplocd(char[][] chessboard) {
        List<String> sigle = new ArrayList<>();
        for (char[] cchar : chessboard) {
            sigle.add(String.copyValueOf(cchar));
        }
        result.add(sigle);
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
