package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Black_ghost
 * @title: largestSumAfterKNegations1005
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-04 19:55:20
 * @Description 力扣1005. K 次取反后最大化的数组和
 **/
@Slf4j
public class largestSumAfterKNegations1005 {
    /**
     * 这个题不仅仅学习了贪心算法，还复习了Stream
     *
     * @param nums
     * @param k
     * @return
     */
    //贪心思路：
    /*
        第一步：将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        第二步：从前向后遍历，遇到负数将其变为正数，同时K--
        第三步：如果K还大于0，那么反复转变数值最小的元素，将K用完
        第四步：求和
    */
    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = Arrays.stream(nums).
                boxed().
                sorted((item1, item2) -> Math.abs(item2) - Math.abs(item1)).
                mapToInt(Integer::intValue).
                toArray();
        //将k个负数变为整数
        for (int i = 0; i < nums.length; i++) {
            if (k > 0 && nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        //处理k还有余的情况
        return Arrays.stream(nums).sum()-((k%2==1)? 2*nums[nums.length-1] :0 );
    }

    @Test
    public void test01(){
//        int[] nums={3,-1,0,2};
        int[] nums={2,-3,-1,5,-4};
         int result = largestSumAfterKNegations(nums, 2);
        log.debug("result={}",result);
    }
}
