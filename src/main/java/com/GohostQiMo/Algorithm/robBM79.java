package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: robBM79
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-18 10:19:40
 * @Description 牛客101  BM79 打家劫舍(二)
 **/
@Slf4j
public class robBM79 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    //这里一题时对打家劫舍I的变种，把数组变成了环形数组
    public int rob (int[] nums) {
        int len1=nums.length;
        int result=0;
        if(nums==null ||len1==0){
            return result;
        }
        if(len1==1){
            return nums[0];
        }
        result=Math.max(robhelper(nums,0,len1-1),robhelper(nums,1,len1));
        return result;
    }

    public int robhelper(int[] nums,int start,int end){
        //三个数代替一维dp数组 (这里巧妙的避开了nums.length()=1的情况)
        int left=0,mid=0,right=0;
        for(int i=start;i<end;i++){
            right=Math.max(left+nums[i],mid);
            left=mid;
            mid=right;
        }
        return right;
    }
}
