package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Black_ghost
 * @title: findMinArrowShots0452
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-09 14:43:12
 * @Description 力扣 452. 用最少数量的箭引爆气球
 **/
@Slf4j
public class findMinArrowShots0452 {
    /**
     * 贪心：局部最优：当气球出现重叠，一起射，所用弓箭最少。全局最优：把所有气球射爆所用弓箭最少。
     * 关于完整的解请看代码随想录文档
     * @param points
     * @return int 弓箭数量
     * 我的理解：类似于区间合并问题，也是先排序
     */
    //终于可以不要看题解写出一题中等贪心了
    public int findMinArrowShots(int[][] points) {
        //按照右边界排序（升序）
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int result=1;
        int min_right =points[0][1];
        //遍历
        for (int[] point : points) {
            //每次遍历多需要跟新右边边界，这里的右边边界指的是当前重叠区间中的最小右边界
            //如果左边界大于最小右边界，说明不重叠，需要更新最小右边界
            if (point[0] > min_right) {
                result++;
                min_right= point[1];
            }else {
                //小于等于最小右边界，说明重叠，更新最小右边界
                min_right=Math.min(min_right,point[1]);
            }
        }
        return result;
    }

    @Test
    public void test01(){
        int[][] points={{10,16},{2,8},{1,6},{7,12}};
        int minArrowShots = findMinArrowShots(points);
        log.info("minArrowShots:{}",minArrowShots);
    }
}
