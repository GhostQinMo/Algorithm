package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;

/**
 * @author Black_ghost
 * @title: findKthBM47
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-13 09:52:01
 * @Description 牛客101  BM47 寻找第K大
 **/
@Slf4j
public class findKthBM47 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param a int整型一维数组
     * @param n int整型
     * @param K int整型
     * @return int整型
     */
    //前面写过了大顶堆，这里直接用小顶堆了
    //题目提示：返回第 k 大的数(包括重复的元素，不用去重)，保证答案存在
    //要求:时间复杂度O(nlogn),空间复杂度0(1)  这里没有满足
    public int findKth_old (int[] a, int n, int K) {
        //使用优先队列（正常排序就是小顶堆）
        PriorityQueue<Integer> continer=new PriorityQueue<>();
        //初始化
        for (int i = 0; i < K; i++) {
            continer.add(a[i]);
        }
        for (int i =K ; i <n ; i++) {
            if(continer.peek()<a[i]){
                continer.poll();
                continer.add(a[i]);
            }
        }
        return continer.peek();
    }



    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param a int整型一维数组
     * @param n int整型
     * @param K int整型
     * @return int整型
     */
    //题解：算法思想：使用快速排序对数组进行升序排列(每次都选用待排部分的第一个元素作为枢轴值)，
    // 在每一趟快排结束后，由于枢轴值已经被放置到了其应在的位置上，
    // 故通过判断枢轴值的索引是否是第K大的元素的索引(n-K)：①如果枢轴值的索引等于 n-K，
    // 那么当前的枢轴值就是第 K 大的元素，直接返回即可；②如果枢轴值的索引大于 n-K，
    // 而枢轴值左边的元素都比枢轴值小，那么第 K 大的元素必然在枢轴值的左边，
    // 因此采用递归调用的方式对枢轴值左边的部分数组进行快排，枢轴值右边的部分可以直接忽略掉；
    // ③如果枢轴值的索引小于 n-K，那么第K大的元素必然在枢轴值的右边，直接对枢轴值右边的部分数组进行快排，
    // 而左边的部分可以直接忽略掉

    //这里真的很巧妙   （其实就是快速排序的变种）
//    要求:时间复杂度O(nlogn),空间复杂度0(1) 满足
    public int findKth (int[] a, int n, int K) {
        //至于这里为什么是n-K,因为是递增排序，找第k个最大值就是找第n-K个最小值
        return findKth(a,0,n-1,n-K);
    }

    //快速排序的分区算法

    /**
     *
     * @param a
     * @param start
     * @param end
     * @param k  表示第k大的值
     * @return
     */
//    请返回第 k 大的数(包括重复的元素，不用去重)，保证答案存在。 这里没有做Null处理
    // start end k全部为数组的索引
    public int findKth(int[] a,int start ,int end,int k){
        //这里直接取start位为pivot
        int pivot=a[start];
        //使用头尾指针
        int pre=start+1;
        int after=end;
        //一次分区
        while (pre<=after){
            //这里需要是大于
            if (a[pre]>pivot){
                int temp=a[pre];
                a[pre]=a[after];
                a[after]=temp;
                after--;
            }else {
                pre++;
            }
        }
        //这里还是需要交换，不要漏了
        int temp=a[after];
        a[after]=a[start];
        a[start]=temp;
        if (after==k){
            return a[after];
        }else if (after < k){
            //after<k表示k在左边
            return findKth(a,after+1,end,k);
        }else {
            //after> k，表示k在右边
            return findKth(a,start,after-1,k);
        }
    }

}
