package com.nodmp.algorithm.lcof.lcof_06;

import com.nodmp.algorithm.common.ListNode;

import java.util.Stack;

public class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        //stack isEmpty
        int[] ints = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ints[i++] = stack.pop();
        }
        return ints;
    }

    //todo 100%
    public int[] reversePrint2(ListNode head) {
        ListNode node = head;
        int i = 0;
        while (node != null) {
            node = node.next;
            i++;
        }
        int[] ints = new int[i];
        node = head;
        for (int j = i - 1; j >= 0; j--) {
            ints[j] = node.val;
            node = node.next;
        }
        return ints;
    }
}
