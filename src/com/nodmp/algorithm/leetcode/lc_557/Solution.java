package com.nodmp.algorithm.leetcode.lc_557;

public class Solution {
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String s2 : s1) {
            builder.append(new StringBuilder(s2).reverse().toString());
            builder.append(" ");
        }
        return builder.toString().trim();
    }
}
