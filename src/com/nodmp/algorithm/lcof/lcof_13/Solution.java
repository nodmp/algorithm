package com.nodmp.algorithm.lcof.lcof_13;

public class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        ///////机器人访问///////////
        return find(0, 0, m, n, k, visited);
    }

    public int find(int x, int y, int m, int n, int k,boolean[][] visited) {
        //访问
        if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || (x / 10 + x % 10 + y / 10 + y % 10) > k) {
            return 0;
        }
        ///
        visited[x][y] = true;
        return find(x - 1, y, m, n, k, visited)
                + find(x + 1, y, m, n, k, visited)
                + find(x, y - 1, m, n, k, visited)
                + find(x, y + 1, m, n, k, visited) + 1;
    }

}
