package lc_1301_1350.LC_1334_FindTheCityWithTheSmallestNumberOfNeighborsAtThresholdDistance;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution_Dijkstra {
    // Time: 0(ElogV) for i-the node using Dijkstra, here E: total number of edges
    // => total `V-1` times, 0(V * ElogV)
    // => however, E in worst case could be n*(n-1)/2 given by description
    // => O(V^3*logV)
    // Space: O(V + E)
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for(int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }

        int minCnt = n, minNode = n;
        for(int i = 0; i < n; i++) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
            boolean[] seen = new boolean[n];
            pq.offer(new int[]{i, 0});

            int cnt = -1;
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int curnode = cur[0], curdist = cur[1];

                if (seen[curnode] || curdist > distanceThreshold ) continue;

                seen[curnode] = true;
                cnt++;
                for(int[] next : graph[curnode]) {
                    if (!seen[next[0]]) {
                        pq.offer(new int[]{next[0], curdist + next[1]});
                    }
                }
            }

            if (cnt <= minCnt) {
                if (cnt == minCnt) {
                    minNode = Math.max(minNode, i);
                } else {
                    minNode = i;
                }
                minCnt = cnt;
            }
        }
        return minNode;
    }
}