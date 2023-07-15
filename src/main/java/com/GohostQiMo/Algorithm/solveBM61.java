package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: solveBM61
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-15 19:59:21
 * @Description 牛客101 BM61 矩阵最长递增路径
 **/
@Slf4j
public class solveBM61 {
    @Test
    public void test01(){
        int[][] matrx=new int[][]{{0}};
         int solve = solve(matrx);
        System.out.println("solve = " + solve);
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 递增路径的最大长度
     * @param matrix int整型二维数组 描述矩阵的每个数
     * @return int整型
     */
    private int max =0;
    public int solve (int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++)
                //这里为什么需要传入-1,因为如果传入本身在终止条件中matrix[x][y]<=pre第一次永远为真
                recursion(-1,i,j,matrix,0);
        }
        return max;
    }


    //确定递归函数的参数
    //四个方向
    private int[][]  dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public void recursion(int pre,int x,int y,int[][] matrix,int count){
        //终止条件
        if(x <0  || y <0 ||  x >=matrix.length || y >=matrix[0].length || matrix[x][y]<=pre){
            if(count>max){
                max=count;
            }
            return ;
        }
        for(int i=0;i<4;i++){
            recursion(matrix[x][y],x+dirs[i][0],y+dirs[i][1],matrix,count+1);
        }
    }
}
