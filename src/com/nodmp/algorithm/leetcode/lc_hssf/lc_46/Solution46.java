package com.nodmp.algorithm.leetcode.lc_hssf.lc_46;

import java.util.LinkedList;
import java.util.List;

/**
 * 回溯框架
 * result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 *
 */
public class Solution46 {
    List<List<Integer>> lists = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        ///全排列问题
        List<Integer> list = new LinkedList<>();
        backtrack(nums, list);
        return lists;
    }

    private void backtrack(int[] nums, List<Integer> list) {
        if (nums.length == list.size()) {
            lists.add(new LinkedList<>(list));

            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            backtrack(nums, list);
            list.remove(Integer.valueOf(nums[i]));
        }
    }
}
