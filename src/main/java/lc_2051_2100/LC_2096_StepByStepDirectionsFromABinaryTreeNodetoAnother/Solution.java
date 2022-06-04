package lc_2051_2100.LC_2096_StepByStepDirectionsFromABinaryTreeNodetoAnother;

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

/**
 * First, need to find the lowest common ancestor (LCA) of the src and des nodes.
 *   which should be the shortest path between 2 nodes.
 * Second, DFS w/ backtracking to find the path between 2 nodes.
 *   1) LCA -> src; BUT later changes all these to "U" as we need src -> LCA
 *   2) LCA -> des
 *   3) src -> LCA -> des
 */
class Solution {
    // O(N)
    private TreeNode findLCA(TreeNode root, int src, int des) {
        if (root == null || root.val == src || root.val == des) return root;

        TreeNode left = findLCA(root.left, src, des);
        TreeNode right = findLCA(root.right, src, des);

        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
    // O(N)
    private boolean findPath(TreeNode node, int val, StringBuilder sb) {
        if (node == null) return false;
        if (node.val == val) return true;

        sb.append("L");
        if (findPath(node.left, val, sb)) return true;
        sb.setCharAt(sb.length() - 1, 'R');
        if (findPath(node.right, val, sb)) return true;
        sb.deleteCharAt(sb.length() - 1);
        return false;
    }


    public String getDirections(TreeNode root, int src, int des) {
        TreeNode LCA = findLCA(root, src, des);

        // find path from src to LCA, LCA to des
        StringBuilder s2lca = new StringBuilder();
        StringBuilder lca2d = new StringBuilder();

        findPath(LCA, src, s2lca);
        findPath(LCA, des, lca2d);

        String dir = "U";
        String src2lca = dir.repeat(s2lca.length()); // O(N)
        return src2lca + lca2d.toString(); // O(N)
    }
}
