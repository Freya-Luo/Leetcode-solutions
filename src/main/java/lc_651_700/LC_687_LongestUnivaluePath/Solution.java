package lc_651_700.LC_687_LongestUnivaluePath;

class Solution {
    private class TreeNode {
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

    private int max = 0;

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftLen = dfs(root.left);
        int rightLen = dfs(root.right);

        if (root.left != null) {
            if (root.val == root.left.val) leftLen++; // include this edge
            else leftLen = 0; // not include this edge when looking up
        }

        if (root.right != null) {
            if (root.val == root.right.val) rightLen++;
            else rightLen = 0;
        }

        max =  Math.max(max, leftLen + rightLen); // consider both sides of the current "root"

        return Math.max(leftLen, rightLen);  // continue looking up, then only 1 side can be selected, choose the larger side
    }
    // Time: O(n);
    // Space: O(logn) -- recursive call stack space: height of the tree
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }
}
