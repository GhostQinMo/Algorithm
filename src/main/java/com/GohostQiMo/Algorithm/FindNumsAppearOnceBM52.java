package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author Black_ghost
 * @title: FindNumsAppearOnceBM52
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-13 21:02:16
 * @Description 牛客101 BM52 数组中只出现一次的两个数字
 **/
@Slf4j
public class FindNumsAppearOnceBM52 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型一维数组
     */
    //hash解法
    public int[] FindNumsAppearOnce (int[] nums) {
        //Integer表示值
        HashSet<Integer> container=new HashSet<>();
        //如果在容器中则删除，最后只剩下只出现了一次的元素
        for (int i = 0; i <nums.length; i++) {
            if (container.contains(nums[i])){
                container.remove(nums[i]);
            }else {
                container.add(nums[i]);
            }
        }
        int[] result=new int[2];
         Iterator<Integer> iterator = container.iterator();
         int i=0;
        while (iterator.hasNext()){
            result[i]=iterator.next();
            i++;
        }
        return result;
    }



    //题解：这个很有意思
    public int[] FindNumsAppearOnce_1 (int[] array) {
        int res1 = 0;
        int res2 = 0;
        int temp = 0;
        //遍历数组得到a^b
        for(int i = 0; i < array.length; i++)
            temp ^= array[i];
        int k = 1;
        //找到两个数不相同的第一位
        while((k & temp) == 0)
            k <<= 1;
        for(int i = 0; i < array.length; i++){
            //遍历数组，对每个数分类
            if((k & array[i]) == 0)
                res1 ^= array[i];
            else
                res2 ^= array[i];
        }
        //整理次序
        if(res1 < res2)
            return new int[] {res1, res2};
        else
            return new int[] {res2, res1};
    }
}
