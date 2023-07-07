package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Black_ghost
 * @title: EntryNodeOfLoopBM7
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-07 10:19:29
 * @Description 牛客101 BM7 链表中环的入口节点
 **/
@Slf4j
public class EntryNodeOfLoopBM7 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 解题思路：使用set，key为节点的hash值，value为当前节点的位置，及入口节点的位置
     * //但是题目要求空间复杂度为O(1), 但是还是可以通过
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop_old(ListNode pHead) {
        Set container = new HashSet();
        //定义idx表示如果节点的位置
        int idx = 0;
        while (pHead != null) {
            idx++;
            if (container.contains(pHead)) {
                return pHead;
            } else {
                container.add(pHead);
                pHead=pHead.next;
            }
        }
        return null;
    }

    /**
     * 双指针法（快慢指针）
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead==null) return  null;
        ListNode fastnode=pHead;
        ListNode slownode=pHead;
        while (fastnode!=null && fastnode.next!=null){
            fastnode=fastnode.next.next;
            slownode=slownode.next;
            if (fastnode==slownode){
                break;
            }
        }
        //注意这里还需要添加添加一个条件啊
        if (fastnode==null || fastnode.next==null){
            return null;
        }else {
            fastnode=pHead;
            while (fastnode!=slownode){
                //相遇节点和头节点一起走
                fastnode=fastnode.next;
                slownode=slownode.next;
            }
        }
        return slownode;
    }
}