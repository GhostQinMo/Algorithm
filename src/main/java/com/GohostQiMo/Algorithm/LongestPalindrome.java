package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: LongestPalindrome
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-14 21:37:03
 * @Description 力扣0005最长回文字串
 **/
@Slf4j
public class LongestPalindrome {
    //dp五部曲
    /*1.确定dp数组的下标表示什么，数组中存放的结果表示什么
     * 2.确定递推公式（根据题目分析，这里需要一定的经验）
     * 3.如果和初始化dp数组
     * 4.确定dp数组的遍历顺序(例如：从上至下还是从左至右)
     * 5.举出实例导处dp数组，验证小规模的数据是否正确，也是验证上面四部推出的方案是否可行*/

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome=new LongestPalindrome();
        final String babad = longestPalindrome.longestPalindrome("babad");
        System.out.println(babad);
    }

    public String longestPalindrome(String s) {
        if (s.length()==0||s.length()==1){
            return s;
        }
        boolean[][] palindrome=new boolean[s.length()][s.length()];
        int maxlenth = 1;
        int left = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j <s.length() ; j++) {
                if (s.charAt(i)==s.charAt(j) && (j-i<=1||palindrome[i+1][j-1])){
                    palindrome[i][j]=true;
                    if (j-i+1>=maxlenth){
                        maxlenth=j-i+1;
                        left=i;
                    }
                }
            }
        }
        return s.substring(left,left+maxlenth);
    }
}
