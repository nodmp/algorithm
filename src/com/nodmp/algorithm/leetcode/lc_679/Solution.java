package com.nodmp.algorithm.leetcode.lc_679;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {4, 1, 8, 7};
        Solution solution = new Solution();
        System.out.println(solution.judgePoint24(nums));

    }

    public boolean judgePoint24(int[] nums) {
        return findIndex(nums, 0);
    }

    private boolean findIndex(int[] nums, int index) {
        if (index == 4) {
            //符合条件
            return judge(nums[0], nums[1], nums[2], nums[3]);
        }
        for (int j = index; j < 4; j++) {
            swap(nums, index, j);
            boolean b = findIndex(nums, index + 1);
            if (b) {
                return true;
            }
            swap(nums, index, j);
        }
        return false;

    }

    private void swap(int[] nums, int i, int j) {
        int flag = nums[i];
        nums[i] = nums[j];
        nums[j] = flag;
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
        return Math.abs(num + num1 - 24) < 0.01 || Math.abs(num - num1 - 24) < 0.01 || Math.abs(num * num1 - 24) < 0.01 || Math.abs(num1 - num - 24) < 0.01 || Math.abs(num1 / num - 24) < 0.01 || Math.abs(num / num1 - 24) < 0.01;
    }
}
