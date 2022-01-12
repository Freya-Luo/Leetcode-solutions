package LC_863_AllNodesDistanceKInBinaryTree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    /**
     * Time: O(N) - N : no.of nodes
     * Space: O(N)
     */
    private Map<Integer, Integer> distance = new HashMap<>();
    private List<Integer> res = new ArrayList<>();

    private int findTarget(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            distance.put(target.val, 0);
            return 0;
        }

        int leftDis = findTarget(root.left, target);
        if (leftDis != -1) {
            distance.put(root.val, leftDis + 1);
            return leftDis + 1;
        }

        int rightDis = findTarget(root.right, target);
        if (rightDis != -1) {
            distance.put(root.val, rightDis + 1);
            return rightDis + 1;
        }
        return -1;
    }

    private void dfs(TreeNode root, int k, int dist) {
        if (root == null) return;
        // Modify the dist info if the it was pre-configured in distance map
        if (distance.containsKey(root.val)) {
            dist = distance.get(root.val);
        }
        if (dist == k) {
            res.add(root.val);
        }
        dfs(root.left, k, dist + 1);
        dfs(root.right, k, dist + 1);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        findTarget(root, target);
        dfs(root, k, distance.get(root.val));
        return res;
    }
}