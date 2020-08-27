package com.nodmp.algorithm.leetcode.lc_hssf;

import java.util.Arrays;

public class Test {
    static int i = 0;
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Test().layout(nums, 0);
        System.out.println(i);
    }
    public void layout(int[] nums, int index) {
        if (index == nums.length) {
            i++;
            System.out.println(Arrays.toString(nums));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            layout(nums, index + 1);
            swap(nums, index, i);
        }
    }
    private void swap(int[] nums, int index, int i) {
        int flag = nums[index];
        nums[index] = nums[i];
        nums[i] = flag;
    }
}
