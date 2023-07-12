package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import java.util.Stack;
/**
 * @author Black_ghost
 * @title: StackBM43
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-12 20:54:19
 * @Description 牛客101  BM43 包含min函数的栈
 **/
@Slf4j
public class StackBM43 {
    private Stack<Integer>  comon=new Stack<>();
    private Stack<Integer> minstatck=new Stack<>();

    public void push(int node) {
        comon.push(node);
        if (!minstatck.isEmpty() && node>minstatck.peek()){
            minstatck.push(minstatck.peek());
        }else {
            minstatck.push(node);
        }
    }

    public void pop() {
        comon.pop();
        minstatck.pop();
    }

    public int top() {
        return comon.peek();
    }

    public int min() {
        return minstatck.peek();
    }
}
