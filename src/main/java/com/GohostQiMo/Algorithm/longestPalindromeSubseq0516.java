package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Objects;

/**
 * @author Black_ghost
 * @title: longestPalindromeSubseq0516
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-23 22:03:45
 * @Description 力扣 0516 最长回文子序列
 **/
@Slf4j
public class longestPalindromeSubseq0516 {

    //dp解决
    public int longestPalindromeSubseq(String s) {
        if (Objects.isNull(s) || s.length()==0)  return 0;
        int len=s.length();
        int[][] dp=new int[len][len];
        //初始化dp （需要根据场景来分析怎么初始化）
        //1.当i位与位相等时一定，最长子序列一定为1  其他位置默认值即可
        for(int i=0;i<len;i++){
            dp[i][i]=1;
        }
        //遍历顺序从下至上，从左至右
        for (int i = len-1; i >=0; i--) {
            for(int j=i+1;j<len;j++){
                //如果i位和j位相等
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else {
//                   如果s[i]与s[j]不相同，说明s[i]和s[j]的同时加入 并不能增加[i,j]区间回文子序列的长度，那么分别加入s[i]、s[j]看看哪一个可以组成最长的回文子序列。
//                   加入s[j]的回文子序列长度为dp[i + 1][j]。
//                   加入s[i]的回文子序列长度为dp[i][j - 1]。
                    dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        //最后的结果也需要根据实际场景来分析
        return dp[0][len-1];
    }

    @Test
    public void test01() {
        log.info("start !!");
        int result = longestPalindromeSubseq("bbbab");
        log.info("result={}", result);
        log.info("end !!");
    }


}
