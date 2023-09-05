package com.GohostQiMo.Algorithm.杭州火树科技实习笔试;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: isPalindrome_demo
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-09-03 15:15:55
 * @Description 判断是否是回文链表
 **/
@Slf4j
public class isPalindrome_demo {

    public class ListNode {
        int val;
        ListNode next = null;
    }


    /**
     * 判断是否为回文链表
     *
     * @param head ListNode类 链表头
     * @return bool布尔型
     */
    public boolean isPalindrome(ListNode head) {
        //处理特殊情况
        if (head==null || head.next == null){
            return true;
        }
        StringBuilder  listString=new StringBuilder();
        while (head!=null){
            listString.append(head.val);
            head=head.next;
        }
        String temp_Str=listString.toString();
        int length = listString.length();
        int right=length-1;
        int left=0;
        while (left<right){
            if(temp_Str.charAt(left)!=temp_Str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}
