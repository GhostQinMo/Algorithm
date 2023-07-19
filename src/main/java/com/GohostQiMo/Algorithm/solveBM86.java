package com.GohostQiMo.Algorithm;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: solveBM86
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-19 10:17:22
 * @Description 牛客101   BM86 大数加法
 **/
@Slf4j
public class solveBM86 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 计算两个数之和
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        if (s == null || s.length() == 0) {
            return t;
        }
        if (t == null || t.length() == 0) {
            return s;
        }
        int len1 = s.length();
        int len2 = t.length();
        //两字符串只差
        int div = Math.abs(len1 - len2);
        //记录len1是短串
        if (len1 > len2) {
            String temp = s;
            s = t;
            t = temp;
        }
        //从后往前加
        char[] res = new char[t.length()];  //开始我用字符串，回超时，改为字符数组不超时了
        //进位
        int up = 0;
        //遍历长的字符串
        int a = 0;
        for (int i = len2 - 1; i >= 0; i--) {
            //合并一位(算出两个是之和)
            int temp = t.charAt(i) - '0' + up;
            //防止短的字符串溢出
            if (len2 - i - 1 < len1) {
                temp += s.charAt(i - div) - '0';
            }
            //下一个进位
            up = temp / 10;
            //当前位的值
            temp = temp % 10;
            res[i] = (char) (temp + '0');
        }
        String result = String.valueOf(res);
        //算最后一个进位
        if (up == 1) {
            result = 1 + result;
        }
        return result;
    }

    @Test
    public void test01() {
        final String result = solve("1", "99");
        System.out.println(result);
        int result1 = 'a' - 'b';
        System.out.println("result = " + result1);
    }
}
