package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @author Black_ghost
 * @title: spiralOrderBM98
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-20 20:36:42
 * @Description 牛客101  BM98 螺旋矩阵
 **/
@Slf4j
public class spiralOrderBM98 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param matrix int整型二维数组
     * @return int整型ArrayList
     */
    public ArrayList<Integer> spiralOrder (int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        //记录长和宽
        int w = matrix.length;
        if(w==0){
            return result;
        }
        int l = matrix[0].length;
        //记录偏移量，保持循环不变量 左闭右开
        int offset = 1;
        //起点
        int start = 0;
        //循环次数
        int loop = Math.min(l, w) / 2;
        while (loop > 0) {
            //上
            for (int i = start; i < l - offset; i++) {
                result.add(matrix[start][i]);
            }
            //右
            for (int i = start; i < w - offset; i++) {
                result.add(matrix[i][l-offset]);
            }
            //下
            for (int i = l-offset;i>start;i--){
                result.add(matrix[w-offset][i]);
            }
            //左
            for(int i=w-offset;i>start;i--){
                result.add(matrix[i][start]);
            }
            start++;
            offset++;
            loop--;
        }
        //查看是否还存在剩余
        if(Math.min(l,w)%2!=0){
            //如果是剩余一行
            if(w<l){
                for(int i=start;i<=l-offset;i++){
                    result.add(matrix[start][i]);
                }
            }else{
                //多了一列
                for(int i=start;i<=w-offset;i++){
                    result.add(matrix[i][start]);
                }
            }
        }
        return result;
    }
}
