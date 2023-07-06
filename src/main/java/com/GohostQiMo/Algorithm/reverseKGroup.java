package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: reverseKGroup
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-06 10:34:10
 * @Description 牛客101 BM3链表中的节点每k个一组翻转
 **/
@Slf4j
public class reverseKGroup {

    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**  递归写法，细节决定成败啊
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        //终止条件
        ListNode tail=head;
        //这里为什么是k,因为采用的循环不变量，左闭右开
        for (int i = 0; i <k ; i++) {
            //如果不满足k的长度则不需要翻转
            if(tail==null){
                return head;
            }
            //这里我也很奇怪，当链表的长度为k是，循环最后一次tail.next==null,但是为什么没有返回head呢，因为此次循环已经结束了，需要进入下一轮循环才会返回head
            tail=tail.next;
        }
        //翻转链表
        final ListNode resultNode = reverse(head, tail);
        //递归 (需要把每一段连接起来)
        head.next = reverseKGroup(tail, k);
        return  resultNode;
    }

    /**
     * 递归函数
     * @param head
     * @param tail
     * @return
     */
    public ListNode reverse(ListNode head,ListNode tail){
        ListNode next_node;
        ListNode pre_node=null;
        //这里的头节点就是当前节点了
        while (head!=tail){
            //保存下一个节点
            next_node=head.next;
            head.next=pre_node;
            pre_node=head;
            head=next_node;
        }
        return pre_node;
    }

}
