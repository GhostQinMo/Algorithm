package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Black_ghost
 * @title: hasCycleBM6
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-06 11:45:21
 * @Description 牛客BM6 判断链表中是否有环
 **/
@Slf4j
public class hasCycleBM6 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 快慢指针法
     * @param head
     * @return
     */
    public boolean hasCycle_old(ListNode head) {
        if (head==null){
            return false;
        }
        ListNode fastNode=head;
        ListNode slowNode=head;
        //这里的终止条件很重要，不能搞错顺序，请仔细考虑
        while (fastNode!=null && fastNode.next != null){
            fastNode=fastNode.next.next;
            slowNode=slowNode.next;
            if (fastNode==slowNode){
                return  true;
            }
        }
        return false;
    }

    /**
     * hash表法   hash法更加简单，但是需要耗费空间
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set save=new HashSet<>();
        while (head!=null){
            if (save.contains(head)){
                return true;
            }else {
                save.add(head);
                head=head.next;
            }
        }
        return false;
    }
}
