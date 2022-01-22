package lc_401_450.LC_437_PathSumIII;

import java.util.HashMap;
import java.util.Map;

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

    private int dfsPresum(TreeNode root, int curSum, int target, Map<Integer, Integer> store) {
        if (root == null) return 0;

        int res = 0;

        curSum += root.val;
        // case 1: if curSum is already equal to the targetSum, just add this combination
        if (curSum == target) res += 1;
        // case 2: if "curSum - target" exists, add the occurrence of this starting point
        res += store.getOrDefault(curSum - target, 0);

        // This has to be put behind the above 2 cases in case of "target == 0"
        // then, curSum would be counted as target
        // ex: [1], target = 0
        store.put(curSum, store.getOrDefault(curSum, 0) + 1);

        res += dfsPresum(root.left, curSum, target, store);
        res += dfsPresum(root.right, curSum, target, store);

        store.put(curSum, store.get(curSum) - 1);
        return res;
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> store = new HashMap<>();
        /** Another way for case 1: store.put(0, 1);
         * Then, above cases could be merged. */
        return dfsPresum(root, 0, targetSum, store);
    }
}