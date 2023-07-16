package com.GohostQiMo.Algorithm;

/**
 * @author Black_ghost
 * @title: LCSBM65
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-16 09:02:27
 * @Description 牛客101   BM65 最长公共子序列(二)
 **/
public class LCSBM65 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * longest common subsequence
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    //解题思路：见 牛客101   BM65 最长公共子序列(二)题解
    public String LCS (String s1, String s2) {
        int len1=s1.length();
        int len2=s2.length();
        int[][] dp=new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        if(dp[len1][len2]==0){
            return "-1";
        }
        StringBuilder result=new StringBuilder();
        while(len1!=0 && len2!=0){
            //dp[len1][len2]== dp[len1-1][len2-1]  不代表  s1.charAt(len1-1)==s2.charAt(len2-1
            if(s1.charAt(len1-1)==s2.charAt(len2-1)){
                result.append(s1.charAt(len1-1));
                len1--;
                len2--;
            }else if(dp[len1-1][len2]> dp[len1][len2-1]){
                len1--;
            }else{
                len2--;
            }
        }
        return result.reverse().toString();
    }
}
