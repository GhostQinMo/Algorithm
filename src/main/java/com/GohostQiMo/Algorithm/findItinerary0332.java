package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @author Black_ghost
 * @title: findItinerary0332
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-15 18:49:54
 * @Description 力扣  332. 重新安排行程
 **/
@Slf4j
public class findItinerary0332 {
    /**
     * 一种包含递归回溯的场景题，很难看出需要使用递归回溯来解决
     * @param tickets
     * @return
     */
    //返回结果
    List<String> result=new ArrayList<>();
    //路径
    List<String> path=new ArrayList<>();
    //题目提示：假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
    public List<String> findItinerary(List<List<String>> tickets) {
        //排序：因为行程存在多种结果，需要返回字典序最小路径，按照终点排序，因为起点已经确定
        //注意：这里字符串全部是大写字母组成，如果有大小字母混合的情况，自行考虑
        tickets.sort(Comparator.comparing(o -> o.get(1)));
        //初始化path
        path.add("JFK");
        recursion(tickets, new boolean[tickets.size()]);
        return result;
    }

    /**
     *
     * @param tickets  给定数组
     * @param used  用户记录机票是否使用过（每一张机票只能使用一次）
     * @return  boolean  至于这里的递归函数有了返回值，首先递归函数的返回值和参数都是需要根据使用场景来确定的，
     * 这里使用boolean最为返回值是因为，结果只需要返回一条合法路径即可
     */
    public boolean recursion(List<List<String>> tickets,boolean[] used){
        //终止条件：当路径长度等于机票长度+1时，说明所有机票都已经使用过了，那么就返回true
        if (path.size()==tickets.size()+1){
            result=new ArrayList<>(path);
            return true;
        }
        //遍历
        for (int i = 0; i < tickets.size(); i++) {
            //当前票没有使用，且当前票的起点是上一站的终点
            if(!used[i]&& Objects.equals(tickets.get(i).get(0), path.get(path.size() - 1))){
                //添加路径 (添加终点)
                path.add(tickets.get(i).get(1));
                //标记这一张票已经用了不能在用了
                used[i]=true;
                //递归 (这里只需要取得一个成功路径就可以返回了)
                if (recursion(tickets,used)) return true;
                //回溯
                path.remove(path.size()-1);
                used[i]=false;
            }
        }
        //如果失败
        return false;
    }


    @Test
    public void test01(){
        List<List<String>> tickets=new ArrayList<>();
        List<String> list1=new ArrayList<>();
        list1.add("JFK");
        list1.add("SFO");
        List<String> list2=new ArrayList<>();
        list2.add("JFK");
        list2.add("ATL");
        List<String> list3=new ArrayList<>();
        list3.add("SFO");
        list3.add("ATL");
        List<String> list4=new ArrayList<>();
        list4.add("ATL");
        list4.add("JFK");
        List<String> list5=new ArrayList<>();
        list5.add("ATL");
        list5.add("SFO");
        tickets.add(list1);
        tickets.add(list2);
        tickets.add(list3);
        tickets.add(list4);
        tickets.add(list5);
        List<String> itinerary = findItinerary(tickets);
        log.info("{}",itinerary);
    }

}
