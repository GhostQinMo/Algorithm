package com.GohostQiMo.AllSorted;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Scanner;

/**
 * @author Black_ghost
 * @title: quickSort
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-16 15:22:04
 * @Description 快速排序
 **/
@Slf4j
public class quickSort {
    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        //递归出口
        if (left >= right) {
            return;
        }
        int i = left, j = right;
        //基准值pivot
        int temp = arr[left];
        while (i < j) {
            //双指针 从右往左找比基准值小的数，从左往右找比基准值大的数
            while (i < j && arr[j] >= temp) {
                j--;
            }
            while (i < j && arr[i] <= temp) {
                i++;
            }
            //交换  这里还是需要比较i和j的大小的，不然会出现数组越界，
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        //arr[i]一定是小于基准值的，所以交换
        arr[left] = arr[i];
        arr[i] = temp;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }


    @Test
    public void test01() {
        //乱序数组
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 10, 9};
//        int[] arr = {6,5,7,3,5,7,6};
        quickSort(arr, 0, arr.length - 1);
//        recursion(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.println("i = " + i);
        }
    }


    //练习一下ACM模式的快排
    public static void main(String[] args){
        //输入元素，数组长度和数组元素
        Scanner scanner=new Scanner(System.in);
        //记录数组的长度
        int arr_len=scanner.nextInt();
        //记录数组元素本身（这里其实可以在输入元素的时候采用插入排序也可以排序，这里主要练习快排）
        int[] arr=new int[arr_len];
        for(int i=0;i<arr_len;i++){
            arr[i]=scanner.nextInt();
        }
        //调用递归函数排序
        recursion(arr,0,arr_len-1);
        //打印数组
        for (int i = 0; i < arr_len; i++) {
            if (i==arr_len-1){
                System.out.print(arr[i]);
            }else
            System.out.print(arr[i]+" ");
        }
    }

    /**
     * 快排递归函数
     * @param arr 给定数组
     * @param left
     * @param right
     */
    public static  void recursion(int[] arr,int left,int right){
        //递归终止条件
        if (left>=right){
            return;
        }
        //使用双指针
        int i=left;
        int j=right;
        //选取基准pivot
        int temp=arr[left];
        //这里的i和j全是局部变量，所有没有关系，递归不需要重置
        while (i<j){
            //注意这里先动左指针还是先动右指针是有区别的啊，自己画个图想一想
           /* //从左往右找，找到一个大于基准的
            while (i<j && arr[i]<=temp){
                i++;
            }
            //从右往左找，找到一小于基准的
            while (i<j && arr[j]>=temp){
                j--;
            }*/

            //从右往左找，找到一小于基准的  这里需要先动右指针
            while (i<j && arr[j]>=temp){
                j--;
            }
            //从左往右找，找到一个大于基准的
            while (i<j && arr[i]<=temp){
                i++;
            }

            //这里还需要判断i是否小于j，因为有可能i==j了
            if (i<j){
                //交换
                int t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
            }
        }
        //交换基准 到这里了i和j一定是相等的，所以使用i还是j多可以
        log.debug("i==j,{}",i==j);
        arr[left]=arr[i];
        arr[i]=temp;
        //递归
        recursion(arr,0,j-1);
        recursion(arr,j+1,right);
    }
}
