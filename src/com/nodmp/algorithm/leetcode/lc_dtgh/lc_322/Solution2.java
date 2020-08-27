package com.nodmp.algorithm.leetcode.lc_dtgh.lc_322;

import java.util.HashMap;

/**
 * 1、base case  amount = 0 return   || amount < 0 return -1
 * 2.状态就是 amount 目标金额
 * 3.选择导致状态变化，也就是硬币的选择
 * 4、明确 dp 函数/数组的定义。 dp(n) 的定义 输入一个目标金额 输出凑齐目标n的最小硬币
 * 一般来说函数的参数就是状态转移中会变化的量，也就是上面说到的「状态」；函数的返回值就是题目要求我们计算的量。
 * 可以解出：
 * int coinChange(coins,amount){
 *     return dp(amount)
 * }
 * int dp(coins,n){
 *     for(i in coins){
 *         res = min(res,1+dp(n-i))
 *     }
 *     return res;
 * }
 */
public class Solution2 {
    private HashMap<Integer, Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }
    int dp(int[] coins, int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        int subproblem = 0;
        for (int coin : coins) {
            subproblem = dp(coins, n - coin);

            if (subproblem == -1) {
                continue;
            }
            res = Math.min(res, subproblem + 1);
        }
        map.put(n, res != Integer.MAX_VALUE ? res : -1);
        return map.get(n);
    }

}
