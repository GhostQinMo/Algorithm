package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: FindKthToTailBM8
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-07 10:55:12
 * @Description 牛客101 BM8 链表中倒数最后k个结点
 **/
@Slf4j
public class FindKthToTailBM8 {
    @Test
    public void test01(){
        int[] nums={1,2,3,4,5};
        ListNode head=new ListNode(1);
        ListNode temp=head;
        for (int i = 1; i <nums.length ; i++) {
            head.next=new ListNode(nums[i]);
            head=head.next;
        }
        final ListNode listNode = FindKthToTail(temp, 2);

    }

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }


    /**
     *  做过一个类似的题，使用双指针
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */

    //还是不熟悉，虽然知道思路，但是细节方面没有完全注意到
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        ListNode fastnode=pHead;
        ListNode slownode=pHead;
        for (int i = 0; i < k ; i++) {
            if (fastnode==null){
                slownode=null;
                break;
            }else {
                fastnode=fastnode.next;
            }
        }
        while (fastnode!=null){
            slownode=slownode.next;
            fastnode=fastnode.next;
        }
        return slownode;
    }
}
