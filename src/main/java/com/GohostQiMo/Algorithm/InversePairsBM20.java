package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author Black_ghost
 * @title: InversePairsBM20
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-09 21:40:07
 * @Description 牛客101 BM20数组中的逆序对
 **/
@Slf4j
public class InversePairsBM20 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    //要求:空间复杂度O(n),时间复杂度O(nlogn)
    //题目保证输入的数组中没有的相同的数字   归并排序
    int count=0;
    public int mod = 1000000007;
    public int InversePairs(int[] nums) {
         sort1(nums);
         return count%mod;
    }

    public int[] sort1(int[] nums){
        if (nums.length==1){
            return nums;
        }
        //全部使用索引
        int mid=nums.length/2;
         int[] leftnums = sort1(Arrays.copyOfRange(nums, 0, mid));
         int[] rightnums = sort1(Arrays.copyOfRange(nums, mid, nums.length));
        return merge(leftnums, rightnums);
    }
    /**
     * 并
     * @param leftnums
     * @param rightnums
     * @return
     */
    public int[] merge(int[] leftnums,int[] rightnums){
        int[] result=new int[leftnums.length+rightnums.length];
        int leftlen=0;
        int rightlen=0;
        int curidx=0;
        while (leftlen<leftnums.length && rightlen<rightnums.length){
            //如果左边小于右边，左边入库 不存在逆序对
            if (leftnums[leftlen] <rightnums[rightlen]){
                result[curidx]=leftnums[leftlen];
                leftlen++;
                //题目保证输入的数组中没有的相同的数字 所以不需要考虑等于
            }else {
                //如果左边大于右边,右边入库，存在逆序对
                result[curidx]=rightnums[rightlen];
                //记录逆序对
                count+=leftnums.length-leftlen;
                count%=mod;
                rightlen++;
            }
            //当前指针右移
            curidx++;
        }
        //处理剩余的
        //左变右剩余
        while (leftlen<leftnums.length){
            result[curidx++]=leftnums[leftlen++];
        }
        //如果右边右剩余
        while (rightlen<rightnums.length){
            result[curidx++]=rightnums[rightlen++];
        }
        return  result;
    }
}
