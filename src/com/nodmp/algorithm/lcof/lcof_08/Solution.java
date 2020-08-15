package com.nodmp.algorithm.lcof.lcof_08;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(2);
        int m = obj.deleteHead();
        System.out.println(m);

    }
}
class CQueue {

    Stack<Integer> node1 = new Stack<>();
    Stack<Integer> node2 = new Stack<>();
    //Stack && Stack
    public CQueue() {
        //empty
    }

    ////1 2 3 P P 5 6
    public void appendTail(int value) {
        node1.push(value);//node1创建
    }

    public int deleteHead() {
        if (!node2.isEmpty()) {
            return node2.pop();
        }
        if (node1.isEmpty()) {
            return -1;
        } else {
            //更新
            while (!node1.isEmpty()) {
                node2.push(node1.pop());
            }
            return node2.pop();
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */