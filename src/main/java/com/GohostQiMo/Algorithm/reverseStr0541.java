package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Black_ghost
 * @title: reverseStr0541
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-25 20:48:33
 * @Description 翻转字符串II 力扣541
 **/
@Slf4j
public class reverseStr0541 {
    /**
     *
     * @param s 给定字符串
     * @param k
     * @return
     */
    public String reverseStr1(String s, int k) {
        //转为数组
        char[] arr = s.toCharArray();
        //遍历（区间坚持左闭右闭）
        for (int i = 0; i < arr.length; i += 2 * k) {
            int start = i;
            //这里注意越界  arr.length-1，如果剩余数目大于k反转k个，否则反转剩余的，注意这里反转的区间是左闭右闭
            int end = Math.min(arr.length-1, i + k - 1);
            while (start < end) {
                arr[start] ^= arr[end];
                arr[end] ^= arr[start];
                arr[start] ^= arr[end];
                start++;
                end--;
            }
        }
        return new String(arr);
    }


    @Test
    public void test() {
         String result = reverseStr1("abcdefg", 2);
        System.out.println(result);
    }

}
