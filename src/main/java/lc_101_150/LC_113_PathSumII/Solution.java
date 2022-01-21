package lc_101_150.LC_113_PathSumII;

import java.util.ArrayList;
import java.util.List;

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
    // Time: O(n)
    private void dfs(TreeNode root, int sum, int target, List<Integer> path, List<List<Integer>> res) {
        if (root == null) return;

        path.add(root.val);

        if (root.left == null & root.right == null && sum + root.val == target) {
            res.add(new ArrayList<>(path));  // Keep in mind => always add a copy of the path!
        } else {
            dfs(root.left, sum + root.val, target, path, res);
            dfs(root.right, sum + root.val, target, path, res);
        }

        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, targetSum, new ArrayList<>(), res);
        return res;
    }
}