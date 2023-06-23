package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: removeElement
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-22 16:34:58
 * @Description 力扣0027移除元素
 **/
@Slf4j
public class removeElement {
    public  static void  main(String[] args){

    }
    public int removeElement(int[] nums,int val ){
        int slowIndex=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val){
             nums[slowIndex++]=nums[i];
            }
        }
        return slowIndex;
    }
}

