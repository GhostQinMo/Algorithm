package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: sortInListBM12
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-08 09:10:34
 * @Description 牛客101 BM12 单链表的排序
 **/
@Slf4j
public class sortInListBM12 {
    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 采用分而治之的思想
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList(ListNode head) {
        //确定终止条件(返回排序好的链表)
        if (head==null || head.next==null){
            return head;
        }
        //寻找链表的中间节点
        ListNode mid_pre=head;
        ListNode mid=head.next;
        ListNode mid_after=head.next.next;
        while (mid_after!=null && mid_after.next!=null){
            mid_pre=mid_pre.next;
            mid=mid.next;
            mid_after=mid_after.next.next;
        }
        //分而治之
        mid_pre.next=null;
         ListNode listNodeleft = sortInList(head);
         ListNode listNoderight = sortInList(mid);
         return mergeList(listNodeleft,listNoderight);
    }

    /**
     * 由于前面做了关于两个有序列链表的合并问题，这里没有写详细注释了
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeList(ListNode list1,ListNode list2){
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        //设置dummynode
        ListNode dummynode=new ListNode(-1);
        //记录头节点
        ListNode result=dummynode;
        while (list1 !=null  && list2 !=null){
            if (list1.val<=list2.val){
                dummynode.next=list1;
                list1=list1.next;
            }else {
                dummynode.next=list2;
                list2=list2.next;
            }
            //做全局移动
            dummynode=dummynode.next;
        }
        //判断是否存在遗留问题(只可能存在一个链表不为空的情况)
        if (list1 !=null){
            dummynode.next=list1;
        }else {
            dummynode.next=list2;
        }
        return result.next;
    }
}
