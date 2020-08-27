package com.nodmp.algorithm.leetcode.lc_dtgh.lc_509;

import java.util.Arrays;
import java.util.List;

/**
 *         4
 *        / \
 *      /    \
 *     2      3
 *    / \    / \
 *   0   1   1  2
 *             / \
 *            0   1
 *  这里面包含了很多的重复计算，我们进行剪枝
 *         4
 *        / \
 *      /    \
 *            3
 *    / \    / \
 *              2
 *             / \
 *            0   1
 */
public class Solution {
    //1.第一个解法
    public int fib0(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    //2.第二个解法
    public int fib1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] nums = new int[n+1];
        return helper(nums, n);
    }

    private int helper(int[] nums, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (nums[n] != 0) {
            return nums[n];
        }
        nums[n] = helper(nums, n - 1) + helper(nums, n - 2);
        return nums[n];
    }

    //3.第三个解法
    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 | n == 2) {
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        nums[2] = 1;
        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }
    //状态压缩
    public int fib(int N) {
        if (N < 1) {
            return N;
        }
        int frist = 1;
        int sencond = 0;
        for (int i = 2; i <= N; i++) {
            int flag = frist;
            frist = frist + sencond;
            sencond = flag;
        }
        return frist;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 10; i++) {
            System.out.print("i" + i +"-");
            System.out.println(solution.fib2(i));
        }
    }
}

