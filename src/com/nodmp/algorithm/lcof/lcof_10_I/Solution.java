package com.nodmp.algorithm.lcof.lcof_10_I;
//todo 这里需要需要重新理解
public class Solution {
    //fib
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int last = 1;
        for (int i = 2; i <= n; i++) {
            int m = last;
            last = (last + first) % 1000000007;
            first = m;
        }
        return last;
    }

    public static void main(String[] args) {
//        int fib = new Solution().fib(2);
//        System.out.println(fib);
        for (int i = 0; i <= 5; i++) {
            System.out.println(i+"-"+new Solution().fib(i));
        }

    }
}
