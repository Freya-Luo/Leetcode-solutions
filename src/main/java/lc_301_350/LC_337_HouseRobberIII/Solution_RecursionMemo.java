package lc_301_350.LC_337_HouseRobberIII;

import java.util.HashMap;
import java.util.Map;

class Solution_RecursionMemo {
    // Time: O(n); Space: O(n)
    private Map<TreeNode, Integer> map = new HashMap<>();

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        if (map.containsKey(root)) {
            return map.get(root);
        }
        // case 1: choose current node value
        int res = 0;
        if (root.left != null) res += dfs(root.left.left) + dfs(root.left.right);
        if (root.right != null) res += dfs(root.right.left) + dfs(root.right.right);
        int sum1 = root.val + res;

        // case 2: not choose current node
        int sum2 = dfs(root.left) + dfs(root.right);

        int max = Math.max(sum1, sum2);
        map.put(root, max);

        return max;
    }
    public int rob(TreeNode root) {
        return dfs(root);
    }
}
