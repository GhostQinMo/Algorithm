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
        //注意：这里为什么需要去头去尾？ 因为这里是在s+s中找s，如果不去头和尾，肯定会有s的存在
        temp=temp.substring(1,temp.length()-1);
        if (temp.contains(s))
            return true;
        return false;
    }



    //优化：移动匹配+KMP算法   jdk中的contains方法的时间复杂度一般是m*n,而KMP的复杂度是m+n
    public boolean repeatedSubstringPattern_prefer(String s) {
        //这里注意：最长相等前后缀的规则：当一个字符串由重复子串组成的，最长相等前后缀不包含的子串就是最小重复子串
        //而KMP的next数组就是求的就是最长前后缀的长度
        int len=s.length();
         int[] next = getNext(s, new int[len]);
         //取最后一个字符的最长前后缀的长度
         int max_length = next[len - 1];
         //必须存在最长前后缀才能比较，不然肯定不是重复串，所以先判断max_length是否为0
         if (max_length!=0 && len%(len-max_length)==0){
             return true;
         }
        return false;
    }

    //这里还是使用前缀表来表示next数组，不做减一和右移动操作

    /**
     * 获取指定字符串的next数组
     * @param s  指定字符串
     * @param next  next数组
     * @return
     */
    public int[] getNext(String s,int[] next){
        if (s==null || s.length()==0){
            return next ;
        }
        //初始化
        next[0]=0;
        //i表示（包括i在内的）最长相等前后缀的后缀最后一位索引位置，j表示最长相等前后缀的前缀的最后一位索引位置
        int i=1,j=0;
        int len=s.length();
        for (; i <len ; i++) {
            //j和i索引位上的字符不相等的情况  注意这里是while,不是if
            while (j>0 && s.charAt(i)!=s.charAt(j)){
                //找前一位的最长相等前后缀的长度
                j=next[j-1];
            }
            //如果相等
            if(s.charAt(i)==s.charAt(j)){
                j++; //记录一下当前的最长相等前后缀的长度
            }
            //赋值  至于i在for循环中自动增加了，时间复杂度为O(N)
            next[i]=j;
        }
        return next;
    }

}
