package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: removeElements0203
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-19 14:50:38
 * @Description 力扣 203. 移除链表元素
 **/
@Slf4j
public class removeElements0203 {
    //定义节点(这里使用内部类的形式)
    public class ListNode {
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
     * 删除链表中等于给定值 val 的所有节点。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        //定义一个虚拟节点,并将其指向头节点,不然删除头节点需要额外考虑
        ListNode tempHead = new ListNode();
        tempHead.next = head;
        //记录当前节点的前一个节点
        ListNode prenode = tempHead;
        //记录当前节点
        ListNode curNode = tempHead.next;
        while (curNode != null) {
            //如果当前节点的值等于val，则通过前一个节点删除当前节点，重置当前节点
            if (curNode.val == val) {
                prenode.next = curNode.next;
                curNode = prenode.next;  //这里可以和下面的else中的curNode=curNode.next;合并，是一样的
            } else {
                //如果当前节点的值不等于val，则向后移动前一个节点和当前节点
                prenode = curNode;
                curNode = curNode.next;
            }
//            curNode=curNode.next; 合并
        }
        return tempHead.next;
    }
}
