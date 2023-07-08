package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Black_ghost
 * @title: isPailBM13
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-08 09:50:27
 * @Description 牛客101 BM13 判断一个链表是否为回文结构
 **/
@Slf4j
public class isPailBM13 {
    @Test
    public void test01(){
        ListNode head=new ListNode(2);
        ListNode result=head;
        head.next=new ListNode(1);
        /*head=head.next;
        head.next=new ListNode(2);
        head=head.next;
        head.next=new ListNode(1);*/
     /*   head=head.next;
        head.next=new ListNode(1);*/
        final boolean pail = isPail(result);
        System.out.println("pail = " + pail);
    }
    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 使用双指针解题
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail(ListNode head) {
        if (head==null || head.next==null){
            return true;
        }
        //将链表中的元素取出
        ArrayList<Integer> nums=new ArrayList<>();
        while (head!=null){
            nums.add(head.val);
            head=head.next;
        }
        //使用左右指针开始遍历
        int left=0;
        int right=nums.size()-1;
        while (left<=right){
            if (!nums.get(left).equals(nums.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

