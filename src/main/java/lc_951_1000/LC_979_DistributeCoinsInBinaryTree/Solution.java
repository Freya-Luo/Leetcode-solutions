package lc_951_1000.LC_979_DistributeCoinsInBinaryTree;


public class Solution {
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

    private int minMoves = 0;

    private int dfs(TreeNode root) {
        if (root == null) return -100;

        int left = dfs(root.left);
        int right = dfs(root.right);

        int coins = root.val;
        if (left != -100 && left != 1) {
            coins += left - 1;
            minMoves += Math.abs(left - 1);
        }
        if (right != -100 && right != 1) {
            coins += right - 1;
            minMoves += Math.abs(right - 1);
        }
        return coins;
    }
     private int dfs2(TreeNode node) {
         if (node == null) return 0;

         int left = dfs2(node.left);
         int right = dfs2(node.right);

         minMoves += Math.abs(left) + Math.abs(right);
         return node.val + left + right - 1;
     }

    // Greedy: Always choose the closest node to move in and out
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return minMoves;
    }
}
