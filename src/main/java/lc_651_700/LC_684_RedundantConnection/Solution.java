package lc_651_700.LC_684_RedundantConnection;

import java.util.Arrays;

class Solution {
    private int find(int x, int[] parents) {
        if (parents[x] == -1) return x;
        return parents[x] = find(parents[x], parents);
    }
    // Time complexity: O(N α(N)) ~ O(N)
    // Space: O(N)
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1];

        Arrays.fill(parents, -1);
        for(int [] edge : edges) {
            int px = find(edge[0], parents);
            int py = find(edge[1], parents);

            if (px == py && px != -1) {
                return edge;
            }
            parents[px] = py;
        }
        return new int[0];
    }
}