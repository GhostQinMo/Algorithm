package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: removeElement0027
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-22 16:34:58
 * @Description 力扣0027移除元素
 **/
@Slf4j
public class removeElement0027 {
    /**
     *  使用双指针，在原数组上进行修改。时间复杂度O(n),空间复杂度O(1)
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums,int val ){
        //慢指针用户记录最终返回的长度
        int slowIndex=0;
        for (int i = 0; i < nums.length; i++) {
            //不等于val的时候，将值赋给慢指针的位置，然后慢指针+1，记录长度
            if (nums[i]!=val){
             nums[slowIndex++]=nums[i];
            }
        }
        return slowIndex;
    }
}

