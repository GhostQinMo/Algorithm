package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: FindBM18
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-09 19:47:36
 * @Description 牛客101 BM18 二维数组中的查找
 **/
@Slf4j
public class FindBM18 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param target int整型
     * @param array int整型二维数组
     * @return bool布尔型
     */
    //个人思路：先找行，再找列(没有注意到规律)
    //进阶:空间复杂度0(1)，时间复杂度O(n + m) ， 做后思考：进阶给出了时间复杂度O(n+m)的话，应该思考到先找行再找列的，应为行+列刚好是m+n
    public boolean Find (int target, int[][] array) {
        //判断特殊情况
        if (array.length==0){
            return false;
        }
        if (array[0].length==0){
            return false;
        }
        /*首先看四个角，左上与右下必定为最小值与最大值，而左下与右上就有规律了：左下元素大于它上方的元素，
        小于它右方的元素，右上元素与之相反。既然左下角元素有这么一种规律，相当于将要查找的部分分成了一个大区间和小区间，
        每次与左下角元素比较，我们就知道目标值应该在哪部分中，于是可以利用分治思维来做。*/
        for (int i = array.length-1, j=0; i >=0 && j<array[0].length ; ) {
            //如果大于左下小于target往右走
            if (array[i][j]<target){
                j++;
            }else if (array[i][j]>target){
                //大于往上走
                i--;
            }else {
                return true;
            }
        }
        return false;
    }
}
