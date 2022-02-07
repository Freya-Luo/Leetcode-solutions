package lc_301_350.LC_332_ReconstructItinerary;

import java.util.*;

class Solution_DFS {
    private List<String> res = new ArrayList<>();
    private int usedTickets = 0;

    private void dfs(Map<String, List<String>> adjList, String cur, int N) {
        if (!adjList.containsKey(cur)) return;

        List<String> neighbors = adjList.get(cur);
        // remove & add: O(2 * k^2)
        for(int i = 0; i < neighbors.size(); i++) {
            String next = neighbors.get(i);

            usedTickets++;   // put the logic inside the for loop to count the E instead of V
            res.add(next);
            neighbors.remove(i);

            dfs(adjList, next, N);

            if (usedTickets == N) return;
            neighbors.add(i, next);
            res.remove(res.size() - 1);
            usedTickets--;
        }
    }
    // Time: O(k^E + V * klogk + k^2) -- : k: max-outdegree of a V
    // k^E: for each flight, one can have k choices: T(E) = k * T(E - 1) => not V, since directed graph
    // Space: O(V + E)
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adjList = new HashMap<>();
        for(List<String> t : tickets) {
            adjList.putIfAbsent(t.get(0), new ArrayList<>());
            adjList.get(t.get(0)).add(t.get(1));
        }
        // sort the searching outgoing edges
        for(String from: adjList.keySet()) {
            Collections.sort(adjList.get(from));  // O (V * klogk)
        }

        res.add("JFK");
        dfs(adjList, "JFK", tickets.size());
        return res;
    }
}
