package com.nodmp.algorithm.leetcode.lc_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    HashMap<String, String> words = init();
    List<String> list = new ArrayList<>();
    //abc def
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }
        StringBuilder builder = new StringBuilder();
        dfs(0, digits, builder);
        return list;
    }

    public static void main(String[] args) {
        List<String> list = new Solution().letterCombinations("23");
        for (String s : list) {
            System.out.println(s);
        }
    }

    public void dfs(int index, String digits, StringBuilder builder) {
        if (index == digits.length()) {
            list.add(builder.toString());
            return;
        }
        String s = words.get(String.valueOf(digits.charAt(index))); //abc
        for (int i = 0; i < s.length(); i++) {
            builder.append(s.charAt(i));
            dfs(index + 1, digits, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public HashMap<String, String> init() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("2", "abc");
        hashMap.put("3", "def");
        hashMap.put("4", "ghi");
        hashMap.put("5", "jkl");
        hashMap.put("6", "mno");
        hashMap.put("7", "pqrs");
        hashMap.put("8", "tuv");
        hashMap.put("9", "wxy");
        return hashMap;
    }

}
