package lc_301_350.LC_329_LongestIncreasingPathInAMatrix;

/**
 * Straightforward solution with DFS and memo. It can also be pictured as a graph.
 * Each cell is a vertex and will be calculated once and only once. Each edge will
 * also be visited once and only once. (4 edges/ node)
 *
 * Time: O(V + E) = 0(mn + 4mn); Space: O(mn)
 */
class Solution_DFS_Memo {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private boolean isValid(int x, int y, int m, int n) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        return true;
    }

    private int dfs(int[][] mat, int x, int y, int[][] memo, int m, int n) {
        if (memo[x][y] != 0) return memo[x][y];

        int curmax = 1;
        for(int[] dir : dirs) {
            int nX = x + dir[0];
            int nY = y + dir[1];

            if (!isValid(nX, nY, m, n)) continue;
            if (mat[nX][nY] > mat[x][y]) {
                curmax = Math.max(curmax, dfs(mat, nX, nY, memo, m, n) + 1);
            }
        }
        memo[x][y] = curmax;
        return curmax;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        int max = -1;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j< n; j++) {
                int len = dfs(matrix, i, j, memo, m, n);
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
