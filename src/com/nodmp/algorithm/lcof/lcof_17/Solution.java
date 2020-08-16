package com.nodmp.algorithm.lcof.lcof_17;

public class Solution {
    public int[] printNumbers(int n) {
        int m = 0;
        for (int i = 0; i < n; i++) {
            m = m * 10 + 9;
        }
        int[] ints = new int[m];
        for (int i = 0; i < m; i++) {
            ints[i] = i + 1;
        }
        return ints;
    }

    public static void main(String[] args) {
        new Solution().printNumbers(1);
    }
}
