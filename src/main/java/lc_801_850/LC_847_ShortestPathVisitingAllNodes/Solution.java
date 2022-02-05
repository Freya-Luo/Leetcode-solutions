package lc_801_850.LC_847_ShortestPathVisitingAllNodes;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private class Node {
        int curBitmask;
        int val;
        int dist;

        Node(int val, int dist, int curBitmask) {
            this.val = val;
            this.dist = dist;
            this.curBitmask = curBitmask;
        }

        @Override
        public boolean equals(Object obj) {
            Node node = (Node) obj;
            return node.curBitmask == this.curBitmask && node.val == this.val;
        }

        @Override
        public int hashCode() {
            return val * 31 + curBitmask;  // unique number generated for 2 ints
        }
    }
    public int shortestPathLength(int[][] graph) {
        // Encoding each node to a specifc status
        int n  = graph.length;
        Deque<Node> deque = new ArrayDeque<>();
        Set<Node> seen = new HashSet<>();

        for(int i = 0; i < n; i++) {
            int pos = 1 << i; // nodeIdx + 1 = i
            Node node = new Node(i, 0, pos);
            deque.offer(node);
            seen.add(node);
        }

        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            if (cur.curBitmask == ((1 << n) - 1)) {
                return cur.dist;
            }

            for(int ni : graph[cur.val]) {
                int nextBitmask = cur.curBitmask | (1 << ni);
                Node nextNode = new Node(ni, cur.dist + 1, nextBitmask);

                if (!seen.contains(nextNode)) {
                    deque.offer(nextNode);
                    seen.add(nextNode);
                }
            }

        }
        return -1;
    }
}
