package com.nodmp.algorithm.leetcode.lc_46_51_679.lc_491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.ToIntFunction;

public class Solution {
    //    输入: [4, 6, 7, 7]
//    输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/increasing-subsequences
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    ///使用回溯算法进行进行遍历，其中将
    List<List<Integer>> resultList = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        findSubMethod(-1,nums, list);
        return resultList;
    }

    private void findSubMethod(int index,int[] nums, LinkedList<Integer> list) {
        //中断条件
        //修正版本
        if (list.size() > 1) {
            /////////
            resultList.add(new LinkedList<>(list));
        }

        HashSet set = new HashSet();
        for (int i = index + 1; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            if (index == -1 || nums[i] >= nums[index]) {
                list.add(nums[i]);
                findSubMethod(i, nums, list);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().findSubsequences(new int[]{4, 6, 7, 7});
        System.out.println(lists.size());
        for (List<Integer> list : lists) {
            System.out.print("[");
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
