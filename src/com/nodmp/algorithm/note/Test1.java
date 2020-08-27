package com.nodmp.algorithm.note;

import java.util.PriorityQueue;

public class Test1 {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.offer("BACC");
        queue.offer("CACC");
        queue.offer("AACC");
        queue.offer("EACC");
        while (queue.size() != 0) {
            System.out.println(queue.poll());

        }
    }
}
