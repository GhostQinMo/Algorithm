package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: solveBM91
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-19 16:33:37
 * @Description 牛客101  BM91 反转字符串
 **/
@Slf4j
public class solveBM91 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 反转字符串
     * @param str string字符串
     * @return string字符串
     */
    public String solve (String str) {
        if(str==null){
            return "";
        }
        //双指针解决
        int left=0;
        int rigth=str.length()-1;
        char[] arr=str.toCharArray();
        while(left<rigth){
            char temp=arr[left];
            arr[left]=arr[rigth];
            arr[rigth]=temp;
            left++;
            rigth--;
        }
        return new String(arr);
    }
}
