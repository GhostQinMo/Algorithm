package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: deleteDuplicatesBM15
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-08 11:23:22
 * @Description 牛客101 BM15 删除有序链表中重复的元素-I
 **/
@Slf4j
public class deleteDuplicatesBM15 {

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 解题思路：双指针（同向的前后指针）
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    //进阶:空间复杂度0(1),时间复杂度O(n)
    public ListNode deleteDuplicates_old(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode cur=head.next;
        ListNode pre=head;
        while (cur!=null ){
            while ( cur!=null && cur.val==pre.val){
                cur=cur.next;
            }
            //指向值不同的节点
            pre.next=cur;
            //移动当前指针(注意条件题给的是一个有序的列表)
            //这里可能存在空指针
            if (cur==null){
                break;
            }
            cur=cur.next;
            pre=pre.next;
        }
        return head;
    }


    /**
     * 参考题解写的
     * @param head
     * @return
     */
    //简洁 优雅
    public ListNode deleteDuplicates (ListNode head) {
        if(head==null ){
            return head;
        }
        //只是用了一个指针就解决了
        ListNode cur=head;
        while (cur !=null && cur.next!=null){
            if (cur.val==cur.next.val){
                cur.next=cur.next.next;
            }else {
                cur=cur.next;
            }
        }
        return head;
    }
}
