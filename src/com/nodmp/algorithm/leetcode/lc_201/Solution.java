package com.nodmp.algorithm.leetcode.lc_201;

public class Solution {
    /////////////进行一个遍历
    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        for (; m != n; ++offset) {
            m >>= 1;
            n >>= 1;
        }
        return n << offset;
    }
}
