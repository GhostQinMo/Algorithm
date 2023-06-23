package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Black_ghost
 * @title: isValid0020
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-16 19:04:43
 * @Description 有效括号字符串判断  力扣0020
 **/
@Slf4j
public class isValid0020 {
    public static void main(String[] args){
        isValid0020 isValid0020=new isValid0020();
        final boolean valid = isValid0020.isValid("([)]");
        System.out.println("valid = " + valid);
    }

    public boolean isValid(String s){
        if (s.length()%2!=0) {
            return false;
        }
        //这里我开始使用的是list来当栈，不好，在比较栈最上面的时候需要自己维护一个索引
       Deque<Character> dqueue=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
             char c = s.charAt(i);
            if (c=='('){
                dqueue.push(')');
            }else if (c=='{'){
                dqueue.push('}');
            }else  if (c=='['){
                dqueue.push(']');
            }else if (dqueue.isEmpty()||dqueue.peek()!=c){
                return  false;
            }else {
                dqueue.poll();
            }
        }
        return dqueue.isEmpty();
    }
}

