package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: replaceSpace剑指offer05
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-17 15:22:58
 * @Description 剑指 Offer 05. 替换空格   一道双指针的字符串问题
 **/
@Slf4j
public class replaceSpace剑指offer05 {
    /**
     * 很多数组填充类的问题，都可以先预先给数组扩容带填充后的大小，然后在从后向前进行操作
     * 这样做的好处是：
     *          1. 不用申请新数组。
     *          2. 从后向前填充元素，避免了从前向后填充元素时，每次添加元素都要将添加元素之后的所有元素向后移动的问题。
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        //记录有多少个空格
        int spaces=0;
        //计算出新字符串的长度
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                ++spaces;   //++spaces比spaces++快一点，但是在这里效果是一样的
            }
        }
        char[] result=new char[s.length()+spaces*2];
        //从后往前，使用双指针进行填充
        //左右指针
        int left=s.length()-1;
        for (int right=result.length-1; right>=0; left--) {
            //如果当前字符不是空格
            if (s.charAt(left)!=' '){
                result[right]=s.charAt(left);
                right--;
//                left--;
            }else {
                //如果当前字符是空格的话
                result[right--]='0';
                result[right--]='2';
                result[right--]='%';
//                left--;
            }
        }
        return String.valueOf(result);
    }


    @Test
    public void test01(){

    }
}
