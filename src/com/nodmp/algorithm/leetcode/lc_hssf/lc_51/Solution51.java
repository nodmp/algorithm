package com.nodmp.algorithm.leetcode.lc_hssf.lc_51;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯框架
 * result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 *
 */
public class Solution51 {
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return null;
        }
        char[][] chars = new char[n][n];
        for (char[] aChar : chars) {
            Arrays.fill(aChar, '.');
        }
        backtrack(chars, 0);
        return res;
    }

    public void backtrack(char[][] board, int row) {
        if (row == board.length) {
            res.add(changeToList(board));
            return;
        }

        /////
        int n = board.length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board,row,col)) continue;
            board[row][col] = 'Q';
            backtrack(board, row + 1);
            board[row][col] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        for (char[] chars : board) {
            if (chars[col] == 'Q') {
                return false;
            }
        }
        for (int i = row -1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    public List<String> changeToList(char[][] chars) {
        List<String> list = new LinkedList();
        for (char[] aChar : chars) {
            list.add(String.valueOf(aChar));
        }
        return list;
    }
}
