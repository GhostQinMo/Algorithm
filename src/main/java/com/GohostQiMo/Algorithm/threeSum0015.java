package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Black_ghost
 * @title: threeSum0015
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-14 22:49:20
 * @Description 力扣3数之和0015
 **/
@Slf4j
public class threeSum0015 {
    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
        final threeSum0015 threeSum0015 = new threeSum0015();
        final List<List<Integer>> lists = threeSum0015.threeSum(nums);
        lists.forEach(System.out::println);
    }

    //什么时候不能用map结构来做，这里个与两数之和有什么区别？由于这里需要排序，会导致索引乱套
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return result;
        }
        Integer numsLength = nums.length;
        int left, right;
        for (int i = 0; i < numsLength; i++) {
            left = i + 1;
            right = numsLength - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (temp > 0) {
                    right--;
                } else if (temp < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left<right&&nums[right]== nums[right-1]) {
                        right--;
                    }
                    while (left<right&&nums[left]== nums[left+1]) {
                        left++;
                    }
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
