package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Black_ghost
 * @title: MyQueue0232
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-09-22 09:15:06
 * @Description 力扣 ：用栈实现队列 0232
 **/
@Slf4j
public class MyQueue0232 {

    class MyQueue {
        /**
         * 入栈
         */
        Stack<Integer> in;

        /**
         * 出栈
         */
        Stack<Integer> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        /**
         * 插入一个元素，直接插入入栈
         *
         * @param x
         */
        public void push(int x) {
            in.push(x);
        }

        /**
         * 出栈
         *
         * @return
         */
        public int pop() {
            peek();
            return out.pop();
        }

        /**
         * 查看栈顶元素
         *
         * @return
         */
        public int peek() {
            if (out.isEmpty()) {
                if (in.isEmpty()) {
                    throw new NullPointerException("队列为空");
                } else {
                    while (!in.isEmpty()) {
                        out.push(in.pop());
                    }
                }
            }
            return out.peek();
        }

        /**
         * 判断队列是否为null
         *
         * @return
         */
        public boolean empty() {
            return (out.isEmpty() && in.isEmpty());
        }
    }


    /**
     * 测试 Deque数据结构
     */
    @Test
    public void test_Deque() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);
//        deque.offer(5);
//        deque.offerFirst(6);

        //ArrayDeque中的pop()、poll()、pollFirst()方法内部逻辑是一样的。 全部调用的是pollFirst()方法
//        System.out.println("deque.pop()"+deque.pop());
//        System.out.println("deque.pop() = " + deque.poll());
//        System.out.println("deque.pollFirst() = " + deque.pollFirst());


//        System.out.println("deque.pollLast() = " + deque.pollLast());
    }


    /**
     * 测试自定义队列
     */
    @Test
    public void test_MyQueue() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println("myQueue.peek() = " + myQueue.peek());
        System.out.println("myQueue.pop() = " + myQueue.pop());
        myQueue.push(9);
        myQueue.push(10);
    }
}
