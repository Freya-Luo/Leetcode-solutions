package lc_751_800.LC_787_CheapestFlightsWithinKStops;

import java.util.*;

class Solution_Dijkstra {
    // Time: O((V + E) * logV) : (V + E): total no.of poll() & offer() operations before K levels
    // Space: O(n)
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] flight : flights) {
            map.putIfAbsent(flight[0], new ArrayList<>());
            map.get(flight[0]).add(new int[]{flight[1], flight[2]});  // <des, cost>
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0, 0}); //<curnode, dist, level>


        int[] cost = new int[n];
        int[] stop = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        Arrays.fill(stop, n);

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int curnode = cur[0], curcost = cur[1], curstop = cur[2];

            if (curnode == dst) {
                return curcost;
            }

            if (curstop > k) continue; // when it reaches k + 1, no more stop this route can have

            if (!map.containsKey(curnode)) continue;
            for (int[] next: map.get(curnode)) {
                // System.out.println("(" + next[0] +"," + (curcost + next[1])+"," +(curstop + 1) + ")");
                if (curcost + next[1] < cost[next[0]]) {
                    pq.offer(new int[]{next[0], curcost + next[1], curstop + 1});
                    cost[next[0]] = curcost + next[1];
                } else if (curstop + 1 < stop[next[0]]) {
                    pq.offer(new int[]{next[0], curcost + next[1], curstop + 1});
                }
                stop[next[0]] = curstop + 1;
            }
        }

        return  -1;
    }
}
