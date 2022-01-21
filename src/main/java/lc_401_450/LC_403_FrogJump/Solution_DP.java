package lc_401_450.LC_403_FrogJump;

class Solution_DP {
    // Time: O(n^2)
    // Space: O(n^2)
    public boolean canCross(int[] stones) {
        // dp[s][j]: dp[s] reprsents stone s, j: means jump unit
        int n  = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][1] = true;

        for(int s = 1; s < n; s++) {
            for(int j = 0; j < s; j++) {
                int gap = stones[s] - stones[j];  // from j to s

                if (gap >= n || !dp[j][gap]) continue;
                int jumpLessOne = Math.max(0, gap - 1);
                int jumpMoreOne = Math.min(n - 1, gap + 1);

                dp[s][gap] = dp[s][jumpLessOne] = dp[s][jumpMoreOne] = true;

                if (s == n - 1) return true;
            }
        }
        return false;
    }
}
