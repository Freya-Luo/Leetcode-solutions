package lc_951_1000.LC_987_VerticalOrderTraversalOfABinaryTree;


import java.util.*;

// Time: O(k * (N/k) * log (N/k) + N)
// N: BFS - no.of nodes; k: col number; (N/k): avg nodes in each col
// => O(N *log(N/k) + N)
// Space: O(N)
class Solution_BFS {

    private class Node {
        TreeNode node;
        int x;
        int y;

        Node (TreeNode n, int x, int y) {
            this.node = n;
            this.x = x;
            this.y = y;
        }
    }

    class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1] == 0 ? o1[0] - o2[0] : o1[1] - o2[1] ;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // BFS construct (x, y) of each node
        Deque<Node> dq = new LinkedList<>();
        Map<Integer, List<int[]>> store = new HashMap<>();

        dq.offer(new Node(root, 0, 0));
        store.put(0, new ArrayList<>());
        store.get(0).add(new int[]{root.val, 0});

        int minCol = 0, maxCol = 0;
        while (!dq.isEmpty()) {
            Node cur = dq.poll();
            TreeNode node = cur.node;
            int col = cur.x;
            int row = cur.y;

            if (node.left != null) {
                dq.offer(new Node(node.left, col - 1, row + 1));
                store.putIfAbsent(col - 1, new ArrayList<>());
                store.get(col - 1).add(new int[]{node.left.val, row + 1});

                minCol = Math.min(minCol, col - 1);
            }

            if (node.right != null) {
                dq.offer(new Node(node.right, col + 1, row + 1));
                store.putIfAbsent(col + 1, new ArrayList<>());
                store.get(col + 1).add(new int[]{node.right.val, row + 1});

                maxCol = Math.max(maxCol, col + 1);
            }
        }


        List<List<Integer>> res = new LinkedList<>();
        for(int i = minCol; i <= maxCol; i++) {
            List<Integer> col = new LinkedList<>();

            List<int[]> nodes = store.get(i);
            Collections.sort(nodes, new MyComparator());
            for(int[] node : nodes) {
                col.add(node[0]);
            }
            res.add(col);
        }
        return res;
    }
}