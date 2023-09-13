package com.GohostQiMo.Algorithm.南京端点科技补的笔试;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author Black_ghost
 * @title: Solution0414
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-09-13 13:29:15
 * @Description 力扣 0414.第三大的数
 **/
@Slf4j
public class Solution0414 {
    /**
     * 笔试时自己写的
     *
     * @param nums
     * @return
     */
    public int thirdMax_old(int[] nums) {
        HashSet<Integer> temp = new HashSet<>();
        for (int item : nums) {
            temp.add(item);
        }
        Integer[] res = new Integer[temp.size()];
        temp.toArray(res);
        Arrays.sort(res);
        if (res.length < 3) {
            return res[res.length - 1];
        } else {
            return res[res.length - 3];
        }
    }

    /**
     * 看了题解写的
     *
     * @param nums
     * @return
     */
    //经过测试：这个题解效率也不高，但是你需要熟悉treeSet的底层数据结构
    public int thirdMax(int[] nums) {
        //TreeSet默认是排序是重小到大的，可以自定义排序规则
        TreeSet<Integer> container=new TreeSet<>();
        for(int num:nums){
            container.add(num);
            //如果树中有4个了，删除最小的一个
            if (container.size()>3){
                //删除指定元素
                container.remove(container.first());
            }
        }
        return container.size()==3 ? container.first(): container.last();
    }
}
