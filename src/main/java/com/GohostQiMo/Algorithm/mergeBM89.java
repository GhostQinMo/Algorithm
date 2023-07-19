package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author Black_ghost
 * @title: mergeBM89
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-19 14:40:39
 * @Description 牛客101  BM89 合并区间
 **/
@Slf4j
public class mergeBM89 {
    public class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param intervals Interval类ArrayList
     * @return Interval类ArrayList
     */
    private ArrayList<Interval> result=new ArrayList<>();
    public ArrayList<Interval> merge (ArrayList<Interval> intervals) {
        //TODO  边界
        if(intervals==null || intervals.size()==0){
            return result;
        }
        //排序
        Collections.sort(intervals,Comparator.comparingInt(val->val.start));
        int minleftrange=intervals.get(0).start;
        int maxrightrange=intervals.get(0).end;
        for(int i=1;i<intervals.size();i++){
            //排完序了，如果下一个区间的起点小于等于当前的最小右标识，则合并
            if(intervals.get(i).start<=maxrightrange){
                maxrightrange=Math.max(intervals.get(i).end,maxrightrange);
            }else{
                //如果大于则出现了一个新的区间
                //加入一个区间
                result.add(new Interval(minleftrange,maxrightrange));
                //更新
                minleftrange=intervals.get(i).start;
                maxrightrange=intervals.get(i).end;
            }
        }
        //加入最后一个区间
        result.add(new Interval(minleftrange,maxrightrange));
        return result;
    }
}
