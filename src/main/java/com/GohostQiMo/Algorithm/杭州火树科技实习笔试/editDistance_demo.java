package com.GohostQiMo.Algorithm.杭州火树科技实习笔试;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: editDistance_demo
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-09-03 15:28:06
 * @Description 编辑距离（一）
 **/
@Slf4j
public class editDistance_demo {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param word1 string字符串
     * @param word2 string字符串
     * @return int整型
     */
    public int editDistance (String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        //采用dp解决
        // dp[i][j]中的i和j表示str1从0到i-1位（包含）与str2从0到j-1位（包含）,至少需要操作多少次,str1才等于str2
        //至于为什么需要采用i-1而不是i，是因为可以更好的初始化操作
        int[][] dp=new int[len1+1][len2+1];
        //初始化
        //初始化第一行：dp[0][i]，表示word1是一个空串，而word2是一个长度为i的字符串,索引号为i-1,所以需要操作i次
        for (int i = 1; i <=len2 ; i++) {
            dp[0][i]=i;
        }
        for (int i =1 ; i <=len1; i++) {
            dp[i][0]=i;
        }
        //dp方程
        for (int i=1;i<=len1;i++){
            for (int j = 1; j <=len2 ; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[len1][len2];
    }


    @Test
    public void test01(){
        String str1="nowcodee";
        String str2="new";
         int i = editDistance(str1, str2);
        System.out.println("i = " + i);
    }
}
