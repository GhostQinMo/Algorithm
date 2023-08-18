package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: strStr0028
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-22 22:13:37
 * @Description KMP字符串匹配
 **/
@Slf4j
public class strStr0028 {
    public static void main(String[] args){
        strStr0028 strfun=new strStr0028();
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
        //遍历文本串
        for (int i = 0; i < haystack.length(); i++) {
            //注意：这里没有匹配上，就需要找前一位的最长前后缀的长度，然后继续匹配
            while (j>0 && haystack.charAt(i)!=needle.charAt(j)){
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
     * @param next next数组
     * @param s 模式串
     */
    //前缀是指不包含最后一个字符的所有以第一个字符开头的连续子串；后缀是指不包含第一个字符的所有以最后一个字符结尾的连续子串
    public void getNext(int[] next, String s){
        //初始化
        next[0]=0;
        int j=0;
        //设置j为前缀末尾，i为后缀末尾，j也为匹配上的最长前后缀的的长度（包括j本身），也就是next数组的值
        //因为j是长度，所以s.chatAt(j)就是最长前缀的后一位啊，所以s.charAt(j)!=s.charAt(i)
        //匹配不上时，找的就是最长前缀的后一位，也就是next数组的值
        for (int i = 1; i < next.length; i++) {
            //前后缀不匹配上的情况，注意这里是while循环，如果一直匹匹配补上，那么j就会一直往前移动，直到j=0
            while (j>0 &&s.charAt(j)!=s.charAt(i)){
                j=next[j-1];
            }
            //前后缀匹配上的情况
            // 这里的判断是为了解决索引为0时设置的，否则可以直接j++;
            //例如：ab字符串的next数组为[0,0]，如果不加这个判断，那么next[1]=1，但是实际上next[1]=0
            if (s.charAt(i)==s.charAt(j)){
                j++;
            }
            //设置next数组的值
            next[i]=j;
        }
    }
}
