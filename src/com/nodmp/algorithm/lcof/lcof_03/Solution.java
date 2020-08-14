package com.nodmp.algorithm.lcof.lcof_03;

import java.util.HashSet;

/**
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 100%
 */
public class Solution {
    //不好的一个栗子
    public int findRepeatNumber(int[] nums) {
        // [2, 3, 1, 0, 2, 5, 3]
        // |------|
        HashSet<Integer> set = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return 0;
    }

    //鸽笼原理给力就完事
    public int findRepeatNumber2(int[] nums) {
        // [2, 3, 1, 0, 2, 5, 3]
        // |------|
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            //将i位置这个数m换到m位置
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                int flag = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = flag;
            }
        }
        return 0;
    }
}
