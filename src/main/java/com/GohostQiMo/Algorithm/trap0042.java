package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Stack;

/**
 * @author Black_ghost
 * @title: trap0042
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-01 19:20:21
 * @Description 力扣0042  接雨水
 **/
@Slf4j
public class trap0042 {
    @Test
    public void trap0042Test(){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
         int trap1 = trap(height);
        log.info("总共可以接{}体积水",trap1);
    }


    //解法一：暴力法(双指针法)
    public int trap1(int[] height){
        int count=0;
        for (int i = 0; i < height.length; i++) {
            //第一个柱子和最后一个柱子是接不住水的
            if (i==0 || i==height.length-1) {
                continue;
            }
            //寻找当前柱子的左右最高的柱子
            int rheight=height[i];
            int lheight=height[i];
            for (int r = i+1; r < height.length; r++) {
                if (height[r]> rheight) rheight=height[r];
            }
            for (int l = i-1; l >=0  ; l--) {
                if (height[l]> lheight) lheight=height[l];
            }
            //求当前柱子在当前情况可以接住的水的高度
             int value_temp = Math.min(rheight, lheight) - height[i];
            if (value_temp > 0)
                count+=value_temp;
        }
        return count;
    }


    /**
     * 解法二：双指针优化
     * @param height
     * @return
     */
    public int trap2(int[] height){
        int count=0;
        //使用maxRight和maxLeft记录当前柱的左右最高柱
        if (height.length<=2){
            //最左边和最右边的两根柱子不能接住
            return 0;
        }
        int[] maxLeft=new int[height.length],maxRight=new int[height.length];
        maxLeft[0]=height[0];
        maxRight[height.length-1]=height[height.length-1];
        //记录每个柱子的左边第一根比自己高的柱子的高度
        for (int l = 1; l <height.length ; l++) {
            maxLeft[l]=Math.max(height[l],maxLeft[l-1]);   //这里也算是动态规划的思想
        }
        //记录每个柱子的右边第一根比自己高的柱子的高度
        for (int r = height.length-2; r >0; r--) {
            maxRight[r]=Math.max(height[r],maxRight[r+1]);
        }
        for (int i = 1; i <=height.length-2; i++) {
            final int value_temp = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (value_temp>0){
                count+=value_temp;
            }
        }
        return count;
    }

    /**
     * 解法三：单调栈解法
     * @param height
     * @return
     */
    public int trap(int[] height){
        if (height.length==2) return 0;
        int len=height.length;
        Stack<Integer> idx=new Stack<>();
        idx.push(0);
        int count=0;
        //这里使用的是就是递增的单调栈（出口向栈顶递增栈）
        for (int i = 1; i <len ; i++) {
            //如果当前的柱的高度小于栈顶的元素，则直接入站
            if (height[i]<height[idx.peek()]){
                idx.push(i);
                //如果当前柱的高度等于栈顶的元素，由于计算柱的载水量是使用离当前柱最近的左右两个柱来计算的
            }else if(height[i]==height[idx.peek()]){
                idx.pop();
                idx.push(i);
            }else {
                while (!idx.isEmpty() && height[i]> height[idx.peek()]){
                    //当检测到第一个大于栈顶的柱时，则找到了栈顶的柱可以载水
                    int mid=idx.peek();
                    idx.pop();
                   if (!idx.isEmpty()){
                       //载水的高度
                       int h= Math.min(height[idx.peek()],height[i])-height[mid];
                       int w=i-idx.peek()-1;
                       count+=h*w;
                   }
                }
                //这里一定要记住，当前柱一定要入栈
                idx.push(i);
            }
        }
        return count;
    }
}
