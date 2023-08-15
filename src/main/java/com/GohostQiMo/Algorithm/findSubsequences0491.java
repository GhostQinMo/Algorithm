package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Black_ghost
 * @title: findSubsequences0491
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-14 20:01:00
 * @Description 力扣  491. 递增子序列
 **/

@Slf4j
public class findSubsequences0491 {
    /**
     * 题目：给定一个整型数组,找出满足条件的递增子序列
     *
     * @param nums
     * @return
     */
    //提示：这个与子集I和子集II的区别在于,这里千万不能排序，而且树的同层去重需要用到used数组或者hash

    //结果集
    List<List<Integer>> result = new ArrayList<>();
    //路径
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        recursion(nums, 0);
        return result;
    }

    /**
     * @param nums       给定数组
     * @param startIndex 当前遍历的索引
     */
    public void recursion(int[] nums, int startIndex) {
        //这里也是求子集类似的所以也可以不许终止条件,但是题目有要求，递增子序列至少有两个元素
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
            //这里不需要返回，这里不仅仅是收集叶子节点的值，还需要收集中间节点的值
//            return ;
        }
        //用于当前层去重
        /*因为：1 <= nums.length <= 15    -100 <= nums[i] <= 100
         * 索引使用数组代替hash*/
        boolean[] used = new boolean[201];
        //遍历
        for (int i = startIndex; i < nums.length; i++) {
            //如果路径不为空，且当前元素小于路径中最后一个元素或者当前元素已经被使用过了，那么就跳过
            //used[nums[i] + 100] 保证了树的同层不会出现重复元素，但是不同层可以出现重复元素，也就会同一树枝上的元素可以重复
            if ((path.size() > 0 && nums[i] < path.get(path.size() - 1)) || used[nums[i] + 100]) {
                continue;
            }
            //加入单层已经使用过的元素
            used[nums[i] + 100] = true;
            path.add(nums[i]);
            recursion(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test01(){
        int[] nums = {4,6,7,7};
//        int[] nums = {4,4,3,2,1};
        List<List<Integer>> subsequences = findSubsequences(nums);
        log.info("subsequences:{}",subsequences);
    }
}
