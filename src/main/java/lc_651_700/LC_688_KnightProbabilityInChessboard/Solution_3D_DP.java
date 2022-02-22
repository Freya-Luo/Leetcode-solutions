package lc_651_700.LC_688_KnightProbabilityInChessboard;

class Solution_3D_DP {
    private boolean isOut(int n, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n){
            return true;
        }
        return false;
    }

    private int[][] dirs = {{1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};
    // Time: (n^2 * k); Space: O(n^3)
    public double knightProbability(int n, int k, int r, int c) {
        double[][][] dp = new double[k + 1][n][n];
        double res = 0;

        dp[k][r][c] = 1;
        while (k-- > 0) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    for(int[] dir : dirs) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];

                        if (isOut(n, nx, ny)) continue;
                        /** current probability at this cell with step k is the sum of
                         * all probabilities from starting cells in the previous step (k + 1)
                         * to this cell.
                         *  - Each starting cell to another cell has the P of P(starting cell) / 8.
                         *  - loop from k to 0, so (k + 1) is the previous status of the board
                         */
                        dp[k][nx][ny] += dp[k + 1][i][j] / 8;
                    }
                }
            }
        }
        for(double[] row : dp[0]) {
            for(double col : row) {
                res += col;
            }
        }
        return res;
    }
}
