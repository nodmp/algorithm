package com.nodmp.algorithm.lcof.lcof_12;

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        //临界值判断
        int x = board.length;
        int y = board[0].length;
        boolean[][] visited = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (find(board, i, j, visited, word.toCharArray(), 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(char[][] board, int x, int y, boolean[][] visited, char[] chars, int index) {
        if (index == chars.length) {
            return true;
        }
        if (x < 0 || y < 0 || x == board.length || y == board[0].length || visited[x][y] || board[x][y] != chars[index]) {
            return false;
        }
        visited[x][y] = true;
        boolean res = find(board, x + 1, y, visited, chars, index + 1)
                || find(board, x - 1, y, visited, chars, index + 1)
                || find(board, x, y + 1, visited, chars, index + 1)
                || find(board, x, y - 1, visited, chars, index + 1);
        visited[x][y] = false;
        return res;
    }

}
