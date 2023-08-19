package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: getIntersectionNode链表相交
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-19 15:49:55
 * @Description 力扣 面试题 02.07. 链表相交
 **/
@Slf4j
public class getIntersectionNode链表相交 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }

    /**
     * 找出两链表相交的节点，如果两链表没有相交返回null
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //判断边界
        if (headA == null || headB == null) return null;
        //直接使用双指针解题，两个指针分别经过链表A和链表B，如果两个指针指向的元素相等则这个节点就是相交节点
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            //如果A链表与B链表没有相交，那么A和B最后都会指向null，因为他们两个走了相同的节点长度
            A = (A == null) ? headB : A.next;
            B = (B == null) ? headA : B.next;
        }
        return A;
    }

    @Test
    public void test01() {
        ListNode A = new ListNode(2, new ListNode(6, new ListNode(4)));
        ListNode B = new ListNode(1, new ListNode(5));
        ListNode intersectionNode = getIntersectionNode(A, B);
        //遍历链表
        while (intersectionNode != null) {
            System.out.println(intersectionNode.val);
            intersectionNode = intersectionNode.next;
        }
    }
}
