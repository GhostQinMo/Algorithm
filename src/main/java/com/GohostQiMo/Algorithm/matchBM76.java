package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Black_ghost
 * @title: matchBM76
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-17 16:00:50
 * @Description 牛客101  BM76 正则表达式匹配
 **/
@Slf4j
public class matchBM76 {
    @Test
    public void test01(){
//        final boolean result = match("aaa", "a*a");
//        "aad","c*a*d"
        final boolean result = match("aad", "c*a*d");
        System.out.println("result = " + result);

    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串
     * @param pattern string字符串
     * @return bool布尔型
     */
    public boolean match (String str, String pattern) {
        if (str.length() == 0) {
            return false;
        }
        if ( pattern.length() == 0) {
            return false;
        }
        int len1 = str.length();
        int len2 = pattern.length();
        //dp五部曲： 1.确定dp数组的含义
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        //dp五部曲： 3.初始化操作
        dp[0][0] = true;
        //因为boolean数据类型默认就是 false; 这里只初始化为true的；
        for (int i = 2; i <= len2; i++) {
            if (pattern.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        //第一列就默认初始化了

        //dp五部曲： 确定遍历顺序（根据dp方程可知从左至右，从上至下）
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                //dp五部曲:2 .确定dp推导公式
                //如果字符相等或者是模式串是字符 '.'
                if (pattern.charAt(j - 1) != '*') {
                    if (str.charAt(i - 1) == pattern.charAt(j - 1) ||
                            pattern.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    //当j为*的时(*不可能为第一个字符)
                    if (str.charAt(i - 1) != pattern.charAt(j - 2) &&
                            pattern.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        //这里为什么不需要考虑j-2越界的情况，因为j-1时不可能进入这里，char[0]不能是*；
                        //当当前位置是*的时候存在三种情况
                        //1. *前面字符为0个(也就是直接去掉模式串的*和它前面的一个字符)
                        boolean cate1 = dp[i][j - 2];
                        //2. *前面字符为1个时 (直接去掉模式串的*)
                        boolean cate2 = dp[i][j - 1];
                        //3. *前面为多个时(求导匹配串的字符)
                        boolean cate3 = dp[i - 1][j];
                        dp[i][j] = cate1 || cate2 || cate3;
                    }
                }
            }
        }
        //dp五部曲： 验证，打印dp数组
        return dp[len1][len2];
    }

}
