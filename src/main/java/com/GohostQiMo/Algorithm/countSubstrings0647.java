package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Objects;

/**
 * @author Black_ghost
 * @title: countSubstrings0647
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-23 21:19:49
 * @Description 力扣 647. 回文子串  （这是计算回文串的数目）
 **/
@Slf4j
public class countSubstrings0647 {
    //这个与0005找出最长回文子串是一样的逻辑，只不过这里是找出回文串的总数，0005题是找出最长的回文串

    /**
     * 使用动态规划解题
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        //边界判断
        if (Objects.isNull(s)) {
            return 1;
        }
        //这里没有写dp五部曲了，因为前面写过的很多题很熟悉了
        int len = s.length();
        boolean[][] dp = new boolean[len][len];  //这里默认初始化了
        //记数
        int count = 0;
        //遍历顺序需要根据dp方程推出来  (从下至上，从左至右)
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    //如果i和j位置上相等且，偏移量没有超过1
                    if (j-i<= 1) {
                        count++;
                        dp[i][j] = true;
                    } else {
                        //编译量超过1的
                        if (dp[i + 1][j - 1]) {
                            count++;
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        return count;
    }


    @Test
    public void test01() {
        log.info("start !!");
        int result = countSubstrings2("fdsklf");
        log.info("result={}", result);
        log.info("end !!");
    }


    //优化
    public int countSubstrings_prefer(String s) {
        //边界判断
        if (Objects.isNull(s)) {
            return 1;
        }
        //这里没有写dp五部曲了，因为前面写过的很多题很熟悉了
        int len = s.length();
        boolean[][] dp = new boolean[len][len];  //这里默认初始化了
        //记数
        int count = 0;
        //遍历顺序需要根据dp方程推出来  (从下至上，从左至右)
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j-i<=1 || dp[i+1][j-1]))
                    dp[i][j]=true;
            }
        }
        return count;
    }


    //中心扩散法

    public int countSubstrings2(String s) {
        int result=0;
        if (Objects.isNull(2) || s.length()==0) return 0;
        int len=s.length();
        for (int i = 0; i <len; i++) {
            //以一个点为中心或者以两个点为中心向两边扩展
            result+=helper(s,i,i);
            result+=helper(s,i,i+1);
        }
        return result;
    }

    public int helper(String s,int start,int end){
        int result=0;
        while (start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            result++;
            start--;
            end++;
        }
        return result;
    }
}
