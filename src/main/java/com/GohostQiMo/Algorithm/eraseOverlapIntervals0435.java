package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Black_ghost
 * @title: eraseOverlapIntervals0435
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-09 15:17:03
 * @Description 力扣   435. 无重叠区间
 **/
@Slf4j
public class eraseOverlapIntervals0435 {
    /**
     * 注意：不管任何题，题目看三遍（慢点看）
     *
     * @param intervals
     * @return int 返回最少需要移除的区间个数
     * 返回需要移除区间的最小数量，使剩余区间互不重叠,而用最少数量的箭引爆气球题目求得是非重叠区间的最大数量，
     * 与本题目结果刚好是“互补”的
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        //按照左边界排序(默认升序)
        Arrays.sort(intervals, Comparator.comparingInt(item -> item[0]));
        int result = 1;
        int min_right = intervals[0][1];
        for (int[] interval : intervals) {
            //这里需要注意一下  题目提示：区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠，与最少数量的箭引爆气球题目不同
            ////注意这里是小于等于，题目说了区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠
            if (interval[0] >= min_right) {
                result++;
                min_right = interval[1];
            }else {
                //更新最小右边界
                min_right = Math.min(min_right, interval[1]);
            }
        }
        return intervals.length-result;
    }

    @Test
    public void test01(){
//        int[][] intervals={{1,2},{2,3},{3,4},{1,3}};
        int[][] intervals={{1,2},{1,2},{1,2}};
        int i = eraseOverlapIntervals(intervals);
        log.info("i:{}",i);
    }

}
