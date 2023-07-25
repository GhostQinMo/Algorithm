package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: repeatedSubstringPattern0459
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-25 21:13:05
 * @Description 力扣 重复的字符串0459
 **/
@Slf4j
public class repeatedSubstringPattern0459 {
    //解法一：移动匹配
    public boolean repeatedSubstringPattern(String s) {
        String temp=s+s;
        //注意：这里为什么需要去头去尾？ 因为这里是在s+s中找s，如果去头和尾，肯定会有s的存在
        temp=temp.substring(1,temp.length()-1);
        if (temp.contains(s))
            return true;
        return false;
    }



    //优化：移动匹配+KMP算法   jdk中的contains方法的时间复杂度一般是m*n,而KMP的复杂度是m+n
    public boolean repeatedSubstringPattern_perfer(String s) {
        //TODO
        return false;
    }
}
