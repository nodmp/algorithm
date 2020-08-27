package com.nodmp.algorithm.lcof.lcof_19;

public class Solution {
    //todo
    public boolean isMatch(String s, String p) {
        return match(0, 0, s.toCharArray(), p.toCharArray());
    }

    public boolean match(int i, int j, char[] s, char[] p) {
        boolean flag = false;
        if (j == p.length) {
            return i == s.length;
        }
        if (i < s.length && (s[i] == p[j] || p[j] == '.')) {
            flag = true;
        }
        boolean result;
        if (j <= p.length - 2 && p[j + 1] == '*') {
            result = match(i, j + 2, s, p) || flag && match(i + 1, j, s, p);
        } else {
            result = flag && match(i + 1, j + 1, s, p);
        }
        return result;
    }
}
