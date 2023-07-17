package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: getLongestPalindromeBM73
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-16 17:41:18
 * @Description 牛客101 BM73 最长回文子串
 **/
@Slf4j
public class getLongestPalindromeBM73 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param A string字符串
     * @return int整型
     */
    //先前使用动态规划写过 LongestPalindrome0005  但是时间、空间复杂度比较高 时间复杂度：O(n^2) 空间复杂度：O(n^2)
    //坚持左闭右闭
    public int getLongestPalindrome (String A) {
        int result=1;
        for(int i=0;i<A.length();i++){
            //分别以当前元素为中心向两边扩散（一个字符中心和两个元素为中心）
            int max=getLongestPailnedromeHelper(A,i,i);
            int max2=getLongestPailnedromeHelper(A,i,i+1);
            int temp=Math.max(max,max2);
            result= temp>result ?temp :result;
        }
        return result;
    }
    public int getLongestPailnedromeHelper(String str,int start,int end){

        while(start>=0 && end<str.length() && str.charAt(start)==str.charAt(end)){
            start--;
            end++;
        }
        //这里如果返回负数会怎么样？ 不需要管，因为即使返回负数，result初始化为1 会过滤掉的
        return end-start-1;
    }
}
