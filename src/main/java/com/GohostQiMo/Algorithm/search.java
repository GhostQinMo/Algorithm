package com.GohostQiMo.Algorithm;

/**
 * @author Black_ghost
 * @title: search
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-23 18:14:25
 * @Description 力扣0704 复习二分法
 **/
public class search {
    public  static void main(String[] args){

    }

    public int search(int[] nums, int target){
        // 注意：这里left right middle全部使用索引就不需要考虑其他的问题
        int left=0,right=nums.length-1;
        while (left<=right){
            int middle=left + (right-left)/2;
            if (nums[middle]<target){
                left=middle+1;
            }else  if (nums[middle]> target){
                right=middle-1;
            }else {
                return middle;
            }
        }
        return -1;
    }
}
