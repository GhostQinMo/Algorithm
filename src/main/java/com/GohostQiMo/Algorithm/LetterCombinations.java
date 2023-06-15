package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Black_ghost
 * @title: LetterCombinations
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-15 07:35:35
 * @Description 0017电话号码的组合
 **/
@Slf4j
public class LetterCombinations {
    public static void main(String[] args){
        final LetterCombinations letterCombinations = new LetterCombinations();
        final List<String> list = letterCombinations.letterCombinations("23");
        list.forEach(System.out::println);

    }
    final ArrayList<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits){
        if (digits == null || 0 == digits.length()) {
            return result;
        }
        String[] numstring={"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits,numstring,0);
        return result;
    }
    StringBuilder temp  =new StringBuilder(4);
    public void backTracking(String digits,String[] numstring,int num){
            if (num==digits.length()){
                result.add(temp.toString());
                return ;
            }
            String curnum=numstring[digits.charAt(num)-'0'];
        for (int i = 0; i < curnum.length(); i++) {
            temp.append(curnum.charAt(i));
            backTracking(digits,numstring,num+1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
