package lc_751_800.LC_787_CheapestFlightsWithinKStops;

import java.util.Arrays;

class Solution_BellmanFord {
    // Time: O(k*E) E - no.of edges
    // Space: O(n)
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        for(int iter = 1; iter <= k + 1; iter++) {
            int[] temp = Arrays.copyOf(cost, n);

            for(int[] flight : flights) {
                int from = flight[0], to = flight[1], price = flight[2];
                // choose the node in this iteration that can be reached
                if (cost[from] == Integer.MAX_VALUE) continue;

                if (cost[from] + price < temp[to]) {
                    temp[to] = cost[from] + price;
                }
            }
            cost = temp;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

}
