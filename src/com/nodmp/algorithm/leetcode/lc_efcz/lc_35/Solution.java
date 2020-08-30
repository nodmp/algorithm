package com.nodmp.algorithm.leetcode.lc_efcz.lc_35;

///二分查找
public class Solution {
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        System.out.printf("left:%s right:%s,mid:%s", left, right, (left + right) / 2);
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6, 7, 8, 10, 19};
        int i = new Solution().searchInsert(nums, 15);

        System.out.println(i);

    }

}
