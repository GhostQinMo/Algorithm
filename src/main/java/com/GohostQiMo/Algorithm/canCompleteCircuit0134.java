package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.annotation.Target;

/**
 * @author Black_ghost
 * @title: canCompleteCircuit0134
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-08 08:51:17
 * @Description 力扣134. 加油站   贪心
 **/
@Slf4j
public class canCompleteCircuit0134 {
    /**
     * 解法一：暴力美学 ，什么时候用for，什么时候用while，在这里你可以得到答案
     * 暴力美学思路：以每个加油站为起点，循环一周看是否能成功
     * @param gas
     * @param cost
     * @return
     */
    //for循环适合模拟从头到尾的遍历，而while循环适合模拟环形遍历

    /**
     * 如果题目有解，该答案即为唯一答案。
     * 输入数组均为非空数组，且长度相同。
     * 输入数组中的元素均为非负数。
     */
    //测试结果：存在超时
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            //初始化,跑完当前路段还是否有汽油剩余
            int cur_gas = gas[i] - cost[i];
            //下一个索引，因为如果是当前索引的话，while判断条件不好写，
            int next_index = (i + 1) % gas.length;
            //以当前i为起点，开始一周循环
            while (cur_gas >= 0 && next_index != i) {
                cur_gas += gas[next_index] - cost[next_index];
                next_index = (next_index + 1) % gas.length;
            }
            //如果跑完了一圈，则找到了起点
            if (cur_gas >= 0) {
                //结果返回起点索引
                return next_index;
            }
        }
        return -1;
    }

    /**
     * 第一解法：不算是贪心算法，但是很巧妙啊，第三种情况很难想到
     * 情况一：如果gas的总和小于cost总和，那么无论从哪里出发，一定是跑不了一圈的
     * <p>
     * 情况二：rest[i] = gas[i]-cost[i]为一天剩下的油，i从0开始计算累加到最后一站，如果累加没有出现负数，说明从0出发，油就没有断过，那么0就是起点。
     * <p>
     * 情况三：如果累加的最小值是负数，汽车就要从非0节点出发，从后向前，看哪个节点能把这个负数填平，能把这个负数填平的节点就是出发节点。
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit_prefer(int[] gas, int[] cost) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            count += gas[i] - cost[i];
            if (count < min) {
                min = count;
            }
        }
        //情况1、情况2
        if (count < 0) return -1;
        if (min >= 0) return 0;
        //情况3，注意这里需要从后往前遍历，至于为什么？如果min出现负数则起点一定不是索引0位置的，如果后面的哪个可以填充这个负数，则可以跑完一圈
        for (int i = gas.length - 1; i >= 0; i--) {
            int cur = gas[i] - cost[i];
            //这里需要注意还是需要累加的不能直接判断cur+min>=0;因为这个负数可能是后面几个加油站一起填充的
            min += cur;
            if (min >= 0) {
                //注意这里返回的不是cur,而是索引
                return i;
            }
        }
        return -1;
    }

    /**
     * 贪心:这里的思路和最连续和有点像，一旦出现负数则从下一个整数开始计算
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit_prefer01(int[] gas, int[] cost) {
        //做题之前需要明白：如果gas之和大于cost之和，是一定会有结果的
        //初始化，记录从哪个索引开始的，作为返回结果
        int start=0;
        //gas之和是否大于cost之和
        int total=0;
        //记录gas[i]与cost[i]前i项之差
        int cursum=0;
        for (int i = 0; i < gas.length; i++) {
            total+=gas[i]-cost[i];
            cursum+=gas[i]-cost[i];
            //出现负数了，重置cursum和起点
            if (cursum<0){
                start=i+1;
                cursum=0;
            }
        }
        //如果total>=0一定有结果
        if (total>=0){
            return start;
        }
        return -1;
    }

    @Test
    public void test01() {
        int[] gas={1,2,3,4,5};
        int[]  cost={3,4,5,1,2};
        final int i = canCompleteCircuit_prefer01(gas, cost);
        System.out.println("i = " + i);
    }
}
