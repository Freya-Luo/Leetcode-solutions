package lc_951_1000.LC_952_LargestComponentSizeByCommonFactor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_UF_NoPrimeCalc {
    private class UF {
        int[] parents;
        int[] sizes;
        int maxSize;

        UF(int n) {
            this.parents = new int[n];
            this.sizes = new int[n];
            this.maxSize = 1;

            Arrays.fill(this.parents, -1);
            Arrays.fill(this.sizes, 1);
        }

        int find(int num) {
            if (parents[num] == -1) return num;
            return find(parents[num]);
        }

        void union(int x, int y) {
            int pOfx = find(x);
            int pOfy = find(y);

            if (pOfx == pOfy) return;

            int min = sizes[pOfx] <= sizes[pOfy] ? pOfx : pOfy;
            int max = sizes[pOfx] > sizes[pOfy] ? pOfx : pOfy;

            parents[min] = max;
            sizes[max] += sizes[min];
            maxSize = Math.max(sizes[max], maxSize);
        }
    }

    // <Prime Factor, numIdx>
    private Map<Integer, Integer> map = new HashMap<>();
    private UF uf;

    private void connectByPF(int pf, int i) {
        if (!map.containsKey(pf)) {
            map.put(pf, i);
        } else {
            uf.union(i, map.get(pf));
        }
    }

    public int largestComponentSize(int[] nums) {

        uf = new UF(nums.length);

        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            for(int pf = 2; pf * pf <= cur; pf++) {
                if (cur % pf == 0) {
                    connectByPF(pf, i);
                    connectByPF(cur/ pf, i);
                }
            }
            connectByPF(cur, i);
        }
        return uf.maxSize;
    }

}
