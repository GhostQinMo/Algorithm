package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: solveBM85
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-18 22:15:26
 * @Description 牛客101  BM85 验证IP地址
 **/
@Slf4j
public class solveBM85 {
    @Test
    public void test01(){

    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 验证IP地址
     * @param IP string字符串 一个IP地址字符串
     * @return string字符串
     */
    //你可以认为给定的字符串里没有空格或者其他特殊字符。
    public String solve (String IP) {
        //ipv4
        if(IP.contains(".")){
            String[] arr=IP.split("\\.");
            for(int i=0;i<arr.length;i++){
                int temp=Integer.valueOf(arr[i]);
                if(temp<0 || temp>255){
                    return "Neither";
                }
            }
            return "IPv4";
        }else{
            //ipv6
            String[] arr=IP.split(":");
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[i].length() && arr[i].length()<5;j++){
                    char temp= arr[i].charAt(j);
                    if(!((temp>='0' && temp<='9' )||(temp>='a' && temp <='e')|| (temp>='A' && temp <='E'))){
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
    }
}
