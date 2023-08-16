package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: solveSudoku0037
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-26 07:31:59
 * @Description 递归回溯解数独   力扣0037
 **/
@Slf4j
public class solveSudoku0037 {

    /**
     * 递归回溯解数独,这个与力扣上的0037题的返回值不同，其他的内容多是差不多的
     * @param board
     * @return
     */
    public boolean solveSudoku(char[][]  board){
        //注意：这个题没有终止条件，是因为终止条件包含在了for循环中，如果遍历到到最后for循环回跳出，返回true
        //这里以横维竖经来表示棋盘的坐标
        for (int latitude = 0; latitude < board.length; latitude++) {
            for (int longitude = 0; longitude < board[0].length; longitude++) {
                //剪枝
                if (board[latitude][longitude]!='.'){
                    continue;
                }
                //使用char作为棋盘中的元素。为什么不使用int呢？因为题目给的就是char类型的二维数组
                for (char cur='1';cur <= '9';cur++) {
                    if (isValid(latitude,longitude,cur,board)){
                        board[latitude][longitude]=cur;
                        final boolean b = solveSudoku(board);
                        if (b){
                            return  true;
                        }
                        board[latitude][longitude]='.';
                    }
                }
                //剪枝操作，如果该位置没有一个字符可以满足，那么直接返回false
                return  false;
            }
        }
        //打印board
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar+" ");
            }
            System.out.println();
        }
        return true;
    }

    /**
     * 判断当前位置是否可以放置cur
     * @param latitude
     * @param longitude
     * @param cur
     * @param board
     * @return
     */
    public  boolean isValid(int latitude, int longitude, char cur, char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            if(cur==board[latitude][i]){
                return  false;
            }
        }
        for (char[] ints : board) {
            if (cur == ints[longitude]) {
                return false;
            }
        }
        //找到3*3的方框的左上角的坐标（起点）
        int lati=latitude/3*3;
        int longi=longitude/3*3;
        for (int i = lati; i <lati+3 ; i++) {
            for (int j = longi ; j <longi+3 ; j++) {
                if (board[i][j]==cur){
                    return false;
                }
            }
        }
        return  true;
    }

    @Test
    public void test01(){
        char[][] board={
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'1','.','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','.'},
                {'4','.','.','8','.','3','.','.','.'},
                {'7','.','.','.','2','.','.','.','.'},
                {'9','.','.','.','.','.','6','.','.'},
                {'2','.','.','3','.','.','.','.','.'},
                {'3','.','.','.','.','.','.','.','.'}
        };
        final boolean b = solveSudoku(board);
        System.out.println("b = " + b);
    }
}
