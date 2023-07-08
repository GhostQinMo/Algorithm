package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.util.ArrayList;

/**
 * @author Black_ghost
 * @title: oddEvenListBM14
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-08 10:29:07
 * @Description 牛客101  BM14 链表的奇偶重排
 **/
@Slf4j
public class oddEvenListBM14 {
    @Test
    public void test01(){
        ListNode head=new ListNode(1);
        ListNode result=head;
        head.next=new ListNode(2);
        head=head.next;
        head.next=new ListNode(3);
        head=head.next;
        head.next=new ListNode(4);
        head=head.next;
        head.next=new ListNode(5);
        ListNode listNode = oddEvenList(result);
        while (listNode!=null){
            System.out.print(listNode.val);
            listNode=listNode.next;
        }
    }


     class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    //要求:空间复杂度O(n),时间复杂度q(n)
    public ListNode oddEvenList_old(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode temp=head;
        ListNode result=temp;
        //把所有的节点放到数组中
        ArrayList<ListNode>  cantiner=new ArrayList<>();
        while (head!=null){
            cantiner.add(head);
            head=head.next;
        }
        //这里为什么要从2开始，因为第一个节点已经加入了
        for (int i = 2; i < cantiner.size(); i+=2) {
            temp.next=cantiner.get(i);
            temp=temp.next;
        }
        for (int i = 1; i <cantiner.size() ; i+=2) {
            temp.next=cantiner.get(i);
            temp=temp.next;
        }
        //阻断原始的链表，不然会形成环啊
        temp.next=null;
        return result;
    }

    /**
     * 双指针解法（基偶指针）
     * @param head
     * @return
     */
    public ListNode oddEvenList (ListNode head) {
        if(head==null){
            return  head;
        }
        ListNode odd=head;
        ListNode even=head.next;
        //记录偶数链表的头节点
        ListNode evenhead=even;
        //当偶数为不为null且偶数的下一个基数不为null是继续
        while (even!=null && even.next!=null){
            //基数等于当前偶数的下一位(就是下一个基数)
            odd.next=even.next;
            //基数跳到下一个基数位
            odd=odd.next;
            //偶数等于当前基数位的下一位(就是下一个偶数) 不管是否为空多可以
            even.next=odd.next;
            //偶数跳到下一个偶数位
            even=even.next;
        }
        //连接奇偶链表
        odd.next=evenhead;
        //返回结果
        return head;
    }



}
