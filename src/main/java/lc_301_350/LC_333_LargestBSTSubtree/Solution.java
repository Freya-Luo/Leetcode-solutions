package lc_301_350.LC_333_LargestBSTSubtree;

class Solution {
    private int size = 0;

    class Node {
        int min;
        int max;

        Node(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    private Node helper(TreeNode root) {
        if (root == null) {
            return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Node left = helper(root.left);
        Node right = helper(root.right);

        int n = 0;
        if (left.max < root.val && root.val < right.min) {
            n = 1 + left.size + right.size;
            size = Math.max(n, size);
            return new Node(Math.min(left.min, root.val), Math.max(right.max, root.val));
        }

        return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int largestBSTSubtree(TreeNode root) {
        helper(root);
    }
}