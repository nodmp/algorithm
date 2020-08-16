package com.nodmp.algorithm.lcof.lcof_15;

public class Solution {
    // you need to treat n as an unsigned value
    //
    public int hammingWeight(int n) {
        //
        int i = 0;
        for (int j = 0; j < 32; j++) {
            i += n& 1;
            n >>= 1;

        }
        return i;
    }

    public static void main(String[] args) {
        int i = new Solution().hammingWeight(7);
        System.out.println(i);
    }
    public int hammingWeight2(int n) {
        //
        int i = 0;
        while (n != 0) {
            i++;
            n = n & (n - 1);
        }
        return i;
    }

}
