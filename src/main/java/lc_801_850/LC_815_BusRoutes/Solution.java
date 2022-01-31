package lc_801_850.LC_815_BusRoutes;

import java.util.*;

class Solution {
    // Time: O(E), E: total no.of edges in the graph
    // Space: O(N + E)
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // Collect the bus stops in the same route
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            for(int stop : routes[i]) {
                map.putIfAbsent(stop, new HashSet<>());
                map.get(stop).add(i);
            }
        }

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{source, 0});

        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedRoutes = new HashSet<>();
        visitedStops.add(source);

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            int curstop = cur[0];
            if (curstop == target) return cur[1];

            for(int nroute : map.get(curstop)) {
                if (visitedRoutes.contains(nroute)) continue;

                for (int nstop : routes[nroute]) {
                    if (!visitedStops.contains(nstop)) {
                        deque.offer(new int[]{nstop, cur[1] + 1});
                        visitedStops.add(nstop);  // mark cur bus stop
                    }
                }
                visitedRoutes.add(nroute);  // here, done with whole route, mark it
            }
        }
        return -1;
    }
}