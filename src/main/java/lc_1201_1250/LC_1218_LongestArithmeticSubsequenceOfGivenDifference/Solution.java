package lc_1201_1250.LC_1218_LongestArithmeticSubsequenceOfGivenDifference;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // O(N)
    public int longestSubsequence(int[] arr, int diff) {
        Map<Integer, Integer> dp = new HashMap<>();
        int max = 0;
        for(int n : arr) {
            dp.put(n, dp.getOrDefault(n - diff, 0) + 1); // 1: itself
            max = Math.max(max, dp.get(n));
        }
        return max;
    }
}