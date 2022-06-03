package lc_151_200.LC_173_BinarySearchTreeIterator;

import java.util.ArrayList;

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

class BSTIterator {

    private ArrayList<Integer> order = new ArrayList<>(); // [val, 1: true/ 0: false]
    private int curIdx = 0;

    private void traversal(TreeNode root) {
        if (root == null) return;

        traversal(root.left);
        // in-order
        order.add(root.val);
        traversal(root.right);
    }
    // O(N)
    public BSTIterator(TreeNode root) {
        traversal(root);
    }
    // O(1)
    public int next() {
        int val = order.get(curIdx);
        curIdx += 1;
        return val;
    }
    // O(1)
    public boolean hasNext() {
        return curIdx < order.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */