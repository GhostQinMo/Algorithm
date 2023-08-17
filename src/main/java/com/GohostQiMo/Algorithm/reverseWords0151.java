package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Black_ghost
 * @title: reverseWords0151
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-17 15:59:16
 * @Description 力扣   151. 反转字符串中的单词
 **/
@Slf4j
public class reverseWords0151 {
    /**
     * 解法一：直接使用库函数，但是可能面试官需要你不要使用库函数
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        //去除前后空格
         String trim = s.trim();
        //使用正则表达式分割（一个或多个空格作为分隔符）
         String[] split = trim.split("\\s+");
         //转成链表形式
         List<String> list = Arrays.asList(split);
         //反转链表
        Collections.reverse(list);
        //合并链表
         String join = String.join(" ", list);
         return join;
    }

    @Test
    public void test01(){
        String str="the sky is blue";
        final String s = reverseWords(str);
        System.out.println(s);
    }


    /**
     *  直接使用库函数达不到：不要使用辅助空间，空间复杂度要求为O(1)要求，下面的写法没有达到空间复杂度要求O(1)
     * @param s
     * @return
     */
    //最好用第一种写，下面的这种写法 创建新字符数组填充。时间复杂度O(n)，空间复杂度O(n)
    //但是这样的写法比上面使用库函数的写法快很多，
    public String reverseWords_prefer(String s) {
        //源字符数组
        char[] initialArr = s.toCharArray();
        //新字符数组
        char[] newArr = new char[initialArr.length+1];//下面循环添加"单词 "，最终末尾的空格不会返回
        int newArrPos = 0;
        //i来进行整体对源字符数组从后往前遍历
        int i = initialArr.length-1;
        while(i>=0){
            while(i>=0 && initialArr[i] == ' '){i--;}  //跳过空格
            //此时i位置是边界或!=空格，先记录当前索引，之后的while用来确定单词的首字母的位置
            int right = i;
            while(i>=0 && initialArr[i] != ' '){i--;}
            //指定区间单词取出(由于i为首字母的前一位，所以这里+1,)，取出的每组末尾都带有一个空格
            for (int j = i+1; j <= right; j++) {
                newArr[newArrPos++] = initialArr[j];
                if(j == right){
                    newArr[newArrPos++] = ' ';//空格
                }
            }
        }
        //若是原始字符串没有单词，直接返回空字符串；若是有单词，返回0-末尾空格索引前范围的字符数组(转成String返回)
        if(newArrPos == 0){
            return "";
        }else{
            return new String(newArr,0,newArrPos-1);
        }
    }
}
