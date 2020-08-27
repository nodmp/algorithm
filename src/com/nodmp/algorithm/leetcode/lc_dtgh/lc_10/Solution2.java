package com.nodmp.algorithm.leetcode.lc_dtgh.lc_10;

import java.util.HashMap;

//算法改造
public class Solution2 {
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
            result = match(i, j + 2, textArray, patterArray) || flag && match(i + 1, j, textArray, patterArray);
        } else {
            result = flag && match(i + 1, j + 1, textArray, patterArray);
        }
        hashMap.put(i + "&" + j, result);
        return result;
    }
}
