package lc_801_850.LC_802_FindEventualSafeStates;

import java.util.ArrayList;
import java.util.List;

class Solution_DFS {
    // Time: O(N + E)
    // Space: O(N)
    private boolean dfs(int[][] graph, int cur, int[] status) {
        if (status[cur] != 0) return status[cur] == 2;

        status[cur] = 1;  // gray: entry

        for(int next: graph[cur]) {
            if (status[next] == 2)  // black: exit
                continue;

            if (status[next] == 1 || !dfs(graph, next, status))  // see gray again: cycle!
                return false;
        }
        status[cur] = 2;  // black: exit
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int[] status = new int[n]; // 0: unvisited, 1: visited & unsafe, 2: safe
            if (status[i] == 0) {
                if(dfs(graph, i, status)) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}
