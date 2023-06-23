package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: swapPairs
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-22 16:05:15
 * @Description 力扣0024两两交换链表中的节点
 **/
@Slf4j
public class swapPairs {
    public static void main(String[] args) {

    }

    class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode fristNode=head;
        ListNode secondNode=head.next;
        final ListNode listNode = swapPairs(secondNode.next);
        fristNode.next=listNode;
        secondNode.next=head;
        return secondNode;
    }

    /**
     * 还有一种解法使用非递归，O(n)级别
     */

}
