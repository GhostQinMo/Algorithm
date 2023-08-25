package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: isAnagram0242
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-25 21:49:44
 * @Description 力扣  242. 有效的字母异位词
 **/
@Slf4j
public class isAnagram0242 {
    /**
     * 题目：见力扣 242
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] nums=new int[26];
        for(int i=0;i<s.length();i++){
            nums[s.charAt(i)-'a']+=1;
        }
        for(int i=0;i<t.length();i++){
            nums[t.charAt(i)-'a']-=1;
        }
        for(int i=0;i<26;i++){
            if(nums[i]!=0){
                return false;
            }
        }
        return true;
    }

}
