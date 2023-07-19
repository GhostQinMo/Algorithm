package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Pattern;

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
    public void test01() {
        final String solve = solve("2001:0db8:85a3:0:000:8A2E:0370:7334");
        System.out.println("solve = " + solve);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 验证IP地址
     * @param IP string字符串 一个IP地址字符串
     * @return string字符串
     */
    //你可以认为给定的字符串里没有空格或者其他特殊字符。
    boolean isIPv4 (String IP) {
        if (IP.indexOf('.') == -1) {
            return false;
        }
        String[] s = IP.split("\\.");
        //IPv4必定为4组
        if (s.length != 4)
            return false;
        for (int i = 0; i < s.length; i++) {
            //不可缺省，有一个分割为零，说明两个点相连
            if (s[i].length() == 0)
                return false;
            //比较数字位数及不为零时不能有前缀零
            if (s[i].length() < 0 || s[i].length() > 3 || (s[i].charAt(0) == '0' &&
                    s[i].length() != 1))
                return false;
            int num = 0;
            //遍历每个分割字符串，必须为数字
            for (int j = 0; j < s[i].length(); j++) {
                char c = s[i].charAt(j);
                if (c < '0' || c > '9')
                    return false;
                //转化为数字比较，0-255之间
                num = num * 10 + (int)(c - '0');
                if (num < 0 || num > 255)
                    return false;
            }
        }
        return true;
    }
    boolean isIPv6 (String IP) {
        if (IP.indexOf(':') == -1) {
            return false;
        }
        String[] s = IP.split(":", -1);
        //IPv6必定为8组
        if (s.length != 8) {
            return false;
        }
        for (int i = 0; i < s.length; i++) {
            //每个分割不能缺省，不能超过4位
            if (s[i].length() == 0 || s[i].length() > 4) {
                return false;
            }
            for (int j = 0; j < s[i].length(); j++) {
                //不能出现a-fA-F以外的大小写字符
                char c = s[i].charAt(j);
                boolean expr = (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' &&
                        c <= 'F') ;
                if (!expr) {
                    return false;
                }
            }
        }
        return true;
    }

    String solve(String IP) {
        if (isIPv4(IP))
            return "IPv4";
        else if (isIPv6(IP))
            return "IPv6";
        return "Neither";
    }


    @Test
    public void test02(){
        String str="2001:0db8:85a3:0:000:8A2E:0370:7334    :fda    :   ";
        final String[] split = str.split(":", 2);
        System.out.println("split.length = " + split.length);
        System.out.println("Arrays.toString(split) = " + Arrays.toString(split));
        final String[] split2 = str.split(":",0);
        System.out.println("Arrays.toString(split2) = " + Arrays.toString(split2));
        final String[] split3 = str.split(":", -1);
        System.out.println("Arrays.toString(split3) = " + Arrays.toString(split3));
    }
}
