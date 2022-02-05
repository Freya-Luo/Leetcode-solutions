package lc_851_900.LC_882_ReachableNodesInSubdividedGraph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution_ReverseThinking {
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
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        pq.offer(new int[]{0, maxMoves}); // curnode, distleft

        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int curnode = cur[0], distleft = cur[1];

            if (dist[curnode] != -1) continue;
            dist[curnode] = distleft;
            res++;

            if(!adjList.containsKey(curnode)) continue;
            for(int ni : adjList.get(curnode).keySet()) {
                int w = adjList.get(curnode).get(ni);

                int distLeftNi= distleft - (w + 1);
                if (dist[ni] == -1 && distLeftNi >= 0) {
                    pq.offer(new int[]{ni, distLeftNi});
                }
            }
        }

        for(int[] e : edges) {
            int distSpawnFromN1 = dist[e[0]] == -1 ? 0 : dist[e[0]];
            int distSpawnFromN2 = dist[e[1]] == -1 ? 0 : dist[e[1]];
            res += Math.min(e[2], distSpawnFromN1 + distSpawnFromN2);
        }
        return res;
    }
}