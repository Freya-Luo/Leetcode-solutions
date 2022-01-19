package lc_651_700.LC_669_TrimABinarySearchTree;

class Solution_Iteration {
    // Time: O(n)
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return root;

        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low) {
                root = root.right;
            } else if (root.val > high) {
                root = root.left;
            }

        }

        TreeNode nextLeft = root;
        while (nextLeft != null) {
            while (nextLeft.left != null && nextLeft.left.val < low) {
                nextLeft.left = nextLeft.left.right;
            }
            nextLeft = nextLeft.left;
        }

        TreeNode nextRight = root;
        while (nextRight != null) {
            while (nextRight.right != null && nextRight.right.val > high) {
                nextRight.right = nextRight.right.left;
            }
            nextRight = nextRight.right;
        }

        return root;
    }
}
