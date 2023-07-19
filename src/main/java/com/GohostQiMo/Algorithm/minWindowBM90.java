package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: minWindowBM90
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-19 15:05:06
 * @Description 牛客101  BM90 最小覆盖子串
 **/
@Slf4j
public class minWindowBM90 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param S string字符串
     * @param T string字符串
     * @return string字符串
     */
    //暴力试一试
    public String minWindow_force (String S, String T) {
        //用于记录当
        int left=0;
        return "";
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param S string字符串
     * @param T string字符串
     * @return string字符串
     */
    //双指针的经典例题
    public String minWindow (String S, String T) {
        //判断边界
        if(S==null || T==null || S.length()==0 || T.length()==0 || S.length()<T.length()){
            return "";
        }
        //这里使用数组代替hash表
        int[] hash=new int[128];  //说明一下这里为什么128,因为z的ascll码为122，然后调整为8的倍数
        //标价区间
        int left=-1;
        int right=-1;
        //标记 快慢指针
        int slow=0;
        int fast=0;
        int len1=S.length();
        int len2=T.length();
        //预存T
        for(int i=0;i<len2;i++){
            hash[T.charAt(i)]-=1;
        }
        //遍历
        // 记录最优解
        int cur_min=Integer.MAX_VALUE;
        for(;fast<len1;fast++){
            hash[S.charAt(fast)]+=1;
            while(check(hash)){
                //当前区间合格，判断是否为最优解
                int temp=fast-slow+1;
                if(temp<cur_min){
                    cur_min=temp;
                    //记录区间
                    left=slow;
                    right=fast;
                }
                //慢指针移动  这里必须放在if的外面，因为只要当前区间还符合就slow指针就需要右移动
                hash[S.charAt(slow)]-=1;
                slow++;
            }
        }
        //结束 判断是否找到
        if(left==-1){
            return "";
        }
        return S.substring(left,right+1);
    }

    //用于检查是否当前区间是合格区间
    public boolean check(int[] ints){
        boolean falg=false;
        for(int i=0;i<ints.length;i++){
            if(ints[i]<0){
                return falg;
            }
        }
        return !falg;
    }
}
