package LC_1135_ConnectingCitiesWithMinimumCost;

import java.util.Arrays;

class Solution_UF_PathComp_Weighted {
    // Smaller rank set append to the larger rank set

    /**
     * Time: O(MlogM + M * log^* N), M: connections.length
     * => Union Find: log^* N for each edge; Typically, log^* N <= 5;
     * (with path compression & link-by-rank)
     * Space: O(N)
     */
    class UF {
        private int[] parents;
        private int[] size;

        public UF(int n) {
            this.parents = new int[n + 1];
            this.size = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                this.parents[i] = -1;  // Or i, both fine
                this.size[i] = 1;
            }
        }

        public int findRoot(int x) {
            if (this.parents[x] != -1) {
                this.parents[x] = findRoot(this.parents[x]);
                return this.parents[x];
            }
            return x;
        }

        public void union(int x, int y) {  // link-by-rank
            int smallerSet = this.size[x] <= this.size[y] ? x : y;
            int largerSet = smallerSet == x ? y : x;
            this.parents[smallerSet] = largerSet;
            this.size[largerSet] += this.size[smallerSet];
        }
    }
    /** -------------------- Below part basically same ----------------------
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
    }*/
}
