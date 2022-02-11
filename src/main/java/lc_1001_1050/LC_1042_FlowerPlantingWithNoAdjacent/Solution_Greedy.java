package lc_1001_1050.LC_1042_FlowerPlantingWithNoAdjacent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_Greedy {
    // Time : O(N)
    // Space: O(N)
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] types = new int[n + 1];

        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 1; i <=n ; i++) graph[i] = new ArrayList<>();
        for(int[] path: paths) {
            graph[path[0]].add(path[1]);
            graph[path[1]].add(path[0]);
        }

        for (int i = 1; i <= n; i++) {
            boolean[] used = new boolean[5];
            for(int next: graph[i]) {
                used[types[next]] = true;
            }
            for(int j = 1; j < 5; j++) {
                if (!used[j]) types[i] = j;
            }

        }
        return Arrays.copyOfRange(types, 1, types.length);
    }
}
