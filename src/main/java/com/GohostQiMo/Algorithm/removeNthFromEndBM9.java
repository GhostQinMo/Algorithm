package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: removeNthFromEndBM9
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-07 11:22:46
 * @Description 牛客101 BM9 删除链表的倒数第n个节点
 **/
@Slf4j
public class removeNthFromEndBM9 {

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * //写过一次了，双指针经典例题
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    //题目保证了N一定是有效的
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        //需要注意的地方，这种链表设置一个虚拟头节点可以很好的处理头节点的删除
        ListNode dummynode=new ListNode(-1);
        dummynode.next=head;
        ListNode fastnode=dummynode;
        ListNode slownode=dummynode;
        for (int i = 0; i < n; i++) {
            fastnode=fastnode.next;
        }
        while (fastnode.next !=null){
            fastnode=fastnode.next;
            slownode=slownode.next;
        }
        slownode.next=slownode.next.next;
        return dummynode.next;
    }


}
