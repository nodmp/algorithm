package com.nodmp.algorithm.leetcode.lc_332;

import java.util.*;

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
            map.get(src).offer(dst);
        }
        ////构造数据
        dfs("JFK");
        Collections.reverse(list);
        return list;
    }

    public void dfs(String cur) {
        while (map.containsKey(cur) && map.get(cur).size() > 0) {
            String tmp = map.get(cur).poll();
            dfs(tmp);
        }
        list.add(cur);
    }
}
