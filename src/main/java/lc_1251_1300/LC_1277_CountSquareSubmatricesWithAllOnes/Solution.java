package lc_1251_1300.LC_1277_CountSquareSubmatricesWithAllOnes;

/**
 * This question is similar to LC.221
 */
class Solution {
    // O(m * n)
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
            res += matrix[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = matrix[0][j];
            res += matrix[0][j];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    int width = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                    dp[i][j] = width + 1;
                    res += width + 1;
                }
            }
        }
        return res;
    }
}