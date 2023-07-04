package com.GohostQiMo.Algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Black_ghost
 * @title: spiralOrder0054
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-04 14:11:59
 * @Description 力扣 0054 螺旋矩阵
 **/
public class spiralOrder0054 {
    @Test
    public void test01(){
         int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        final List<Integer> list = spiralOrder(matrix);
        list.forEach(System.out::print);
    }

    /**
     * 这一类题全部是在循环中需要坚持循环不变量
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        //确定循环的次数
       int loop=Math.min(matrix.length,matrix[0].length)/2;
       //确定每次打印一层的最开始的位置
       int startx=0,starty=0;
       int rowlength=matrix.length,collength=matrix[0].length;
       //确定右边的偏移量，因为这类问题全部多需要遵循循环不变量的,这里采用的还是左闭右开的原则
        int offset=1;
      while (loop>0){
          //上
          for (int i =starty; i <collength-offset; i++) {
              result.add(matrix[startx][i]);
          }
          //右
          for (int i = startx; i <rowlength-offset ; i++) {
              result.add(matrix[i][collength-offset]);
          }
          //下
          for (int i = collength-offset; i >starty; i--) {
              result.add(matrix[rowlength-offset][i]);
          }
          //左
          for (int i = rowlength-offset; i >startx ; i--) {
              result.add(matrix[i][starty]);
          }
          loop--;
          startx++;
          starty++;
          offset++;
      }
      //loop为基数的情况，需要独立处理中间一行或者中间一列
        //这里自己画图才能理解：只有当行和列中的最小值为基数时才需要处理
      if (Math.min(matrix.length,matrix[0].length)%2 !=0){
        //此时的starx starty值就是在多出的一列或者一行上
          if (matrix.length>matrix[0].length){
              //多了一列
              for (int i = startx; i <= rowlength-offset; i++) {
                  result.add(matrix[i][starty]);
              }
          }else {
              for (int i = starty; i <=collength- offset; i++) {
                  result.add(matrix[startx][i]);
              }
          }
      }
        return result;
    }
}
