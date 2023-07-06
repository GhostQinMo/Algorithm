package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: MergeBM4
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-06 11:17:28
 * @Description 牛客101  BM4 合并两个排序的链表
 **/
@Slf4j
public class MergeBM4 {

    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     *  使用双指针解题
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead1 ListNode类
     * @param pHead2 ListNode类
     * @return ListNode类
     */
    public ListNode Merge(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null){
            return pHead2;
        }
        if (pHead2==null){
            return pHead1;
        }
        //添加一个虚节点
        ListNode result=new ListNode(0);
        ListNode head=result;
        //终止条件为两个链表多不为空的情况
        while (pHead1!=null && pHead2!=null){
            //这里的head=head.next 统一放到了最后
            if (pHead1.val<=pHead2.val){
                head.next=pHead1;
                pHead1=pHead1.next;
            }else {
                head.next=pHead2;
                pHead2=pHead2.next;
            }
            //统一向后移动
            head=head.next;
        }
        //判断是否还有遗留的元素
        if(pHead1!=null){
            head.next=pHead1;
        }else {
            head.next=pHead2;
        }
        return result.next;
    }
}
