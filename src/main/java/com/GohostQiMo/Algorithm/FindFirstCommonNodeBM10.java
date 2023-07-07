package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Black_ghost
 * @title: FindFirstCommonNodeBM10
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-07 14:06:09
 * @Description 牛客101 BM10 两个链表的第一个公共结点
 **/
@Slf4j
public class FindFirstCommonNodeBM10 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法一：hash法，但是题目要求空间复杂度为O(1),时间复杂度为O（n）;  虽然可以通过测试，但是不好
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode_old(ListNode pHead1, ListNode pHead2) {
        Set container=new HashSet();
        while (pHead1!=null){
            container.add(pHead1);
            pHead1=pHead1.next;
        }
        while (!container.contains(pHead2) && pHead2!=null){
            pHead2=pHead2.next;
        }
        return pHead2;
    }

    /**
     *  双指针法 空间复杂度为O(m+n), 时间复杂度为O(1)
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
//        有公共节点的时候，N1和N2必会相遇，因为长度一样嘛，速度也一定，必会走到相同的地方的，所以当两者相等的时候，则会第一个公共的节点
//        无公共节点的时候，此时N1和N2则都会走到终点，那么他们此时都是null，所以也算是相等了。
        ListNode l1=pHead1;
        ListNode l2=pHead2;
        while (l1!=l2){
            l1= (l1==null) ?pHead2 :l1.next;
            l2= (l2==null) ? pHead1 :l2.next;
        }
        return l1;
    }
}
