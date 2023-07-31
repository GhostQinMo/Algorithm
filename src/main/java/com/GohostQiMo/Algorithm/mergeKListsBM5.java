package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @author Black_ghost
 * @title: mergeKListsBM5
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-31 11:25:39
 * @Description 牛客101  BM5 合并k个已排序的链表
 **/
@Slf4j
public class mergeKListsBM5 {

    public class ListNode {
      int val;
      ListNode next = null;
      public ListNode(int val) {
        this.val = val;
      }
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param lists ListNode类ArrayList
     * @return ListNode类
     */
    //思路：归并排序，分而治之
    public ListNode mergeKLists (ArrayList<ListNode> lists) {
        return divide(lists,0,lists.size()-1);
    }

    /**
     * 分区 递归
     * @param list
     * @param left
     * @param right
     * @return
     */
    public ListNode divide(ArrayList<ListNode> list,int left,int right){
        if (left>right){
            return null;
        }
        //终止条件
        if (left==right){
            return list.get(right);
        }
        //递归
        int mid=left+(right-left)/2;
        return mergeTwoList(divide(list,left,mid),divide(list,mid+1,right));
    }

    /**
     * 按照元素合并两个链表
     * @param listNode1
     * @param listNode2
     * @return
     */
    public ListNode mergeTwoList(ListNode listNode1,ListNode listNode2){
        ListNode head=new ListNode(-1);
        ListNode cur=head;
        //合并 从小到大
        while (listNode1!=null && listNode2!=null){
            if (listNode1.val<=listNode2.val){
                cur.next=listNode1;
                listNode1=listNode1.next;
            }else {
                cur.next=listNode2;
                listNode2=listNode2.next;
            }
            cur=cur.next;
        }
        //合并剩余的
        if (listNode1!=null){
            cur.next=listNode1;
        }else {
            cur.next=listNode2;
        }
        return head.next;
    }

}
