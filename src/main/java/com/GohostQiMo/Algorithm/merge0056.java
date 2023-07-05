package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Black_ghost
 * @title: merge0056
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-04 21:40:13
 * @Description 力扣0056 合并区间
 **/
@Slf4j
public class merge0056 {
    @Test
    public void test01(){
//        int[][] nums={{1,3},{2,6},{8,10},{15,18}};
        int[][] nums={{1,4},{4,5}};
        final int[][] merge = merge(nums);
        for (int[] one: merge) {
            System.out.println(Arrays.toString(one));
        }
    }

    public int[][] merge(int[][] intervals) {
        //存放结果容器
        List<int[]> result = new ArrayList<>();
        //使用左边界做排序处理
        /*Arrays.sort(intervals, (x,y)->{
            return Integer.compare(x[0],y[0]);
        });*/
        //如果你对这个方法不熟悉，请使用上面的lambda表达式
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        //初始化右边界和左边界
        int minleftrange = intervals[0][0];
        int maxrightrange = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //如果下一个的左边界大于了合并了左边界则需要重新分配一个单独的区间了
            if (intervals[i][0]>maxrightrange){
                result.add(new int[]{minleftrange,maxrightrange});
                //重新定义左右边界
                minleftrange=intervals[i][0];
                maxrightrange=intervals[i][1];
            }else {
                //否则就是在原来合并的边界内，怎更新右边界即可
                maxrightrange=Math.max(maxrightrange,intervals[i][1]);
            }
        }
        //最后还需要把最后一个区间添加进去
        result.add(new int[]{minleftrange,maxrightrange});
        //返回结果
        return result.toArray(new int[result.size()][]);
    }
}
