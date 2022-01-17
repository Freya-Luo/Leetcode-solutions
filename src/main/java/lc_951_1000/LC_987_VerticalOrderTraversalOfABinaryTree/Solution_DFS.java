package lc_951_1000.LC_987_VerticalOrderTraversalOfABinaryTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// Time: O(NlogN + N)
// Space: O(N)
class Solution_DFS {
    private class Triplet {
        int val;
        int x;
        int y;

        Triplet (int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
    // Single PQ dealing with all the relations of node's row & col
    private PriorityQueue<Triplet> pq = new PriorityQueue<>(new Comparator<Triplet>() {
        @Override
        public int compare(Triplet o1, Triplet o2) {
            if (o1.x != o2.x) {
                return o1.x - o2.x;
            } else {
                return o1.y - o2.y == 0 ? o1.val - o2.val : o1.y - o2.y;
            }
        }
    });


    private void dfs(TreeNode node, int x, int y) {
        if (node == null) return;
        pq.offer(new Triplet(node.val, x, y));

        dfs(node.left, x - 1, y + 1);
        dfs(node.right, x + 1, y + 1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(root, 0, 0);

        Triplet prev = new Triplet(-1, -1000, -1000);
        List<Integer> nodes = new ArrayList<>();

        while(!pq.isEmpty()){
            Triplet cur = pq.poll();

            if (cur.x != prev.x){
                if(prev.val != -1) {
                    res.add(nodes);
                }
                nodes = new ArrayList<>();
            }

            nodes.add(cur.val);
            prev = cur;
        }

        res.add(nodes);
        return res;
    }
}
