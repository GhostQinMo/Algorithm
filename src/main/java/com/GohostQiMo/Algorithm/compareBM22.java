package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: compareBM22
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-10 20:38:32
 * @Description 牛客101 BM22 比较版本号
 **/
@Slf4j
public class compareBM22 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 比较版本号
     * @param version1 string字符串
     * @param version2 string字符串
     * @return int整型
     */
    public int compare (String version1, String version2) {
        // write code here
        int len1=version1.length();
        int len2=version2.length();
        int l1=0,l2=0;
        //只有两个版本遍历结束
        while (l1 <len1  ||  l2 <len2 ){
            //这里需要用long型，不然会溢出
            long  sum1=0;
            //如果遍历'.'直接跳过，比较小一轮
            while (l1 < len1 && version1.charAt(l1) !='.'){
                //这里很巧妙，将前置0字符转为数字出去
                sum1=sum1*10 + (version1.charAt(l1)-'0');
                l1++;
            }
            l1++;
            //这里需要用long型，不然会溢出
            long  sum2=0;
            //如果遍历'.'直接跳过，比较小一轮
            while (l2 < len2 && version2.charAt(l2) !='.'){
                //这里很巧妙，将前置0字符转为数字出去
                sum2=sum2*10 + (version2.charAt(l2)-'0');
                l2++;
            }
            l2++;
            //一个修订好结束，比较两个版本的大小
            if (sum1>sum2){
                return 1;
            }
            if (sum1<sum2){
                return -1;
            }
        }
        return 0;
    }
}
