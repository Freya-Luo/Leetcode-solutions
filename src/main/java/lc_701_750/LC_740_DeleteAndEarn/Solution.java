package lc_701_750.LC_740_DeleteAndEarn;

import java.util.Map;
import java.util.TreeMap;

/**
 * Similar to the "house robber" problem.
 * The tradeoff is using hashmap to save space or using a big array to save time.
 */
class Solution {
    // O(nlogn)
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + num);
        }
        int prev = 0, cur = 0;
        for (int n : count.keySet()) {
            if (count.containsKey(n - 1)) {
                int temp = cur;
                cur = Math.max(cur, prev + count.get(n));
                prev = temp;
            } else {
                prev = cur;
                cur += count.get(n);
            }
        }
        return cur;
    }
}
