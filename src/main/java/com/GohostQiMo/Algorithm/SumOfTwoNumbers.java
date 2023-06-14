package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Black_ghost
 * @title: SumOfTwoNumbers
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-13 22:08:16
 * @Description 力扣0001两数之和
 **/
@Slf4j
public class SumOfTwoNumbers {
    public static void main(String[] args){
        int[]  nums={1,2,3,4,9,5,7};
        int target=16;
        final SumOfTwoNumbers sumOfTwoNumbers = new SumOfTwoNumbers();
        final int[] ints = sumOfTwoNumbers.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    /**
     *   两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target){
        int[] result=new int[2];
        if (nums.length==0|| nums==null){
            return result;
        }
        Map<Integer,Integer> storeMap=new HashMap();
        storeMap.put(nums[0],0);
        for (int i = 1; i < nums.length; i++) {
            int temp= target-nums[i];
            if (storeMap.containsKey(temp)){
                result[0]=storeMap.get(temp);
                result[1]=i;
                break;
            }else {
                storeMap.put(nums[i],i);
            }
        }
        return result;
    }

}
