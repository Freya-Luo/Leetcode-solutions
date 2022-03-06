package lc_551_600.LC_583_DeleteOperationForTwoStrings;

class Solution {
    // O (m * n)
    public int minDistance(String w1, String w2) {
        int n = w1.length(), m = w2.length();
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++) dp[i][0] = i;
        for(int j = 0; j <= m; j++) dp[0][j] = j;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // nothing needs to change here
                } else {
                    // either deletes w1[i] or deletes w2[j] or deletes both
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]) + 1, dp[i - 1][j - 1] + 2);
                }
            }
        }
        return dp[n][m];
    }
}