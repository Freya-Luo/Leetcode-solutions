package lc_301_350.LC_337_HouseRobberIII;

class Solution_Recursion {
    // Time: O(n); Space: O(n)
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // case 1: choose current node value
        int sum1 = root.val + left[1] + right[1];
        // case 2: not choose current node
        int sum2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{sum1, sum2};
    }
    public int rob(TreeNode root) {
        // [robRoot, notRobRoot]
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
}
