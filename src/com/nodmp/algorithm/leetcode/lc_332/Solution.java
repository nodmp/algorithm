package com.nodmp.algorithm.leetcode.lc_332;

import java.util.*;

/**
 * 欧拉算法
 * @link https://zh.wikipedia.org/wiki/%E4%B8%80%E7%AC%94%E7%94%BB%E9%97%AE%E9%A2%98
 * dfs 深度优先遍历
 */
public class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> list = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }
            //////排序 AC CS BS
            /////// AC BS CS
            map.get(src).offer(dst);
        }
        ////构造数据
        dfs("JFK");
        Collections.reverse(list);
        return list;
    }

    /**
     *[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     * JFK_ATL_SFO -> ATL SFO
     * SFO_ATL
     * ATL_JFK_SFO
     *
     * JFK_ATL_JFK_SFO_ATL_SFO
     */
    public void dfs(String cur) {
        while (map.containsKey(cur) && map.get(cur).size() > 0) {
            String tmp = map.get(cur).poll();
            dfs(tmp);
        }
        list.add(cur);
    }
}
