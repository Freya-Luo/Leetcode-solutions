package lc_651_700.LC_685_RedundantConnectionII;

import java.util.Arrays;

class Solution {
    // Time: O(N + N*α(N)) = O(N)
    // Space: O(N)
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] possibleE1 = null, possibleE2 = null;
        int[] parents = new int[edges.length + 1];

        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (parents[edge[1]] != 0) {
                possibleE1 = new int[]{parents[edge[1]], edge[1]};
                possibleE2 = new int[]{edge[0], edge[1]};  // current edge
                edge[1] = -1; // invalid node, 1st remove 2nd edge from the graph
            } else {
                parents[edge[1]] = edge[0];
            }
        }

        // reset the parents[] to check if a cycle exists
        Arrays.fill(parents, 0);

        for (int[] edge : edges) {
            int father = edge[0];
            int child = edge[1];

            if (child == -1) continue;  // ignore the above 2nd edge

            int px = find(parents, father);
            int py = find(parents, child);

            if (px == py && px != 0) {  // cycle detected
                if (possibleE1 != null) {  // after remove the 2nd edge, then it should be the 1st edge causing the problem
                    return possibleE1;
                }
                return edge;  // just return the edge making current cycle
            }
            parents[py] = px;
        }
        return possibleE2;
    }


    private int find(int[] parents, int id) {
        if (parents[id] == 0) return id;
        return parents[id] = find(parents, parents[id]);  // path compression
    }

}