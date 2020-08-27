package com.nodmp.algorithm.lcof.lcof_20;

public class Solution {
    public boolean isNumber(String s) {
        char last = s.charAt(s.length() - 1);
        String lastr = new String(new char[]{last}).toLowerCase();
        if ("f".equals(lastr) || "d".equals(lastr)) {
            return false;
        }
        try {
            float s1 = Float.parseFloat(s);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static void main(String[] args) {
        boolean number = new Solution().isNumber("-788");
        System.out.println(number);

    }
}
