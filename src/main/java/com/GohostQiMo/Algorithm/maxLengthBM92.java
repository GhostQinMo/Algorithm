package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Black_ghost
 * @title: maxLengthBM92
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-19 17:21:43
 * @Description 牛客101  BM92 最长无重复子数组
 **/
@Slf4j
public class maxLengthBM92 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength_self (int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int fast = 0;
        int slow = 0;
        int max_len = 0;
        //使用hashmap是需要注意泛型表示的意思，这里表示数组中的元素和元素出现的次数
        HashMap<Integer, Integer> container = new HashMap<>();
        for (; fast < arr.length; fast++) {
            if (!container.containsKey(arr[fast])) {
                container.put(arr[fast], 1);
            } else {
                //已经有了 移动右指针
                container.put(arr[fast], container.get(arr[fast]) + 1);
            }
            //知道排除前面元素
            while (container.get(arr[fast]) > 1) {
                //删除一个，不能删除这个有两个的key
                container.put(arr[slow], container.get(arr[slow]) - 1);
                slow++;
            }
            //记录最长的
            max_len = Math.max(max_len, fast - slow + 1);    //TODO 这个不能写在37行下面，有特例通不过，不知道原因
        }
        return max_len;
    }


    //题解的一种解法
    public int maxLength (int[] arr) {
        if (arr.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < arr.length; ++i) {
            if (map.containsKey(arr[i])) {
                //这里取重复元素的最左边的哪个 想不到
                j =  Math.max(j,map.get(arr[i]) + 1);
            }
            map.put(arr[i], i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    /**
     * 这种最好理解
     * @param arr
     * @return
     */
    public int maxLength_prefer(int[] arr) {
        //用链表实现队列，队列是先进先出的
        Queue<Integer> queue = new LinkedList<>();
        int res = 0;
        for (int c : arr) {
            while (queue.contains(c)) {
                //如果有重复的，队头出队
                queue.poll();
            }
            //添加到队尾
            queue.add(c);
            res = Math.max(res, queue.size());
        }
        return res;
    }


    @Test
    public void test01(){
        int[] nums=new int[]{3,3,2,1,3,3,3,1};
        final int result = maxLength(nums);
        System.out.println("result = " + result);
    }
}
