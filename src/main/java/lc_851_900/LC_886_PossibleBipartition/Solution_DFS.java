package lc_851_900.LC_886_PossibleBipartition;

import java.util.ArrayList;
import java.util.List;

class Solution_DFS {
    private boolean dfs(List<Integer>[] graph, int cur, int[] groups, int group) {
        if (groups[cur] != 0) {
            return groups[cur] == group;
        }

        groups[cur] = group;
        for(int next: graph[cur]) {
            // or if (groups[next] == group) return false; & get rid of the above checking
            if (!dfs(graph, next, groups, -group)) {
                return false;
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for(int[] path: dislikes) {
            graph[path[0]].add(path[1]);
            graph[path[1]].add(path[0]);
        }

        int[] groups = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            if (groups[i] == 0 && !dfs(graph, i, groups, 1)) return false;
        }
        return true;
    }
}
