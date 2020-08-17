package com.nodmp.algorithm.leetcode.lc_110;
//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
//
//
// 示例 1:
//
// 给定二叉树 [3,9,20,null,null,15,7]
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回 true 。
//
//示例 2:
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4]
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//
//
// 返回 false 。
//
//
// Related Topics 树 深度优先搜索
// 👍 411 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.nodmp.algorithm.common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//class Solution {
//    public boolean isBalanced(TreeNode root) {
//        return recur(root) != -1;
//    }
//
//    private int recur(TreeNode root) {
//        if (root == null) return 0;
//        int left = recur(root.left);
//        if(left == -1) return -1;
//        int right = recur(root.right);
//        if(right == -1) return -1;
//        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
//    }
//}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return ph(root) != -1;
    }

    public int ph(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = ph(treeNode.left);
        if (left == -1) {
            return -1;
        }
        int right = ph(treeNode.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right)+1 : -1;
    }

    public TreeNode buildTree() {
        //         8
        //     5      10
        //  2    3  9    18
        //1
        TreeNode head = new TreeNode(8);
        head.left = new TreeNode(5);
        head.right = new TreeNode(10);
        head.left.right = new TreeNode(3);
        head.left.left = new TreeNode(2);
        head.right.right = new TreeNode(18);
        head.right.left = new TreeNode(9);
        return head;
    }


    //8-5-2-3-10-9-18-前序列
    //2-5-3-8-9-10-18-中序列
    //2-3-5-9-18-10-8-后序列
    public void trs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        trs(treeNode.left);
        trs(treeNode.right);
        System.out.print(treeNode.val + "-");
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.trs(solution.buildTree());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
