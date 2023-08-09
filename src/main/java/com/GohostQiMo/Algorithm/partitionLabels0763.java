package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Black_ghost
 * @title: partitionLabels0763
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-09 22:25:11
 * @Description 力扣 763. 划分字母区间
 **/
@Slf4j
public class partitionLabels0763 {
    /**
     * @param s
     * @return
     * @title
     */
    //说明：这里力扣上题目并没有说明给的字符串就是只有小写字母组成的，所以这里应该用hash表而不是数组
    //思路：在遍历的过程中相当于是要找每一个字母的边界，如果找到之前遍历过的所有字母的最远边界，说明这个边界就是分割点了。
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        final int length = s.length();
        //遍历寻找每一个字符的最右边界索引为
        for (int i = 0; i < length; i++) {
            //更新最右索引
            map.put(s.charAt(i), i);
        }
        int max_right=0;
        int left=0;
        //遍历，如果出现最远边界等于当前索引，说明这个边界就是分割点了
        for (int i = 0; i < length; i++) {
            max_right=Math.max(max_right,map.get(s.charAt(i)));
            if (max_right==i){
                result.add(i-left+1);
                left=i+1;
            }
        }
        return result;
    }

    @Test
    public void test01(){
        String s="ababcbacadefegdehijhklij";
        List<Integer> list = partitionLabels(s);
        log.info("list:{}",list);
    }
}
