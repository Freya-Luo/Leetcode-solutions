package lc_1151_1200.LC_1199_BinaryTreeRightSideView;
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
    private List<Integer> rightNodes = new ArrayList<>();
    private int size = 0;
    // Time: O(N); Space: O(H): H: tree height
    private void helper(TreeNode root, int curDepth) {
        if (root == null) return;

        if (size == curDepth) { // each level only needs 1 node, and since we do right 1st, so only adding the right-most one
            rightNodes.add(root.val);
            size += 1;
        }

        helper(root.right, curDepth + 1);
        helper(root.left, curDepth + 1);

    }

    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return rightNodes;
    }
}