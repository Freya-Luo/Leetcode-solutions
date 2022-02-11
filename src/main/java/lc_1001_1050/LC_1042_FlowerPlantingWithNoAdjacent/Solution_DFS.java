package lc_1001_1050.LC_1042_FlowerPlantingWithNoAdjacent;

import java.util.*;

class Solution_DFS {
    private int[] colors = {1, 2, 3, 4};

    private boolean dfs(List<Integer>[] graph , int[] types, int cur, Set<Integer> set) {
        // if (set.size() == types.length - 1) return true; // this can be deleted, no necessary, cuz DFS is close to tail recursion
        // set the current node's type based on the constraints
        for (int i = 1; i <= 4; i++) {
            boolean canSet = true;
            for (int ni: graph[cur]) {
                if (types[ni] == i){
                    canSet = false;
                    break;
                }
            }
            if (!canSet) continue;
            types[cur] = i;
            // set.add(cur);
            break;
        }

        for (int ni: graph[cur]) {
            if (types[ni] == 0 && !dfs(graph, types, ni, set)) {
                types[cur] = 0;  // not go inside this loop => cuz it's guaranteed to have an answer
                // set.remove(cur);
                return false;
            }
        }
        return true;
    }
    // Time: O(N) - Given the constraints, backtracking actually will not execute
    // Space: O(N)
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] types = new int[n + 1];
        List<Integer>[] graph = new ArrayList[n + 1];
        Set<Integer> set = new HashSet<>();
        // !!!Note: CANNOT do Arrays.fill(graph, new ArrayList<>()) => share only 1 reference
        for(int i = 1; i <=n ; i++) graph[i] = new ArrayList<>();
        for(int[] path: paths) {
            graph[path[0]].add(path[1]);
            graph[path[1]].add(path[0]);
        }

        for (int i = 1; i <= n; i++) {
            if (types[i] == 0 && !dfs(graph, types, i, set)){
                return new int[]{0};
            }
        }
        return Arrays.copyOfRange(types, 1, types.length);
    }
}