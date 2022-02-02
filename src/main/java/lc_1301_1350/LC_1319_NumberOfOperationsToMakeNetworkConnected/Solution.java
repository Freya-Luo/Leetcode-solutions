package lc_1301_1350.LC_1319_NumberOfOperationsToMakeNetworkConnected;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private int find(int x, int[] parents) {
        if (parents[x] == -1) return x;
        return parents[x] = find(parents[x], parents);
    }
    // Count the connected networks
    // Time: O(M): M: connections.length
    // Space: O(N)
    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;
        if (len < n && len != n - 1) return -1;

        int[] parents = new int[len + 1];
        Arrays.fill(parents, -1);


        for(int[] conn : connections)  {
            int pc1 = find(conn[0], parents);
            int pc2 = find(conn[1], parents);

            if (pc1 == pc2) continue;

            parents[pc1] = pc2;
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++)  {
            int pc = find(i, parents);
            set.add(pc);
        }
        return set.size() - 1;
    }
}