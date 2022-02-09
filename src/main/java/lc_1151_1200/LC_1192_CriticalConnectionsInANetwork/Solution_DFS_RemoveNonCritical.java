package lc_1151_1200.LC_1192_CriticalConnectionsInANetwork;

import java.util.*;

class Solution_DFS_RemoveNonCritical {
    private List<List<Integer>> res = new ArrayList<>();
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    private int dfs(int cur, int parent, int curdist, int[] lowdist, Set<List<Integer>> criticals) {
        if (lowdist[cur] >= 0) return lowdist[cur];
        lowdist[cur] = curdist;

        int min = curdist;
        for(int next : graph.get(cur)) {
            if (next == parent) continue;
            int minDistFromChildren = dfs(next, cur, curdist + 1, lowdist, criticals);
            if (minDistFromChildren <= curdist) {
                criticals.remove(Arrays.asList(cur, next));
                criticals.remove(Arrays.asList(next, cur));
            }
            min = Math.min(min, minDistFromChildren);
        }
        return min;
    }

    // Time: O(V + E)
    // Space: O(E)
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        for(List<Integer> conn : connections) {  // build the graph
            int from = conn.get(0), to = conn.get(1);
            graph.putIfAbsent(from, new LinkedList<>());
            graph.putIfAbsent(to, new LinkedList<>());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        Set<List<Integer>> criticals = new HashSet<>(connections);
        int[] lowdist = new int[n];
        Arrays.fill(lowdist, -1);

        dfs(0, -1, 0, lowdist, criticals);
        return new ArrayList<>(criticals);
    }
}
