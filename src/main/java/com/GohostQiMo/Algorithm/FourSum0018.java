package com.GohostQiMo.Algorithm;

import org.junit.Test;

import java.util.*;

/**
 * @author Black_ghost
 * @title: FourSum0018
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-15 08:25:18
 * @Description 0018力扣4数之和
 **/
public class FourSum0018 {
    //还是使用双指针法，难在去重和剪枝
    public static void main(String[] args) {
        final FourSum0018 fourSum = new FourSum0018();
//        int[] nums={0,0,4,-2,-3,-2,-2,-3};
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        final List<List<Integer>> lists = fourSum.fourSum(nums, -294967296);
        lists.forEach(System.out::println);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int left, right;
        for (int i = 0; i < nums.length; i++) {
            //第一次剪枝     note:这里是我第二次来做的时候发现的，这里应该是nums[i]>=0
           /* if (nums[i] > target && target >= 0) {
                break;
            }*/
            if (nums[i] > target && nums[i] >= 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                //第二次剪枝     note:这里是我第二次来做的时候发现的，这里应该是nums[i]+nums[j]>=0
                if (nums[i] + nums[j] > target && nums[i]+nums[j] >=0) {
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                left = j + 1;
                right = nums.length - 1;
                while (left < right) {
                    long temp = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (temp > target) {
                        right--;
                    } else if (temp < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }

                }
            }
        }
        return result;
    }


    @Test
    public void test01() {
        Set<List<Integer>> numset = new HashSet<>();
        numset.add(Arrays.asList(1, 2, 3, 4, 5));
        numset.add(Arrays.asList(1, 2, 3, 4, 5));
        numset.forEach(System.out::println);
    }
}
