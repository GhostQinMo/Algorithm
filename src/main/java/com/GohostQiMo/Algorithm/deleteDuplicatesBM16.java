package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: deleteDuplicatesBM16
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-08 14:29:26
 * @Description 牛客101 BM16 删除有序链表中重复的元素-II
 **/
@Slf4j
public class deleteDuplicatesBM16 {
    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 使用指针来做需要一些细节，使用hash则不需要考虑更多
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    // 看题解做的
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return head;
        }
        //结果指针(dummynode) 可以不需要单独考虑头指针的情况
        ListNode result=new ListNode(-1);
        result.next=head;
        ListNode cur=result;
        //只有当当前节点后面两个数值不同时，cur才会移动到下一个（妙）
        while (cur.next!=null && cur.next.next!=null){
            //如果当前指针的后面两个节点的值相等的话需要跳过
            if (cur.next.val==cur.next.next.val){
                //记录当前节点后面节点中的值，用来判断
                int temp=cur.next.val;
                while (cur.next !=null && cur.next.val==temp) {
                    cur.next = cur.next.next;
                }
            }else {
                cur=cur.next;
            }
        }
        return result.next;

    }
}
