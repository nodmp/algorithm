package com.nodmp.algorithm.leetcode.lc_hssf.lc_679;

public class Solution679 {
    public boolean judgePoint24(int[] nums) {
        /////////////////////////////
        return hasPoint(nums, 0);
    }

    ////先循环
    public boolean hasPoint(int[] nums, int index) {
        if (index == nums.length) {
            return judge(nums[0], nums[1], nums[2], nums[3]);
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            if (hasPoint(nums, index + 1)) {
                return true;
            }
            swap(nums, index, i);
        }
        return false;
    }

    private boolean judge(double num, double num1, double num2, double num3) {
        return judge(num + num1, num2, num3) ||
                judge(num - num1, num2, num3) ||
                judge(num * num1, num2, num3) ||
                judge(num / num1, num2, num3);
    }

    private boolean judge(double num, double num1, double num2) {
        return judge(num + num1, num2) ||
                judge(num - num1, num2) ||
                judge(num / num1, num2) ||
                judge(num * num1, num2) ||
                judge(num1 - num, num2) ||
                judge(num1 / num, num2) ||
                judge(num, num1 + num2) ||
                judge(num, num1 - num2) ||
                judge(num, num1 * num2) ||
                judge(num, num1 / num2);
    }

    private boolean judge(double num, double num1) {

        return Math.abs(num + num1 - 24) < 0.01 ||
                Math.abs(num - num1 - 24) < 0.01 ||
                Math.abs(num * num1 - 24) < 0.01 ||
                Math.abs(num1 - num - 24) < 0.01 ||
                Math.abs(num1 / num - 24) < 0.01 ||
                Math.abs(num / num1 - 24) < 0.01;
    }

    private void swap(int[] nums, int index, int i) {
        int flag = nums[index];
        nums[index] = nums[i];
        nums[i] = flag;
    }
}
