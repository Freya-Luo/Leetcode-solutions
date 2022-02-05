package lc_851_900.LC_882_ReachableNodesInSubdividedGraph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution_DirectThinking {
    // Time: O(ElogN): E:length of the edges
    // Space: O(E)
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        Map<Integer, Map<Integer, Integer>> adjList = new HashMap<>();
        for(int[] e: edges) {
            adjList.putIfAbsent(e[0], new HashMap<>());
            adjList.putIfAbsent(e[1], new HashMap<>());
            adjList.get(e[0]).put(e[1], e[2]);
            adjList.get(e[1]).put(e[0], e[2]);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0}); // curnode, curdist
        Map<String, Integer> edgeCnt = new HashMap<>(); // how many times the edge has been used

        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int curnode = cur[0], curdist = cur[1];

            if (dist[curnode] != -1) continue;
            dist[curnode] = curdist; // mark as DONE, curdist is the shortest for curnode
            res++;

            if(!adjList.containsKey(curnode)) continue;
            for(int ni : adjList.get(curnode).keySet()) {
                int w = adjList.get(curnode).get(ni);
                String edgeSym = "" + curnode + "," + ni;  // edge symbol for counting the used time
                edgeCnt.put(edgeSym, Math.min(w, maxMoves - curdist));  // min distance this node can reach on this edge

                int distFromSrc = curdist + w + 1;
                if (dist[ni] == -1 && distFromSrc <= maxMoves) {
                    pq.offer(new int[]{ni, distFromSrc});
                }
            }
        }

        for(int[] e : edges) {
            String sym1 = "" + e[0] + "," + e[1], sym2 = "" + e[1] + "," + e[0];
            int cntFromN1 = edgeCnt.getOrDefault(sym1, 0);
            int cntFromN2 = edgeCnt.getOrDefault(sym2, 0);
            res += Math.min(e[2], cntFromN1 + cntFromN2);
        }
        return res;
    }
}