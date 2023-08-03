package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: wiggleMaxLength0376
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-01 20:56:29
 * @Description 力扣 376. 摆动序列
 **/
@Slf4j
public class wiggleMaxLength0376 {
//    如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
//    例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
//    相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
//    子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
//    给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。

    /**
     * 解题思路：真的很难想到  具体思路见代码随想录https://www.programmercarl.com/0376.%E6%91%86%E5%8A%A8%E5%BA%8F%E5%88%97.html#%E6%80%9D%E8%B7%AF
     * @param nums
     * @return
     */
    //你能否用 O(n) 时间复杂度完成此题?
    public int wiggleMaxLength(int[] nums) {
        /*这个题使用贪心算法的话需要考虑三种情况，可以先看上面解题思路不然很难看下面三种情况在讲什么
        case1: 只有两个元素或者一个元素的情况
        case2: 存在上平下这种结构，或者下平上这种情况（这两种情况是一样，只需要考虑一种即可）
        case3: 存在上平上这种结构，或者下平下这种情况（这两种情况是一样，只需要考虑一种即可）
        * */
        //初始化：默认数组最右边存在一个摆动（题目：仅有一个元素或者含两个不等元素的序列也视作摆动序列）
        int result=1;
        //只有一个元素的情况
        if(nums.length==1){
            return result;
        }
        //这里采用添加一个虚拟数组元素的方式来解决只有两个元素的情况，
        // 因为计算 prediff（nums[i] - nums[i-1]） 和 curdiff（nums[i+1] - nums[i]）的时候，至少需要三个数字
        int prediff=0;  //添加了一个元素，所以prediff初始化为0，（1，2）转换为（1，1，2）的情况prediff是平坡
        int curdiff=0; //这里任意初始化
        //确定遍历顺序 (最后一个元素默认就是一个摆动)
        for(int i=0;i<nums.length-1;i++){
            curdiff=nums[i+1]-nums[i];
            if((prediff>=0 && curdiff <0) || (prediff<=0 && curdiff>0)){ //case1和case2
                //符合摆动，记录结果
                result++;
                //case3  注意更新prediff的条件(只要存在摆动才需要更新，这样才能解决case3的情况)
                prediff=curdiff;
            }
        }
        return result;
    }
}
