package com.GohostQiMo.Algorithm;

/**
 * @author Black_ghost
 * @title: LCSBM66
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-16 10:13:17
 * @Description 牛客101  BM66 最长公共子串
 **/
public class LCSBM66 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String str1, String str2) {
        int l1=str1.length();
        int l2=str2.length();
        //dp五部曲：1.确定dp数组（包括dp数组中的下标表示什么意思，数组中的值表示什么意思），
        //dp[i][j]在这里表示str1.i（包括）为止的前序与str2.j（包括）为止的前序最长公共子串的长度
        int[][] dp=new int[l1+1][l2+1];
        int max=0;
        int lastPosition=0;
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=0;  //这里为什么可以直接等于0，因为当前位不相等的话，最长长子串已经记录好了
                }
                if(dp[i][j]>max){
                    max=dp[i][j];
                    lastPosition=i-1; //返回的是索引位置
                }
            }
        }
        return str1.substring(lastPosition-max+1,lastPosition+1);
    }
}
