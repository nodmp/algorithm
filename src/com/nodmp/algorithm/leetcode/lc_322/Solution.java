package com.nodmp.algorithm.leetcode.lc_322;

import java.util.HashMap;

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
        System.out.println(solution.coinChange(ints, 11));
    }

}
