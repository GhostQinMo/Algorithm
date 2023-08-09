package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Black_ghost
 * @title: reconstructQueue0406
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-09 14:02:12
 * @Description 力扣  406. 根据身高重建队列
 **/
@Slf4j
public class reconstructQueue0406 {
    /**
     * 解题思路：如果两个维度一起考虑一定会顾此失彼，先确定一个维度再确定一个维度才是正解，
     * 完整解题思路请看：https://www.programmercarl.com/0406.%E6%A0%B9%E6%8D%AE%E8%BA%AB%E9%AB%98%E9%87%8D%E5%BB%BA%E9%98%9F%E5%88%97.html#%E6%80%9D%E8%B7%AF
     * @param people
     * @return
     */
    //总结：当出现两个维度一起考虑的情况，其技巧都是确定一边然后贪心另一边，两边一起考虑，就会顾此失彼（这个与分发糖果是同样的思路）
    //题目提示：题目数据确保队列可以被重建
    //每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(item1,item2)->{
            //先按照身高降序排序，如果身高相同则按照k升序排序
            return item1[0]==item2[0]?item1[1]-item2[1]:item2[0]-item1[0];
        });
        //优先按身高高的people的k来插入。插入操作过后的people满足队列属性
        //关于容器的使用在不同的语言需要仔细考虑，因为会影响性能，如果在C++中的vector和链表来做这题会存在一定的性能差距（具体看题目完整题解）
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            //按照k值插入时后面插入的元素不会影响到前面的元素，因为前面元素的身高已经是已经确定好了的，最初的时候排序之后前面一定比后面的高
            list.add(person[1],person);
        }
          return list.toArray(new int[list.size()][]);
    }


    @Test
    public void test01(){
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        final int[][] ints = reconstructQueue(people);
        for (int[] anInt : ints) {
            log.info("{}",anInt);
        }
    }
}
