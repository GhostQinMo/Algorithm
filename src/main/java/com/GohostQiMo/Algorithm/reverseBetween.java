package com.GohostQiMo.Algorithm;

/**
 * @author Black_ghost
 * @title: reverseBetween
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-06 09:31:21
 * @Description 牛客101 BM2 链表内指定区间反转
 **/
public class reverseBetween {
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
     *
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        //设置虚拟节点
        ListNode dummynode=new ListNode(-1);
        dummynode.next=head;
        //找到需要翻转区间的最开始的前一个节点
        ListNode prenode=dummynode;
        for (int i = 0; i < m-1; i++) {
                prenode=prenode.next;
        }

        //当前节点（这里初始化为第一个要反转的节点）
        ListNode cur=prenode.next;
        //创建一个临时节点
        //这里的逻辑需要结合一个图来看，看是看不明白的
        ListNode cur_next=null;
        for (int i = 0; i <n-m ; i++) {
            cur_next=cur.next;
            cur.next=cur_next.next;
            cur_next.next=prenode.next;
            prenode.next=cur_next;
        }
        return dummynode.next;
    }

}
