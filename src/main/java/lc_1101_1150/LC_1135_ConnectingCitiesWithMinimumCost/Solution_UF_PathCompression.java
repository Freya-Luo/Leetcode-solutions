package lc_1101_1150.LC_1135_ConnectingCitiesWithMinimumCost;

import java.util.Arrays;

class Solution_UF_PathCompression {
    /**
     * Time: O(MlogM + M * logN), M: connections.length
     * => Union Find: log^ N for each edge (with path compression)
     * Space: O(N)
     */
    class UF {
        private int[] parents;

        public UF(int n) {
            this.parents = new int[n + 1];
            // Need to fill with its value, not -1
            for(int i = 1; i <= n; i++) {
                this.parents[i] = i;
            }
        }

        public int findRoot(int x) {
            if (this.parents[x] != x) {
                return findRoot(this.parents[x]);
            }
            return x;
        }

        public void union(int x, int y) {
            for(int i = 0; i < this.parents.length; i++) {
                if (this.parents[i] == x)
                    this.parents[i] = y;
            }
            this.parents[x] = y;
        }
    }
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        UF uf = new UF(n);

        int res = 0;
        int edgeNum = 0;
        for(int[] edgeInfo : connections) {
            int srcP = uf.findRoot(edgeInfo[0]);
            int desP = uf.findRoot(edgeInfo[1]);

            if (srcP == desP) continue;

            uf.union(srcP, desP);
            res += edgeInfo[2];
            edgeNum++;
        }
        return edgeNum == n - 1 ? res : -1;
    }
}
