package com.nodmp.algorithm.leetcode.lc_657;

import java.util.HashMap;

public class Solution2 {
    public boolean judgeCircle(String moves) {
        int l = 0;
        int r = 0;
        int up = 0;
        int down = 0;
        int lenght = moves.length();
        moves = moves.replace("U", "");
        up = lenght - moves.length();

        lenght = moves.length();
        moves = moves.replace("D", "");
        down = lenght - moves.length();

        lenght = moves.length();
        moves = moves.replace("L", "");
        l = lenght - moves.length();

        lenght = moves.length();
        moves = moves.replace("R", "");
        r = lenght - moves.length();

        return l == r && down == up;
    }

    public static void main(String[] args) {
        new Solution2().judgeCircle("DLDDDDDLLLRRRRUUUUU");
    }
}
