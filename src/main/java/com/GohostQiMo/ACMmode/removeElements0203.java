package com.GohostQiMo.ACMmode;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * @author Black_ghost
 * @title: removeElements0203
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-19 13:49:58
 * @Description 力扣 203. 移除链表元素   ACM模式
 **/
@Slf4j
public class removeElements0203 {
    //洛谷提交，类名必须为public class Main{
    //   public static void main(String[] args) {
    //   }
    //   }


    //定义节点(这里使用内部类的形式)
    static class ListNode{
        //节点中的数据域
        int val;
        //节点中的指针域
        ListNode next;
        //对应的构造方法
        ListNode(){}

        ListNode(int val){
            this.val=val;
        }
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public static void main(String[] args){
        //定义输入(这里的head是一个虚拟节点)(如果不设置虚拟节点的话，删除头头节点需要另外考虑)
        ListNode head=new ListNode();
        ListNode temp=head;
        //尾插入法
        Scanner scanner=new Scanner(System.in);
        int val=scanner.nextInt();
        while (scanner.hasNextInt()){  //这里有点缺陷，最后结束需要输入不是字母即可
            temp.next=new ListNode(scanner.nextInt());
            temp=temp.next;
        }
        //删除指定值的节点
        //记录前一个节点
        ListNode preNode=head;
        //记录当前节点
        ListNode curNode=head.next;
        while (curNode!=null){
            //如果等于删除节点
            if (curNode.val==val){
                preNode.next=curNode.next;
                curNode=preNode.next;
            }else {
                //不等于
                preNode=curNode;
                curNode=curNode.next;
            }
        }
        //遍历Head
        System.out.print("[");
        while (head.next!=null){
            System.out.print(head.next.val);
            if (head.next.next!=null){
                System.out.print(",");
            }
            head=head.next;
        }
        System.out.print("]");
    }
}
