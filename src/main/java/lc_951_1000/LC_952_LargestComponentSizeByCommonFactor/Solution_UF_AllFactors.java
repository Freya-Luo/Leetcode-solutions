package lc_951_1000.LC_952_LargestComponentSizeByCommonFactor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * N: total no.of numbers, M: max value in the nums[]
 *
 * Time complexity:
 * => O(sqrt(M)) max no.of factors of a num, so when UNION: O(N * 2 * sqrt(M) * log^*M),
 * where N is N operations, M is elements number;
 * => when FIND: O(N * log^*M)
 * => overall: O(N * sqrt(M) * log^*M)
 *
 * Space: O (N + M)
 */
public class Solution_UF_AllFactors {
    private class UF {
        int[] parents;
        int[] sizes;

        UF(int n) {
            this.parents = new int[n + 1];
            this.sizes = new int[n + 1];

            Arrays.fill(this.parents, -1);
            Arrays.fill(this.sizes, 1);
        }

        int find(int num) {
            if (parents[num] == -1) return num;
            return find(parents[num]);
        }

        // x, y are the parent node
        void union(int x, int y) {
            if (sizes[x] > sizes[y]) {
                parents[y] = x;
                sizes[x] += sizes[y];
            } else {
                parents[x] = y;
                sizes[y] += sizes[x];
            }
        }
    }


    public int largestComponentSize(int[] nums) {
        int maxNum = 0;
        for(int num: nums) {
            maxNum = Math.max(maxNum, num);
        }

        UF uf = new UF(maxNum);

        for(int num: nums) {
            for(int pf = 2; pf * pf <= num; pf++) {  // sqrt(M), 2 * sqrt(M) pairs
                if (num % pf == 0) {
                    int pOfnum = uf.find(num);
                    int pOfpf = uf.find(pf);
                    int pOfpf2 = uf.find(num / pf);

                    if (pOfnum != pOfpf)
                        uf.union(pOfnum, pOfpf);

                    pOfnum = uf.find(num); // update the cur number's parent value
                    if (pOfpf != pOfpf2 && pOfnum != pOfpf2)
                        uf.union(pOfnum, pOfpf2);
                }
            }
        }

        int max = 0;
        // <setId, count>
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            int parent = uf.find(num);
            int count = map.getOrDefault(parent, 0);
            map.put(parent, count + 1);
            max = Math.max(max, count + 1);
        }
        return max;
    }
}
