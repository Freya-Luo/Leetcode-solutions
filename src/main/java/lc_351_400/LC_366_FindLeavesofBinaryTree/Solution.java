package lc_351_400.LC_366_FindLeavesofBinaryTree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    // O(N)
    private int height(TreeNode root) {
        if (root == null) return -1;

        int curHeight = Math.max(height(root.left), height(root.right)) + 1;
        if (curHeight + 1 > res.size()) { // determine when to add a new level
            res.add(curHeight, new ArrayList<>());
        }
        res.get(curHeight).add(root.val);
        return curHeight;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        height(root);
        return res;
    }
}