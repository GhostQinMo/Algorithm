package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: solveBM57
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-15 10:24:56
 * @Description 牛客101 BM57 岛屿数量
 **/
@Slf4j
public class solveBM57 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 判断岛屿数量
     * @param grid char字符型二维数组
     * @return int整型
     */
    //深度搜索（DFS）
    public int solve (char[][] grid) {
        int count=0;
        int x= grid.length;
        if (x==0){
            return count;
        }
        int y=grid[0].length;
        if (y==0){
            return count;
        }
        //遍历
        for (int i = 0; i <x ; i++) {
            for (int j = 0; j <y ; j++) {
                if (grid[i][j]=='1'){
                    count++;
                    //覆盖陆地
                    recursionfun(grid,i,j);
                }
            }
        }
        return count;
    }

    /**
     * 递归函数
     * @param grid
     */
    public void recursionfun(char[][] grid,int x,int y){
        //回溯三部曲 2.终止条件
        if (x<0 || y<0 || y>=grid[0].length|| x >= grid.length ||grid[x][y]=='0' ) return ;
        //覆盖
        grid[x][y]='0';
        //四周扩散
        recursionfun(grid,x+1,y);
        recursionfun(grid,x-1,y);
        recursionfun(grid,x,y+1);
        recursionfun(grid,x,y-1);
    }
}
