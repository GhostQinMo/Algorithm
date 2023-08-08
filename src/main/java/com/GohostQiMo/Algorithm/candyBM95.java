package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Black_ghost
 * @title: candyBM95
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-20 15:26:11
 * @Description 牛客101  BM95 分糖果问题
 **/
@Slf4j
public class candyBM95 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * pick candy
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    // 那么本题我采用了两次贪心的策略：

    // 一次是从左到右遍历，只比较右边孩子评分比左边大的情况。
    // 一次是从右到左遍历，只比较左边孩子评分比右边大的情况。
    // 这样从局部最优推出了全局最优，即：相邻的孩子中，评分高的孩子获得更多的糖果。
    public int candy (int[] arr) {
        //我的贪心理解：先找右边比左边大的情况，再找左边比右边大的情况，最后合并最优解（注意合并策略）
        //贪心一：从左往右找右边比左边大的
        int[] left_to_right=new int[arr.length];

        //初始化
        left_to_right[0]=1;
        Arrays.fill(left_to_right,1);
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                left_to_right[i]=left_to_right[i-1]+1;
            }
        }
        //贪心二：从右往左找 左边比右边大的
        // 遍历顺序这里有同学可能会有疑问，为什么不能从前向后遍历呢？
        // 因为 rating[5]与rating[4]的比较 要利用上
        // rating[5]与rating[6]的比较结果，所以 要从后向前遍历。

        // 如果从前向后遍历，rating[5]与rating[4]的比较 就不能用上
        // rating[5]与rating[6]的比较结果了 。
        //这里顺便把结果也放到了right_to_left中了
        int[] right_to_left=new int[arr.length];
        //初始化操作
        Arrays.fill(right_to_left,1);
        right_to_left[arr.length-1]=left_to_right[arr.length-1];
        //从右往左
        for(int i=arr.length-2;i>=0;i--){
            //左边大于右边的情况
            if(arr[i]>arr[i+1]){
                right_to_left[i]=Math.max(left_to_right[i],right_to_left[i+1]+1);
            }else{
                //左边小于等于右边的情况
                right_to_left[i]=Math.max(left_to_right[i],right_to_left[i]);
            }
        }
        int min=0;
        for(int i=0;i<right_to_left.length;i++){
            min+=right_to_left[i];
        }
        return min;
    }

    @Test
    public void test01(){
        int[] nums=new int[]{1,1,2};
         int candy = candy(nums);
         log.info("candu={}",candy);
    }


    //优化之后的写法

    /**
     * 重复使用一个一位数组
     * @param arr
     * @return
     */
    public int candy_prefer (int[] arr) {
        int[] result=new int[arr.length];
        Arrays.fill(result,1);
        //从左往右
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>arr[i-1]){
                result[i]=result[i-1]+1;
            }
        }
        //从右往左
        for (int i = arr.length-2; i >=0 ; i--) {
            if (arr[i]>arr[i+1]){
                result[i]=Math.max(result[i+1]+1,result[i]);
            }
        }
        //合并
        int min=0;
        for (int i = 0; i < arr.length; i++) {
            min+=result[i];
        }
        return min;
    }
}
