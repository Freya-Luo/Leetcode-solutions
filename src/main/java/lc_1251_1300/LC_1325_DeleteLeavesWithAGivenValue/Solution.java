package lc_1251_1300.LC_1325_DeleteLeavesWithAGivenValue;

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

    /**
     * Key: check if a node is a lead node with targeted value
     * should behind the recursion
     * => must do post-order, as once leaf nodes are removed,
     * the above level would be leaf nodes then
     * (upper level is determined by the lower level, deal with lower ones 1st)
     */
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return root;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;
    }
}