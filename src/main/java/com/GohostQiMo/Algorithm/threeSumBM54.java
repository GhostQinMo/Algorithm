package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Black_ghost
 * @title: threeSumBM54
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-14 11:30:40
 * @Description 牛客101  BM54 三数之和
 **/
@Slf4j
public class threeSumBM54 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param num int整型一维数组
     * @return int整型ArrayList<ArrayList<>>
     */
    //注意这里的返回值和力扣上的返回值不同
    public ArrayList<ArrayList<Integer>> threeSum (int[] num) {
        //使用双指针，因为这需要去重但是没有说要返回索引，而是数组中的元素，所以可以排序不需要维护索引
        Arrays.sort(num);

        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        int len=num.length;
        for(int i=0;i<len;i++){
            //剪枝操作，如果第一个数已经大于0了，就结束了
            if(num[i]>0){
                return result;
            }
            int left=i+1;
            int right=len-1;
            //a去重
            if(i>0 && num[i]==num[i-1]){
                continue;
            }
            while(left<right){
                int sum=num[i]+num[left]+num[right];
                if (sum>0){
                    right--;  //这里包含了对right的去重
                }else if(sum <0){
                    left++;
                }else{
                    //等于0的情况，找到一组了需要对right和left再次去重
                    ArrayList<Integer> temp=new  ArrayList<>();
                    temp.add(num[i]);
                    temp.add(num[left]);
                    temp.add(num[right]);
                    result.add(temp);
                    while(left<right && num[right]==num[right-1]) right--;
                    while(left< right && num[left]==num[left+1]) left++;
                    //重新移动到下一个不相同的位置
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
