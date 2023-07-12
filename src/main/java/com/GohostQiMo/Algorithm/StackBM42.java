package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * @author Black_ghost
 * @title: StackBM42
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-12 20:40:29
 * @Description 牛客101  BM42 用两个栈实现队列
 **/
@Slf4j
public class StackBM42 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }
    //虽然是简单题：没有看任何题解写的
    public int pop() {
        //如果出栈不为空，直接出栈
        if(stack2.isEmpty()){
            if (stack1.isEmpty()){
                throw  new NullPointerException();
            }
            //把stack1中的元素放入stack2中
          while (!stack1.isEmpty()){
              stack2.push(stack1.pop());
          }
        }
       return  stack2.pop();
    }
}
