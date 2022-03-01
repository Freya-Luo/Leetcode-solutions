package lc_801_850.LC_818_RaceCar;

import java.util.Arrays;

class Solution_DFS {
    private int dfs(int t, int[] dp) {
        if (dp[t] != Integer.MAX_VALUE) {
            return dp[t];
        }
        int j = 1, ji = 1;
        for(; j < t; ji++, j = (1 << ji) - 1) {
            for(int k = 0, ki = 0; k < j; ki++, k = (1 << ki) - 1) {
                dp[t] = Math.min(dp[t], ji + 1 + ki + 1 + dfs(t - (j - k), dp));
            }
        }
        if (j == t) {
            dp[t] = Math.min(dp[t], ji);
        } else {
            dp[t] = Math.min(dp[t], ji + 1 + dfs(j - t, dp));
        }

        return dp[t];
    }
    public int racecar(int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, 1, target + 1, Integer.MAX_VALUE);
        return dfs(target, dp);
    }
}
