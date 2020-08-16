package com.nodmp.algorithm.lcof.lcof_14_II;

public class Solution {
    //todo 这样的解答是错误的，这里有可能按照 a无限增大，出现大数问题
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3,a) %1000000007;
        } else if (b == 1) {
            return (int) (Math.pow(3, a - 1) * 4) %1000000007;
        } else {
            return ((int) Math.pow(3, a) * 2)%1000000007;
        }
    }
    //todo  https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/mian-shi-ti-14-ii-jian-sheng-zi-iitan-xin-er-fen-f/
    public int cuttingRope2(int n) {
        if(n <= 3) return n - 1;
        int b = n % 3; //剩余余数 0 1 2
        int p = 1000000007; //求余的
        //////////n_////////////////
        long rem = 1;
        long x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1)
                rem = (rem * x) % p;
            x = (x * x) % p;
        }
        //////////////////////////////
        if(b == 0) return (int)(rem * 3 % p);
        if(b == 1) return (int)(rem * 4 % p);
        return (int) (rem * 6 % p);
    }
}
