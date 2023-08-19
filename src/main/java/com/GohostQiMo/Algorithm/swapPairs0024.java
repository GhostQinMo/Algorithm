package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: swapPairs0024
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-06-22 16:05:15
 * @Description 力扣0024两两交换链表中的节点
 **/
@Slf4j
public class swapPairs0024 {

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
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        //递归终止条件
        if (head == null || head.next == null) return head;
        ListNode fristNode = head;
        ListNode secondNode = head.next;
        //从后往前转换
         ListNode listNode = swapPairs(secondNode.next);
        fristNode.next = listNode;
        secondNode.next = fristNode;
        return secondNode;
    }

    /**
     * 还有一种解法使用非递归，O(n)级别
     */
    /**
     * 非递归
     *
     * @param head
     * @return
     */
    //总结：类似于这种链表反转的题多可以用截断+反转+拼接的思路来解决
    public ListNode swapPairs_prefer(ListNode head) {
        //哨兵节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        //当前节点
        ListNode cur = dummyNode;
        //遍历
        //每次操作多必须保证有两个
        while (cur.next != null && cur.next.next != null) {
            //截断
            ListNode temp1 = cur.next;
            ListNode temp2 = cur.next.next.next;
            //反转+拼接 (这里需要注意一下，一定要画图，指针太多了会乱)
            cur.next = cur.next.next;
            cur.next.next = temp1;
            cur.next.next.next = temp2;
            //重置
            cur = cur.next.next;
        }
        return dummyNode.next;
    }


    @Test
    public void test01() {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode listNode1 = swapPairs_prefer(listNode);
        //打印链表
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}
