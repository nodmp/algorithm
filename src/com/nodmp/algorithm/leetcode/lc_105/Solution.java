package com.nodmp.algorithm.leetcode.lc_105;

import com.nodmp.algorithm.common.TreeNode;

import java.util.HashMap;

/**
 * 前序遍历 preorder = [3,9,20,15,7]
 *                    0 1  2  3 4
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //创建
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, hashMap);

    }

    public TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, HashMap<Integer, Integer> map) {
        if (ps > pe || is > ie) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[ps]);
        int root = map.get(treeNode.val); //
        int i = root - is;
        treeNode.left = buildTree(preorder, ps + 1, ps + i, inorder, is, root - 1, map);
        treeNode.right = buildTree(preorder, ps + i + 1, pe, inorder, root + 1, ie, map);
        return treeNode;
    }

}
