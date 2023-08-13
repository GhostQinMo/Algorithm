package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Black_ghost
 * @title: partition0131
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-13 20:04:08
 * @Description 力扣   131. 分割回文串
 **/
@Slf4j
public class partition0131 {
    /**
     * 题目：给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     *
     * @param s
     * @return
     */
    //思路：分割和组合是一样的
//    1 <= s.length <= 16
//    s 仅由小写英文字母组成
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        //使用dp数组来存储当前子串是不是回文串
        //dp五部曲：1.确定dp数组的含义，数组中的i,j表示什么，这里表示字符串从i位到j位是不是回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        //2.确定递推公式，dp[i][j]=dp[i+1][j-1]&&s[i]==s[j]
        //3.初始化
        //4. 确定遍历顺序（这里需要根据dp方程来决定）
       for (int i = s.length() - 1; i >= 0; i--) {
            //j一定大于等于i，所以只会给dp数组的右上角赋值
            for (int j = i; j < s.length(); j++) {
                //这里分为三种情况
                if (i == j) dp[i][j] = true;  //i和j是同一位
                else if (j - i == 1) dp[i][j] = s.charAt(i) == s.charAt(j); //i和j相邻(只相差一位)
                else dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j); //i和j不相邻
            }
        }
        //5. 举例推导dp数组（想象是发现不了问题的，需要打印dp数组看是否和自己推断一样）
        for (boolean[] booleans : dp) {
            System.out.println("booleans.toString() = " + Arrays.toString(booleans));
        }
        //递归函数
        recursion(s, 0, path, result, dp);
        return result;
    }

    /**
     * 递归函数
     *
     * @param s          原始字符串
     * @param startIndex 开始的位置
     * @param path       当前的路径
     * @param result     结果集
     * @param dp         dp数组,用来判断当前子串是不是回文串
     */
    //回溯三部曲：1.确定递归函数的参数和返回值及其含义
    public void recursion(String s, int startIndex, List<String> path, List<List<String>> result, boolean[][] dp) {
        //回溯三部曲：2. 确定终止条件
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(path));
            return; //这里如果没有返回的话，需要使用else连接下面的逻辑
        }
        //回溯三部曲：3. 单层递归逻辑
        for (int i = startIndex; i < s.length(); i++) {
            //剪枝,如果不是回文串，跳过当前元素的遍历
            if (!dp[startIndex][i]) {
                continue;
            }
            //如果是回文串，将当前子串加入到路径中
            path.add(s.substring(startIndex, i + 1));
            //递归
            recursion(s, i + 1, path, result, dp);
            //回溯
            path.remove(path.size() - 1);
        }
    }

    /**
     * 测试方法
     */
    @Test
    public void test01() {
        String s = "aab";
        List<List<String>> result = partition(s);
        System.out.println("result.toString() = " + result.toString());
    }
}
