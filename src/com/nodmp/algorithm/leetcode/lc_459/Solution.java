package com.nodmp.algorithm.leetcode.lc_459;

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
