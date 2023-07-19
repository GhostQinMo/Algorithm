package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: judgeBM88
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-19 11:37:05
 * @Description 牛客101  BM88 判断是否为回文字符串
 **/
@Slf4j
public class judgeBM88 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    //这个做了好几遍了没有写完全注释，看的懂就行
    public boolean judge (String str) {
        //题目给出了数据规范 str.length()>0
        //这里也不需要判断边界问题，全部包含了在面的代码中了
        int right=str.length()-1;
        int left=0;
        while(left<right){
            if(str.charAt(left)==str.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
