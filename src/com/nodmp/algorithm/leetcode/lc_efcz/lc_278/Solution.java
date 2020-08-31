package com.nodmp.algorithm.leetcode.lc_efcz.lc_278;

public class Solution extends VersionControl {

    @Override
    boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        /////////// 1 1 1 1 [1] 0 0 0 0
        /////
        while (left < right) {
            int mid = left + (right - left) / 2;
            //true->
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
