package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: solveSudoku
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-26 07:31:59
 * @Description 递归回溯解数独   力扣0037
 **/
@Slf4j
public class solveSudoku{
    public static void main(String[] args) {

    }

    public boolean solveSudoku(char[][]  board){
        for (int latitude = 0; latitude < board.length; latitude++) {
            for (int longitude = 0; longitude < board[0].length; longitude++) {
                if (board[latitude][longitude]!='.'){
                    continue;
                }
                for (char cur='1';cur <= '9';cur ++) {
                    if (isValid(latitude,longitude,cur,board)){
                        board[latitude][longitude]=cur;
                        final boolean b = solveSudoku(board);
                        if (b){
                            return  true;
                        }
                        board[latitude][longitude]='.';
                    }
                }
                return  false;
            }
        }
        return true;
    }

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

}
