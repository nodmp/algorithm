package com.nodmp.algorithm.leetcode.lc_dtgh.lc_322;

import java.util.Arrays;
import java.util.HashMap;

/**
 * [回溯算法，动态规划，遍历]
 */
public class Solution {
    //超出时间限制的优化
    private HashMap<Integer, Integer> hashMap = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        return find(coins, amount);
    }

    public int find(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int num = hashMap.containsKey(amount) ? hashMap.get(amount) : find(coins, amount - coin);
            if (num == -1) {
                continue;
            }
            res = Math.min(res, 1 + num);
        }
        res = (res == Integer.MAX_VALUE) ? -1 : res;
        hashMap.put(amount, (res == -1) ? -1 : res - 1);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {1, 2, 5};
        System.out.println(solution.coinChange2(ints, 11));
    }

    //->>>>>>>>>>>>>change 从底向上 动态规划
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {

                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    //////////////
}
