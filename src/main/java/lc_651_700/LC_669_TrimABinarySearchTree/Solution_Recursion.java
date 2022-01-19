package lc_651_700.LC_669_TrimABinarySearchTree;

class Solution_Recursion {
    // Time: O(n), worst case: need to search all nodes
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return root;

        if (root.val < low) return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);

        // Now, root val is in the range [low, high]
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
