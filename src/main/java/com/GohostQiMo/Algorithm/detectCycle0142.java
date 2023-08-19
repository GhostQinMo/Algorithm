package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: detectCycle0142
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-19 16:31:23
 * @Description 力扣 142. 环形链表 II
 **/
@Slf4j
public class detectCycle0142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 讲明：这个题我已经在牛客101做过了，这里只作为复习，对应牛客101中的EntryNodeOfLoopBM7（第7题）
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        //定义快慢指针找出快慢指针的相交节点
        ListNode fast=head;
        ListNode slow=head;
        //判断是否存在环（如果存在环快慢指针一定会相交）
        //不能用fast!=slow && fast!=null && fast.next!=null，因为fast和slow最开始就是从head开始的一开始就相等了
//        while (fast!=slow && fast!=null && fast.next!=null){
        while ( fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                break;
            }
        }
        //再次判断fast是否为null
        if(fast.next==null || fast.next.next==null){
            return null;
        }
        //找出入环的第一个节点
        fast=head;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }

    @Test
    public void test01(){
        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode3 = new ListNode(-4);
        listNode.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode2;
        ListNode listNode4 = detectCycle(listNode);
        System.out.println(listNode4.val);
    }
}
