package lc_651_700.LC_688_KnightProbabilityInChessboard;

class Solution_DP_SpaceOptimized {
    private int[][] dirs = {{1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};
    // Time: (n^2 * k); Space: O(n^2)

    /**
     * Since the current step k only depends on the status of the previous step (k + 1),
     * we can reduce the dp array from 3d to 2d by using a temp 2-d array and assigning back
     * at the end of each step.
     */
    public double knightProbability(int n, int k, int r, int c) {
        double[][] dp = new double[n][n];
        double res = 0;

        dp[r][c] = 1;
        while (k-- > 0) {
            double[][] tmp = new double[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    for(int[] dir : dirs) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        tmp[nx][ny] += dp[i][j] / 8;
                    }
                }
            }
            dp = tmp; // keep record of the previous (k + 1) status of the board
        }
        for(double[] row : dp) {
            for(double col : row) {
                res += col;
            }
        }
        return res;
    }
}
