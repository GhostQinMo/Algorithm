package com.GohostQiMo.ACMmode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Scanner;
/**
 * @author Black_ghost
 * @title: min_maxSlidingWindow
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-24 21:26:15
 * @Description 洛谷P1886滑动窗口  求每次滑动窗口中的最大最小值   ACM模式
 **/
@Slf4j
public class min_maxSlidingWindow {
    //时间超出限制或者内存超出限制呀  只能过60%
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int arr_len;
        //数组的长度
        arr_len=scanner.nextInt();
        //滑动窗口的大小
        int sliding_k=scanner.nextInt();
        int[] arr=new int[arr_len];
        //结果数组的长度
        int result_len=arr_len-sliding_k+1;
        //最小值的结果
        int[] result_min=new int[result_len];
        //最大值结果
        int[] result_max=new int[result_len];

        ArrayDeque<Integer> maxdeque=new ArrayDeque();
        ArrayDeque<Integer> mindeque=new ArrayDeque();
        int index=0;
        for(int i=0;i<arr_len;i++){
            //部分超时，数据的输入放到这里看看
            arr[i]=scanner.nextInt();
            //判断该元素队列头部的元素是否在窗口中,没在的直接移除
            while(!maxdeque.isEmpty() && maxdeque.peek()<= i-sliding_k){
                maxdeque.pop();
            }
            //判断当前的队列是否是递增的
            while(!maxdeque.isEmpty() && arr[maxdeque.peekLast()] <=arr[i]){
                //移除小于等于的
                maxdeque.pollLast();
            }
            //判断该元素队列头部的元素是否在窗口中,没在的直接移除
            while(!mindeque.isEmpty() && mindeque.peek()<= i-sliding_k){
                mindeque.pop();
            }
            //判断当前的队列是否是递增的
            while(!mindeque.isEmpty() && arr[mindeque.peekLast()]>arr[i]){
                //移除小于等于的
                mindeque.pollLast();
            }
            //最后放入当前元素  从队列尾部放入
            mindeque.offer(i);
            //最后放入当前元素
            maxdeque.offer(i);
            //去结果
            if(i>=sliding_k-1){
                result_max[index]=arr[maxdeque.peek()];
                result_min[index]=arr[mindeque.peek()];
                index++;
            }
        }
        //输出最终结果
        for (int i = 0; i < result_len; i++) {
            if (i==result_len-1){
                System.out.print(result_min[i]+"\n");
            }else {
                System.out.print(result_min[i]+" ");
            }
        }
        for (int i = 0; i < result_len; i++) {
            if (i==result_len-1){
                System.out.print(result_max[i]+"\n");
            }else {
                System.out.print(result_max[i]+" ");
            }
        }
    }
}
