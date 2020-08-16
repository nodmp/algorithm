package com.nodmp.algorithm.lcof.lcof_18;

import com.nodmp.algorithm.common.ListNode;

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode node = head.next;
        while (node != null) {
            if (node.val == val) {
                pre.next = node.next;
                break;
            } else {
                pre = node;
                node = node.next;
            }
        }
        return head;
    }
}
