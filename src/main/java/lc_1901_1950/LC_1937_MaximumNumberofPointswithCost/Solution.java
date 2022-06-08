package lc_1901_1950.LC_1937_MaximumNumberofPointswithCost;

/**
 * Key observation: from O(N^3) to O(N^2)
 *
 * For the current row, we have the formula: cur[i] (dp[i]) = max([prev[j] - abs(i - j)] for j in range(n)) + points[row][i].
 * If we compare every index in prev[] with every index i in points[row], it will give O(N^2) for each row.
 *
 * Consider this: to get left[4], need to get max(prev[4], prev[3] - 1, prev[2] - 2, prev[1] - 3, prev[0] - 4),
 * => however, max(prev[1] - 3, prev[0] - 4) is the same as comparing max(prev[1], prev[0] - 1), and this result is already
 * => stored in left[1]. The real value is left[1] - 3.
 *
 * Therefore, comparing max(prev[2] - 2, left[1] - 3) is the same as max(prev[2], left[1] - 1), which is stored in left[2]. The real
 * value is left[2] - 2. Similarly, max(prev[3] - 1, left[2] - 2) is equal to the comparison between max(prev[3], left[2] - 1) = left[3].
 * Real value is left[3] - 1.
 *
 * So, left[4] only needs to depend on left[3], where left[i] always stores the max value among values to the left of index = i.
 * But, we only compare the left-side until right now. So, doing the same procedure to the right-side.
 *
 * Finally, combine the left and right values, pick the max one, add that with points[row][i]
 */
class Solution {
    // O(N^2)
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[] dp = new long[n];

        for(int j = 0; j < n; j++) {
            dp[j] = points[0][j];
        }

        for(int i = 1; i < m; i++) {
            long[] left = new long[n], right = new long[n];

            left[0] = dp[0]; // dp => prev
            for(int j = 1; j < n; j++) {
                left[j] = Math.max(left[j - 1] - 1, dp[j]);
            }

            right[n - 1] = dp[n - 1];
            for(int j = n - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1] - 1, dp[j]);
            }

            long[] cur = new long[n];
            for(int k = 0; k < n; k++) {
                dp[k] = Math.max(left[k], right[k]) + points[i][k]; // update prev[]
            }
        }

        long max = -1;
        for(long num : dp) {
            max = Math.max(num, max);
        }
        return max;
    }
}