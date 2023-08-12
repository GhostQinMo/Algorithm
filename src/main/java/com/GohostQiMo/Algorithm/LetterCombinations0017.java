package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Black_ghost
 * @title: LetterCombinations0017
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-15 07:35:35
 * @Description 0017电话号码的组合
 **/
@Slf4j
public class LetterCombinations0017 {
    public static void main(String[] args) {
        final LetterCombinations0017 letterCombinations = new LetterCombinations0017();
        final List<String> list = letterCombinations.letterCombinations("23");
        list.forEach(System.out::println);

    }
    //存储返回结果
    final ArrayList<String> result = new ArrayList<>();

    /**
     * 思路：回溯法
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || 0 == digits.length()) {
            return result;
        }
        //记录每个数字对应的字母
        String[] numstring = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, numstring, 0);
        return result;
    }
    //存储字符组合成的字符路径
    StringBuilder temp = new StringBuilder(4);

    /**
     * 递归函数
     * @param digits 题目给的数字字符串
     * @param numstring 每个数字对应的字母字符串
     * @param num 遍历到第几个数字了
     */
    public void backTracking(String digits, String[] numstring, int num) {
        //递归终止条件
        if (num == digits.length()) {
            result.add(temp.toString());
            return;
        }
        //去当前字母对应的字符串
        String curnum = numstring[digits.charAt(num) - '0'];
        for (int i = 0; i < curnum.length(); i++) {
            temp.append(curnum.charAt(i));
            backTracking(digits, numstring, num + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
