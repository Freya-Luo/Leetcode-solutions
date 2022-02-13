package lc_901_950.LC_931_MinimumFallingPathSum;

import java.util.Arrays;

class Solution {
    // Time: O(n^2)
    // Space: O(n^2)
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i  = 0; i < n - 1; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        for(int j = 0; j < n; j++) dp[n - 1][j] = matrix[n - 1][j];

        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                int minInNext;
                if (j == 0) {
                    minInNext = Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                } else if (j == n - 1) {
                    minInNext = Math.min(dp[i + 1][j], dp[i + 1][j - 1]);
                } else {
                    minInNext = Math.min(dp[i + 1][j], Math.min(dp[i + 1][j - 1], dp[i + 1][j + 1]));
                }
                dp[i][j] = minInNext + matrix[i][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[0][j]);
        }
        return min;
    }

// More concise version:
//    public int minFallingPathSum(int[][] A) {
//        for (int i = 1; i < A.length; ++i)
//            for (int j = 0; j < A.length; ++j)
//                A[i][j] += Math.min(A[i - 1][j], Math.min(A[i - 1][Math.max(0, j - 1)], A[i - 1][Math.min(A.length - 1, j + 1)]));
//        return Arrays.stream(A[A.length - 1]).min().getAsInt();
//    }
}