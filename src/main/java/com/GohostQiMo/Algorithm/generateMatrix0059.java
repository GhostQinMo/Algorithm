package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: generateMatrix0059
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-04 14:30:40
 * @Description 力扣0059 螺旋矩阵2
 **/
@Slf4j
public class generateMatrix0059 {
    @Test
    public void test01(){
        final int[][] ints =generateMatrix(4);
    }

    public int[][] generateMatrix(int n) {
        //返回结果
        int[][] result=new int[n][n];
        //控制每一层的起始位置
        int startx=0,starty=0;
        //控制循环的层数
        int loop=n/2;
        //控制填充的数字
        int count=1;
        //控制右边界,因为使用的左闭右开，所以开始的时候就是有1的偏移量
        int offset=1;
        while (loop>0){
            //上
            for (int i = starty; i <n-offset ; i++) {
                result[startx][i]=count++;
            }
            //右
            for (int i = startx; i <n-offset ; i++) {
                result[i][n-offset]=count++;
            }
            //下
            for (int i = n-offset; i >startx ; i--) {
                result[n-offset][i]=count++;
            }
            //左
            for (int i = n-offset; i>startx ; i--) {
                result[i][startx]=count++;
            }
            loop--;
            startx++;
            starty++;
            offset++;
        }
        //如果n是基数的话，中间的一个数需要独立处理
        if (n%2!=0){
            result[n/2][n/2]=count++;
        }
        return result;
    }
}
