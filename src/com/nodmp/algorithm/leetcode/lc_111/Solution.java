package com.nodmp.algorithm.leetcode.lc_111;
import com.nodmp.algorithm.common.ListNode;
import com.nodmp.algorithm.common.TreeNode;
import com.sun.tools.javac.file.SymbolArchive;

import javax.xml.soap.Node;
import java.util.LinkedList;

//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最小深度 2.
//[3,9,20,null,null,15,7]
class Solution {
    ///////BFS
    /////DFS
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public int mindDepth2(TreeNode root) {
        //////
        if (root == null) {
            return 0;
        }
        ///先进先出队列
        LinkedList<TreeNode> list = new LinkedList<>();
        root.val = 1;
        list.offer(root);
        do {
            TreeNode node = list.poll();
            int index = node.val + 1;
            ///////index/////////////
            if (node.left == null && node.right == null) {
                return node.val;
            }
            if (node.left != null){
                TreeNode left = node.left;
                left.val = index;
                list.offer(left);
            }
            if (node.right != null) {
                TreeNode right = node.right;
                right.val = index;
                list.offer(right);
            }
        } while (list.size() > 0);
        return 0;
    }

}