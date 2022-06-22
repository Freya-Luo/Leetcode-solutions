package lc_551_600.LC_562_LongestLineofConsecutiveOneInMatrix;

/**
 * Tricky: 3D-dp solution.
 * Keep track of 1's along all 4 lines while traversing the matrix once only.
 *
 * 4mn sized dp array
 * => dp[0], dp[1], dp[2] ,dp[3] store max number of continuous 1's found so far
 * along the Horizontal, Vertical, Diagonal and Anti-diagonal lines respectively.
 */
class Solution {
    // O (mn)
    public int longestLine(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][][] dp = new int[m + 1][n + 2][4]; // 0: horizontal; 1 : vertical; 2: diagonal; 3: anti-diagonal
        int max = 0;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if (mat[i- 1][j - 1] == 1) {
                    dp[i][j][0] = dp[i][j - 1][0] + 1;
                    dp[i][j][1] = dp[i - 1][j][1] + 1;
                    dp[i][j][2] = dp[i - 1][j - 1][2] + 1;
                    dp[i][j][3] = dp[i - 1][j + 1][3] + 1;
                    int cur = Math.max(dp[i][j][0], Math.max(dp[i][j][1],
                            Math.max(dp[i][j][2], dp[i][j][3])));
                    max = Math.max(max, cur);
                }
            }
        }
        return max;
    }
}