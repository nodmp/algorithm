package com.nodmp.algorithm.lcof.lcof_10_II;
//todo 动态规划问题
public class Solution {
    public int numWays(int n) {

        //n = 0  1
        //n = 1  1
        //n = 2  2
        //n = 3  3
        //
        if (n < 2) {
            return 1;
        }
        int frist = 1;
        int last = 1;
        for (int i = 2; i <= n; i++) {
            int flag = frist;
            frist = (frist + last)%1000000007;
            last = flag;
        }
        return frist;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 5; i++) {
            System.out.println(i + "-" + new Solution().numWays(i));
        }
    }
}
