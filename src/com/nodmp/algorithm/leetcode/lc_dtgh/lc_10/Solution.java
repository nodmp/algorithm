package com.nodmp.algorithm.leetcode.lc_dtgh.lc_10;

import java.util.HashMap;
import java.util.regex.Matcher;
//. 任意单个
//[x]*  x重复0 ～ 多次
public class Solution {
    /////算法的进化

    //////判断两个字符串的相等
    public boolean isMatch_0(String s, String p) {
        if (s.length() != p.length()) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chars1 = p.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] != chars1[i]) {
                return false;
            }
        }
        return true;
    }

    ///判断带有.的字符串
    public boolean isMatch_1(String s, String p) {
        if (s.length() != p.length()) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chars1 = p.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] != chars1[i] && chars1[i] != '.') {
                return false;
            }
        }
        return true;
    }

    public boolean isMatch_2(String s, String p) {
        int i = 0;
        int j = 0;
        char[] chars = s.toCharArray();
        char[] chars1 = p.toCharArray();
        while (j < p.length()) {
            if (i >= s.length()) {
                return false;
            }
            if (chars1[j++] != chars[i++]) {
                return false;
            }
        }

        return j == s.length();
    }

    /**
     * boolean isMatch()
     */
    public boolean isMatch(String text, String pattern) {
        return match(0,0, text.toCharArray(), pattern.toCharArray());
    }

    ///只能匹配数组的存在
    private HashMap<String, Boolean> hashMap = new HashMap<>();
    private boolean match(int i,int j, char[] textArray, char[] patterArray) {
        if (hashMap.containsKey(i + "&" + j)) {
            return hashMap.get(i + "&" + j);
        }
        boolean flag = false;
        //返回返回条件
        if (j == patterArray.length) {
            return i == textArray.length;
        }
        ////进行.查找
        if (i < textArray.length && (textArray[i] == patterArray[j] || patterArray[j] == '.')) {
            flag = true;
        }
        ////进行*查找
        boolean result;
        if (j <= patterArray.length-2 && patterArray[j + 1] == '*') {
            //0次匹配的情况_  _ccc a*ccc
            //匹配一次的情况  accc a*ccc
            result = match(i, j + 2, textArray, patterArray) || flag && match(i + 1, j, textArray, patterArray);
        } else {
            result = flag && match(i + 1, j + 1, textArray, patterArray);
        }
        hashMap.put(i + "&" + j, result);
        return result;
    }

    public static void main(String[] args) {
        boolean match = new Solution().isMatch("abcdds", "a.*");
        System.out.println(match);

    }
}
