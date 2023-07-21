package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.w3c.dom.Node;

import java.util.HashMap;

/**
 * @author Black_ghost
 * @title: LRUBM100
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-21 10:59:01
 * @Description 牛客101  BM100 设计LRU缓存结构
 **/
@Slf4j
public class LRUBM100 {

//    1. Solution(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
//    2. get(key)：如果关键字 key 存在于缓存中，则返回key对应的value值，否则返回 -1 。
//    3. set(key, value)：将记录(key, value)插入该结构，如果关键字 key 已经存在，则变更其数据值 value，如果不存在，则向缓存中插入该组 key-value ，如果key-value的数量超过capacity，弹出最久未使用的key-value

    //定义属性
    //定义节点
    class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }
    //容量
    private Integer capacity = 0;
    private HashMap<Integer, Node> container;
    //头尾指针全是dummynode
    private Node head;
    private  Node tail;
    public  void solution (int capacity) {
        this.capacity = capacity;
        container = new HashMap<>();
        //初始化头尾指针(题目规定了容器中数值的大小>=0)
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    //获取
    public int get(int key) {
        //如果有返回对应的值，跟新缓存
        if(container.containsKey(key)){
            //更新缓存
            removetoHead(key);
            return  container.get(key).value;
        }
        //如果没有，返回-1
        return -1;

    }

    /**
     * 插入一个数据
     * @param key
     * @param value
     */
    public void set(int key, int value) {

        //如果插入的数据不存在
        Node temp = new Node(key, value);
        if (!container.containsKey(key)) {
            //1.检查是否容量不足，如果足够，直接头插法
            if (container.size()< capacity) {
                //放入map
                container.put(key, temp);
                //移动到头
                removetoHead(key);
            } else {
                //2.容量不足，删除尾部，头插法
                removeLast();
                container.put(key, temp);
                removetoHead(key);
            }
        } else {
            //如果插入的数据存在，则更新，在更新缓存
            //这里需要拿到原来的有前后索引的节点
            temp=container.get(key);
            temp.value=value;
            container.put(key,temp);
            removetoHead(key);
        }
    }
    /**
     * 移动节点取头
     * @param key
     */
    public void removetoHead(int key) {
        Node temp = container.get(key);
        //判断是插入的节点还是移动原本的节点
        if (temp.next != null) {
            //是移动原本的一个节点 (截断)
            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;
        }
        //是插入一个节点 则直接插入
        head.next.pre = temp;
        temp.next = head.next;
        head.next = temp;
        temp.pre = head;
    }
    /**
     * 移除链表的最后一个元素，也需要在容器中删除
     */
    public void removeLast() {
        //这里需要删除两个地方（容器中和链表中）
        container.remove(tail.pre.key);
        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;
        //容量减一 // 这里容量不需要减一了，因为删除尾部有一个元素添加进来,但是需要在容器中删除整个末尾的节点

    }

    @Test
    public void test01(){
        solution(2);
         set(1,1);
         set(2,2);
         int i = get(1);
        System.out.print(i+"\t");
         set(3,3);
         int i1 =  get(2);
        System.out.print(i1+"\t");
         set(4,4);
         int i2 =  get(1);
        System.out.print(i2+"\t");
         int i3 =  get(3);
        System.out.print(i3+"\t");
         int i4 =  get(4);
        System.out.print(i4+"\t");
    }
}
