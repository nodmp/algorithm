package com.nodmp.algorithm.leetcode.lc_124;

import com.nodmp.algorithm.common.TreeNode;

public class Solution {
    int COUNT = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //
        max(root);
        return COUNT;
    }

    public int max(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, max(root.left));
        int right = Math.max(0, max(root.right));
        COUNT = Math.max(COUNT, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
