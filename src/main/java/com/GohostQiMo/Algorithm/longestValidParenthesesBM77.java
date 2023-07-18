package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * @author Black_ghost
 * @title: longestValidParenthesesBM77
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-18 09:18:32
 * @Description 牛客101  BM77 最长的括号子串
 **/
@Slf4j
public class longestValidParenthesesBM77 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return int整型
     */
    //一定要确定stack中放的元素有什么用？ 这里存放的是字符的索引
    private Stack<Integer> container=new Stack<>();
    public int longestValidParentheses (String s) {
        int result=0;
        if(s.length()==0){
            return result;
        }
        //注意了这里的nextStart初始值必须为-1，问怎么知道为什么是-1，因为它表示下一个合法字符的初始位置，0位置上的是合法字符，0前面的一个位置就是初始位置，即-1
        int nextStart=-1; //用于记录不合法的情况的下一个起始位置
        for(int i=0;i<s.length();i++){
            //如果是左括号，直接放入它对应位置的索引
            if(s.charAt(i)=='('){
                container.push(i);
            }else {
                //如果是右括号
                //判断当前元素是否为空,为空则不合法
                if(container.isEmpty()){
                    nextStart=i;
                }else{
                    container.pop();
                    //判断弹出以后是否为空
                    if(!container.isEmpty()){
                        result=Math.max(result,i-container.peek());
                    }else{
                        result=Math.max(result,i-nextStart);
                    }
                }
            }
        }
        return result;
    }

    //上面是使用栈来做的还可以使用动态规划
    //dp[i]表示以i索引结尾的字符为止的子串中的最长合法括号长度

}
