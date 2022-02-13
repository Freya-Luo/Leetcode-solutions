package lc_701_750.LC_743_NetworkDelayTime;

import java.util.*;

class Solution {
    // Dijkstra algo: find the shortest path for covering all nodes
    public int networkDelayTime(int[][] times, int n, int k) {
        // <from, list of to>
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new ArrayList<>());
            map.get(time[0]).add(new int[]{time[1], time[2]});
        }
        if (!map.containsKey(k)) return -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});  // curNode, minTime

        Set<Integer> seen = new HashSet<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curnode = cur[0], curdist = cur[1];

            if (seen.contains(curnode)) continue;
            seen.add(curnode);
            res = curdist;

            if (!map.containsKey(curnode)) continue;
            for(int[] next: map.get(curnode)) {
                if (curdist + next[1] < dist[next[0]]) {
                    pq.offer(new int[]{next[0], curdist + next[1]});
                    dist[next[0]] = curdist + next[1];
                }
            }

        }
        return seen.size() == n ? res : -1;
    }
}