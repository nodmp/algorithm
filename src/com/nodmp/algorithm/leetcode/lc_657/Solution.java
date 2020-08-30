package com.nodmp.algorithm.leetcode.lc_657;

import java.util.HashMap;

public class Solution {
    public boolean judgeCircle(String moves) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("U", 1);
        hashMap.put("D", -1);
        hashMap.put("R", 20);
        hashMap.put("L", -20);
        char[] chars = moves.toCharArray();
        int total = 0;
        for (char aChar : chars) {
            total += hashMap.get(String.valueOf(aChar));
        }
        return total == 0;
    }

    public static void main(String[] args) {
        boolean flag = new Solution().judgeCircle("UDDUURLRLLRRUDUDLLRLURLRLRLUUDLULRULRLDDDUDDDDLRRDDRDRLRLURRLLRUDURULULRDRDLURLUDRRLRLDDLUUULUDUUUUL");
        System.out.println(flag);

    }
}
