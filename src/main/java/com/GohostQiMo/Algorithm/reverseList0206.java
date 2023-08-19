package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: reverseList0206
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-06 09:09:27
 * @Description 力扣0296 翻转链表
 **/

@Slf4j
public class reverseList0206 {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 双指针写法
     *
     * @param head
     * @return
     */
    public ListNode reverseList_old(ListNode head) {
        //前节点类似于哨兵节点
        ListNode prenode = null;
        //当前操作的节点
        ListNode cur = head;
        //临时节点
        ListNode next = null;
        while (cur != null) {
            //保留当前节点的下一个节点
            next = cur.next;
            cur.next = prenode;
            prenode = cur;
            cur = next;
        }
        return prenode;
    }

    /**
     * 递归写法
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    /**
     * 递归函数
     *
     * @param prenode
     * @param cur
     * @return
     */
    public ListNode reverse(ListNode prenode, ListNode cur) {
        if (cur == null) {
            return prenode;  //这里的返回是：递归函数的终止条件
        }
        ListNode temp = cur.next;
        cur.next = prenode;
      /*  prenode=cur;
        cur=temp;*/
        //其实就是把prenode和cur的变换直接放到递归函数中去了
        return reverse(cur, temp);  //这里的返回是：返回整个递归函数的最终结果
    }
}
