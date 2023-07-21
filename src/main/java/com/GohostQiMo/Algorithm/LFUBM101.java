package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Black_ghost
 * @title: LFUBM101
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-21 15:56:21
 * @Description 牛客101  BM101 设计LFU缓存结构
 **/
@Slf4j
public class LFUBM101 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * lfu design
     *
     * @param operators int整型二维数组 ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    //定义节点
    class Node {
        int freq;// 节点的使用频率
        int key;
        int value;

        public Node(int freq, int key, int value) {
            this.freq = freq;
            this.key = key;
            this.value = value;
        }
    }

    //存放(key ,node) 的map
    private HashMap<Integer, Node> container = new HashMap<Integer, Node>();
    //存放缓存的剩余容量
    private int cacheCapacity;
    //存放(node_fre,List<Node>)的map   链表必须为双向链表
    private HashMap<Integer, LinkedList<Node>>  fremq=new HashMap<>();
    //使用一个全局变量记录当前使用最少的频率
    private int lfu =0;
    //使用双hash+双向链表   （这里的参数需要看题目才能懂，牛客101 的101 LFU缓存的实现）
    public int[] LFU(int[][] operators, int k) {
        //初始化操作
        cacheCapacity=k;
        //分解出操作数                   (过滤掉get操作，确定返回结果的数目)
         int get_count =(int) Arrays.stream(operators).filter((item) -> item[0] == 2).count();
         //返回结果
        int[] result=new int[get_count];
        //数组索引
        int j=0;
        //遍历数组
        for(int[] item:operators){
            //第一个值等于1是set操作（题目规定的）
            if (item[0]==1){
                set(item[1],item[2]);
            }else {
                //get操作
                result[j++]=get(item[1]);
            }
        }
        return result;
    }

    //get方法
    public int get(int key) {
        int result = -1;
        //如果map中有直接更新频率
        if (container.containsKey(key)) {
            //获取元素
            Node node = container.get(key);
            result = node.value;
            //更新缓存频率
            update(node, key,result);
        }
        //统一返回
        return result;
    }

    //set方法
    public void set(int key, int value) {
        //分为两种：1.已经存在key  （直接更新缓存频率）
                //2.不存在key
        if(container.containsKey(key)){
            update(container.get(key),key,value);
        }else {
            //2.不存在key又分为两种
            //2.1内存容量已经满了 （更具LFU删除一个，在插入一个）
            if (cacheCapacity==0){
                //从fremq中删除指定频率链表中的最后一个，将这个节点方加入container和fremq (这些操作统一放到后面，这里是优化之后的代码)
                //mq中先删除
                container.remove(fremq.get(lfu).getLast().key);
                fremq.remove(fremq.get(lfu).removeLast());
                //还需要判断当前lfu对应的链表是否为空了，如果为空则需要删除
                if (fremq.get(lfu).isEmpty()){
                    fremq.remove(lfu);
                }
            }else {
                //这里也是优化之后的代码（开始没想到正常）
                cacheCapacity--;
            }
            //下面统一做添加元素
            //重置最小频率
            lfu=1;
            //2.2内存容量没满 （直接插入，更新缓存）
            Node temp=new Node(1,key,value);
            container.put(key,temp); //如果节点map
            //入fremq
            //判断当前频率是否存在
            if(fremq.get(1)==null){
                //创建当前频率对应的链表放入fremq中
                fremq.put(1,new LinkedList<>());
            }
            //存在（加入当前链表的最前面）
            fremq.get(1).addFirst(temp);
        }
    }


    //缓存更新策略
    /**
     * LFU更新策略（最近使用频率最少的节点，频率相同的时候，删除最早访问的元素）
     *
     * @param node
     * @param key
     * @param value
     */
    public void update(Node node, int key, int value) {
        //为什么回到这里？  因为缓存中已经存在了，只需要更新缓存就行了
        //在container中更新和在fremq中更新
        //1.container
        //新节点
        Node temp   =new Node(node.freq+1,key,value);
        container.put(key,temp);
        //2.fremq
        //(跟新频率移动到头节点)
         //从旧链表中删除，如果链表为空则需要删除链表
        fremq.get(node.freq).remove(node);
        //这里需要判断是否为空而不是==null
        if (fremq.get(node.freq).isEmpty()){
            fremq.remove(node.freq);
            //注意这里需要更新最小频率
            if (lfu==node.freq){
                //往上走一个频率
                lfu++;
            }
        }
        //在新的链表中添加（先要判断链表是否存在）
        //不存在创建
        fremq.computeIfAbsent(node.freq + 1, k -> new LinkedList<>());
        fremq.get(node.freq+1).addFirst(temp);
        //更新最小使用频率
    }
}
