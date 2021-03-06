package com.nodmp.algorithm.lcof.lcof_07;

import com.nodmp.algorithm.common.TreeNode;

import java.util.HashMap;

/**
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, hashMap);
    }

    ///创建
    public TreeNode buildTree(int[] preorder, int[] inorder, int ps, int pe, int is, int ie, HashMap<Integer, Integer> hashMap) {
        if (ps > pe || is > ie) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[ps]);
        int i = hashMap.get(preorder[ps]);
        treeNode.left = buildTree(preorder, inorder, ps + 1, ps + i - is, is, i - 1, hashMap);
        treeNode.right = buildTree(preorder, inorder, ps + i - is + 1, pe, i + 1, ie, hashMap);
        return treeNode;
    }

}
