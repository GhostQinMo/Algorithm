package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * @author Black_ghost
 * @title: transBM83
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-18 20:41:35
 * @Description 牛客101  BM83 字符串变形
 **/
@Slf4j
public class transBM83 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @param n int整型
     * @return string字符串
     */
    public String trans (String s, int n) {
        //使用栈结构来作为容器，涉及到逆转的就要考虑stack
        Stack<String> container=new Stack<>();
        //大小写转换
        StringBuilder tempStr=new StringBuilder();
        for(int i=0;i<n;i++){
            if (s.charAt(i)>='A'  && s.charAt(i)<='Z'){
                tempStr.append((char)(s.charAt(i)-'A'+'a'));
            }else if(s.charAt(i)>='a'  && s.charAt(i)<='z'){
                tempStr.append((char)(s.charAt(i)-'a'+'A'));
            }else{
                tempStr.append(s.charAt(i));
            }
        }
        s=tempStr.toString();
        //分割转换的后的字符串，放入栈中
        for(int i=0;i<n;i++){
            int j=i;  //记录当前位置
            while(j<n && s.charAt(j)!=' '){
                j++;
            }
            container.push(s.substring(i,j));
            i=j;  //这里为什么只需要i=j就行，为什么不要i=j+1 ，因为for循环中的i++会自增一个
        }
        StringBuilder result;
        //判断最后一个字符是不是' '
        if(s.charAt(n-1)==' '){
            result=new StringBuilder(" ");
        }else{
            result=new StringBuilder();
        }
        //出栈
        while(!container.isEmpty()){
            result.append(container.pop());
            if(!container.isEmpty()){
                result.append(" ");
            }
        }
        return result.toString();
    }
}
