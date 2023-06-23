package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: strStr
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-22 22:13:37
 * @Description KMP字符串匹配
 **/
@Slf4j
public class strStr {
    public static void main(String[] args){
        strStr strfun=new strStr();
        final int i = strfun.strStr("sadbutsad", "sad");
        System.out.println("i = " + i);
    }

    /**
     * KMP字符串匹配
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (haystack.length()==0 && needle.length()==0){
            return 0;
        }
        int[] next=new int[needle.length()];
        getNext(next,needle);
        int j=0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j>0 && haystack.charAt(j)!=needle.charAt(i)){
                j=next[j-1];
            }
            if (haystack.charAt(i)==needle.charAt(j)){
                j++;
            }
            if (j==needle.length()){
                return i-needle.length()+1;

            }
        }
        return -1;
    }

    /**
     * 不处理的前缀数组(不做减一处理也不做右移处理)
     * @param next
     * @param s
     */
    public void getNext(int[] next, String s){
        //初始化
        next[0]=0;
        int j=0;
        //设置j为前缀末尾，i为后缀末尾，j也为匹配上的最长前后缀的的长度（包括j本身），也就是next数组的值
        for (int i = 1; i < next.length; i++) {
            //前后缀不匹配上的情况
            while (j>0 &&s.charAt(j)!=s.charAt(i)){
                j=next[j-1];
            }
            //前后缀匹配上的情况 // 这里的判断是为了解决索引为0时设置的，否则可以直接j++;
            if (s.charAt(i)==s.charAt(j)){
                j++;
            }
            //设置next数组的值
            next[i]=j;
        }
    }
}
