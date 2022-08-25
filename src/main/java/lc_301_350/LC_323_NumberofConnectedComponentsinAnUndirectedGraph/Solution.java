package lc_301_350.LC_323_NumberofConnectedComponentsinAnUndirectedGraph;

import java.util.Arrays;

// Time: O(E⋅α(n)); path compression + find by rank
// Space: O(V)
class Solution {
    class UF {
        int[] p; // parents
        int[] s; // size

        UF(int n) {
            p = new int[n];
            s = new int[n];

            for(int i = 0; i < n; i++) {
                p[i] = i;
            }
            Arrays.fill(this.s, 0);
        }

        int find(int x) {
            if (p[x] == x) {
                return p[x];
            }
            return (p[x] = find(p[x]));
        }

        void union(int x, int y) {
            int b = s[x] >= s[y] ? x : y; // big
            int l = b == x ? y : x; // litte

            p[l] = p[b];
            s[b] += s[l];
        }
    }

    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);

        int res = n;
        for(int[] e : edges) {
            int p1 = uf.find(e[0]);
            int p2 = uf.find(e[1]);

            if (p1 != p2) {
                uf.union(p1, p2);
                res -= 1;
            }
        }
        return res;
    }
}