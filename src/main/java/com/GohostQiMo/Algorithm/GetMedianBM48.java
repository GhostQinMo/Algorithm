package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.*;

/**
 * @author Black_ghost
 * @title: GetMedianBM48
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-13 11:53:40
 * @Description 牛客101  BM48 数据流中的中位数
 **/
@Slf4j
public class GetMedianBM48 {

    // 解法一：时间O(N) 空间O(N)
    private ArrayList<Integer> val = new ArrayList<Integer>();
    public void Insert_1(Integer num) {
        if(val.isEmpty())
            //val中没有数据，直接加入
            val.add(num);
            //val中有数据，需要插入排序
        else{
            int i = 0;
            //遍历找到插入点
            for(; i < val.size(); i++){
                if(num <= val.get(i))
                    break;
            }
            //插入相应位置
            val.add(i, num);
        }
    }

    public Double GetMedian_1() {
        int n = val.size();
        //奇数个数字
        if(n % 2 == 1)
            //类型转换
            return (double)val.get(n / 2);
            //偶数个数字
        else{
            double a = val.get(n / 2);
            double b = val.get(n / 2 - 1);
            return (a + b) / 2;
        }
    }


    //推排序解题（大顶堆和小顶堆一起用）
    ArrayList<Integer> result=new ArrayList<>();
    //优先队列的使用
    //大
    PriorityQueue<Integer> max=new PriorityQueue<>(Comparator.reverseOrder());
    //小(默认就是小顶堆)
    PriorityQueue<Integer> min=new PriorityQueue<>();
    public void Insert(Integer num) {
        //放入大顶堆
        max.add(num);
        //找出最大值放入小顶堆
        min.add(max.poll());
        //如果小顶堆的数目大于大顶堆的数目，调平
        if (min.size()>max.size()){
            max.add(min.poll());
        }
    }
    //注意了：这里返回值是Double啊
    public Double GetMedian() {
        if (max.size()>min.size()){
            return (double)max.peek();
        }else{
            //先转为duoble  (细节决定成败)
            return ((double)(max.peek()+min.peek()))/2;
        }
    }

    @Test
    public void test01(){
        int[] nums ={5,2,3,4,1,6,7,0,8};
        for (int i = 0; i <nums.length ; i++) {
            Insert(nums[i]);
            System.out.print(GetMedian()+" ");
        }
    }
}
