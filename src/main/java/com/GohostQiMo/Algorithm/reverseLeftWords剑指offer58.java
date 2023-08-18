package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: reverseLeftWords剑指offer58
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-18 10:03:58
 * @Description 剑指 Offer 58 - II. 左旋转字符串
 **/
@Slf4j
public class reverseLeftWords剑指offer58 {
    /**
     *
     * @param s
     * @param n
     * @return
     */
    //在不使用额外空间的情况下，将字符串前面的n个字符移动到字符串的尾部
    //这里为什么n不要对s.length()取余呢？题目测试数据给出：1 <= n < s.length <= 10000
    public String reverseLeftWords(String s, int n) {
         char[] chars = s.toCharArray();
        //反转前面n个字符
        reverse(chars,0,n-1);
        reverse(chars,n,s.length()-1);
        reverse(chars,0,s.length()-1);
        return String.valueOf(chars);
    }

    //反转函数
    public void  reverse(char[] arr,int start,int end){
        while (start<end){
            arr[start]^=arr[end];
            arr[end]^=arr[start];
            arr[start]^=arr[end];
            start++;
            end--;
        }
    }


    @Test
    public void test01(){
        String str="abcdefg";
        final String s = reverseLeftWords(str, 2);
        System.out.println(s);
    }
}
