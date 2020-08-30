package com.nodmp.algorithm.leetcode.lc_efcz.lc_69;

import com.sun.scenario.effect.Brightpass;

public class Solution {
    public int mySqrt(int x) {
        //二分查找
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            ///慢慢逼近的一个过程
            //1,2,3,4
            // 8
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
