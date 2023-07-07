package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: addInListBM11
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-07 14:48:04
 * @Description 牛客101 BM11 链表相加(二)
 **/
@Slf4j
public class addInListBM11 {

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        if (head1==null || head1.next==null){
            return head2;
        }
        if (head2==null|| head1.next==null){
            return head1;
        }
        // write code here
        ListNode l1=reverseList(head1);
        ListNode l2=reverseList(head2);
        //记录进位
        int carry=0;
        //结果节点
        ListNode result=new ListNode(-1);
        ListNode head=result;
        //只要有节点不为null或者carry不为0就一直循环
        while (l1!=null || l2 !=null || carry !=0){
            int val1=(l1==null) ?0 : l1.val;
            int val2=(l2==null) ? 0: l2.val;
            int temp=val1+val2+carry;
            //进位
            carry=temp/10;
            //当前位的值
            temp%=10;
            head.next=new ListNode(temp);
            //下移
            head=head.next;
            l1=(l1==null)? null : l1.next;
            l2=(l2==null) ? null :l2.next;
        }
        //翻转结果
        return reverseList(result.next);
    }
    public ListNode reverseList(ListNode head){
        ListNode cur=head;
        ListNode pre=null;
        ListNode cur_next=null;
        while (cur!=null){
            //保存下一个cur
            cur_next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=cur_next;
        }
        return pre;
    }
}
