package com.nodmp.algorithm.lcof.lcof_21;

public class Solution {
    public int[] exchange(int[] nums) {
        //奇数odd * 偶数even
        int odd = 0;
        int even = nums.length - 1;
        while (odd < even) {
            if (nums[odd] % 2 == 1) {
                odd += 1;
            }
            if (nums[even] % 2 == 0) {
                even -= 1;
            }
            if (odd < even) {
                int temp = nums[odd];
                nums[odd] = nums[even];
                nums[even] = temp;
            }
        }
        return nums;
    }

    public  boolean isOdd(int i) {
        return i % 2 != 0;
    }
}
