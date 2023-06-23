package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author Black_ghost
 * @title: searchRange
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-23 20:41:39
 * @Description 力扣0034
 **/
@Slf4j
public class searchRange {
    public static void main(String[] args) {
        final searchRange searchRange = new searchRange();
        int[] nums=new int[]{1};
        final int[] ints = searchRange.searchRange(nums, 1);
        System.out.println(Arrays.toString(ints));

    }
   //这里很奇怪，如果flag使用-1的话，输入[1] 1 得不到正确的答案  ，原因是我去左右边界的时候本来就是取得不包括target的，所以如果targer就在第一个，左边界
    //返回的也是-1，这就冲突了
    //二分查找，找target的右边界
    public int getRightBorder(int[] nums ,int target){
        //为了解决target在nums数组范围的左边，定义一个标识
//        int flag=-2;
        int flag=-1;
        int right=nums.length-1,left=0;
        while (left<=right){
            int middle= left+(right-left)/2;
            if (nums[middle] >target){
                right=middle-1;
            }else {
                left=middle+1;
                flag=left;
            }
        }
        return flag;
    }

    //二分查找，找target的左边界
    public int getLeftBorder(int[] nums,int targer){
        int right=nums.length-1,left=0;
//        int flag=-2;
        int flag=-1;
        while (left<=right){
            int middle=left+(right-left)/2;
            if (nums[middle] >= targer){
                right=middle-1;
                flag=right;
            }else {
                left=middle+1;
            }
        }
        return flag;
    }

    //处理三种情况{
    public int[] searchRange(int[] nums, int target){
        final int leftBorder = getLeftBorder(nums, target);
        final int rightBorder = getRightBorder(nums, target);
//        if (leftBorder==-2 || rightBorder==-2){
        if (leftBorder==-1 || rightBorder==-1){
            return new int[]{-1,-1};
        }
        if (rightBorder-leftBorder>1){
            return new int[]{leftBorder+1,rightBorder-1};
        }
        return  new int[]{-1,-1};
    }


   /* int[] searchRange(int[] nums, int target) {
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        // 情况一
        if (leftBorder == -2 || rightBorder == -2) return new int[]{-1, -1};
        // 情况三
        if (rightBorder - leftBorder > 1) return new int[]{leftBorder + 1, rightBorder - 1};
        // 情况二
        return new int[]{-1, -1};
    }

    int getRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2; // 记录一下rightBorder没有被赋值的情况
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] > target) {
                right = middle - 1;
            } else { // 寻找右边界，nums[middle] == target的时候更新left
                left = middle + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    int getLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2; // 记录一下leftBorder没有被赋值的情况
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] >= target) { // 寻找左边界，nums[middle] == target的时候更新right
                right = middle - 1;
                leftBorder = right;
            } else {
                left = middle + 1;
            }
        }
        return leftBorder;
    }*/
}
