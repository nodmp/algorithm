package com.nodmp.algorithm.leetcode.lc_dtgh.my_package;

/**
 * my_package
 * N = 3, W = 4  ,,给你一个可装载重量为 W 的背包和 N 个物品，每
 * wt = [2, 1, 3]
 * val = [4, 2, 3]
 * 状态_背包的容量_可选择的物品
 * 选择_选择或者不选择
 *for 状态1 in 状态1_list
 *  for 状态2 in 状态2_list
 *       dp[状态1][状态2] = 条件（选择1，选择2）
 *
 *      dp的定义很重要
 *
 *  | | | | | | |
 *  V V V V V V V
 *
 */
public class Solution {
    int packageMax(int[] wt, int[] val, int N, int W) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= W; w++) {
                if (w - wt[i - 1] < 0) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        int[] wt = new int[]{2, 1, 3};
        int[] val = new int[]{4, 2, 3};
        int N = 3;
        int W = 4;
        int i = new Solution().packageMax(wt, val, N, W);
        System.out.println(i);
    }
}
