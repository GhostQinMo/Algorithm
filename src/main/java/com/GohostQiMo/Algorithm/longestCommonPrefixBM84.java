package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: longestCommonPrefixBM84
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-18 21:40:57
 * @Description 牛客101  BM84 最长公共前缀
 **/
@Slf4j
public class longestCommonPrefixBM84 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param strs string字符串一维数组
     * @return string字符串
     */
    public String longestCommonPrefix (String[] strs) {
        int len=strs.length;
        if(len==0){
            return  "";
        }
        if(len==1){
            return strs[0];
        }
        //遍历列
        for(int i=0;i<strs[0].length();i++){
            //遍历行
            for(int j=1;j<len;j++){
                //不相等就结束   （如果长度等于i的表示当前字符串的长度小于第一个字符串的长度）
                //如果找到长度最小的字符 或者 两个字符的第i位不相等了 则结束
                if( strs[j].length()==i  ||  strs[j].charAt(i)!=strs[0].charAt(i)){
                    return strs[0].substring(0,i); //不包括i
                }
            }
        }
        return strs[0];
    }
}
