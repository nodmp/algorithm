package com.nodmp.algorithm.leetcode.lc_2;

import com.nodmp.algorithm.common.ListNode;

import java.util.List;

//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学
// 👍 4810 👎 0
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode head = node;
        int count = 0;
        while (l1 != null || l2 != null || count != 0) {
            int total;
            if (l1 == null && l2 == null) {
                total = count;
            } else if (l1 == null) {
                //l1 == null
                total = l2.val + count;
                l2 = l2.next;
            } else if (l2 == null) {
                //l2 == null
                total = l1.val + count;
                l1 = l1.next;
            } else {
                //l1 l2 都不是null
                total = l1.val + l2.val + count;
                l1 = l1.next;
                l2 = l2.next;
            }
            node.next = new ListNode(total % 10);
            count = total / 10;
            node = node.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new Solution().addTwoNumbers(node1, node2);
        System.out.println(node3);

    }
}
