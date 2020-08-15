package com.nodmp.algorithm.lcof.lcof_05;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class Solution {
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    public String replaceSpace2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = new Solution().replaceSpace("We are happy.");

    }
}
