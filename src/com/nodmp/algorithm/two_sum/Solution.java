package com.nodmp.algorithm.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode-cn.com/problems/two-sum/
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int m = target - nums[i]; //9-2 = 7
            if (!map.containsKey(m)) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(m), i};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        int[] ints = new Solution().twoSum(nums, 9);
        System.out.println(Arrays.toString(ints));

    }
}
