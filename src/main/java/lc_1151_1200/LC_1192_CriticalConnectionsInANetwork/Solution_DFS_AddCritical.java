package lc_1151_1200.LC_1192_CriticalConnectionsInANetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_DFS_AddCritical {
    private List<List<Integer>> res = new ArrayList<>();

    private void dfs(List<Integer>[] graph, int cur, int parent, int curdist, int[] lowdist) {
        lowdist[cur] = curdist;

        for(int next : graph[cur]) {
            if (next == parent) continue;
            if (lowdist[next] == -1) dfs(graph, next, cur, curdist + 1, lowdist);

            if (lowdist[next] > curdist) {
                res.add(Arrays.asList(cur, next));
            }
            lowdist[cur] = Math.min(lowdist[cur], lowdist[next]);  // !!! cannot use min(curdist, lowdist[next)
        }
    }

    // Time: O(V + E)
    // Space: O(E)
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for(List<Integer> conn : connections) {  // build the graph
            int from = conn.get(0), to = conn.get(1);
            graph[from].add(to);
            graph[to].add(from);
        }
        // Set<List<Integer>> criticals = new HashSet<>(connections);
        int[] lowdist = new int[n];
        Arrays.fill(lowdist, -1);

        dfs(graph, 0, -1, 0, lowdist);
        return res;
    }
}
