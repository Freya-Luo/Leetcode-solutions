package lc_951_1000.LC_959_RegionsCutBySlashes;

// Scale it up, and then th problem becomes the same as LC 200
class Solution {
    private void dfs(char[][] mat, int x, int y) {
        if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length || mat[x][y] != '\0') {
            return;
        }

        mat[x][y] = '/';

        dfs(mat, x - 1, y);
        dfs(mat, x, y - 1);
        dfs(mat, x + 1, y);
        dfs(mat, x, y + 1);
    }
    // Time: O(9N^2) <=> Space (9N^2)
    public int regionsBySlashes(String[] grid) {
        int n  = grid.length;
        char[][] mat = new char[3*n][3*n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    mat[i * 3][j * 3 + 2] = '/';
                    mat[i * 3 + 1][j * 3 + 1] = '/';
                    mat[i * 3 + 2][j * 3] = '/';
                } else if (grid[i].charAt(j) == '\\') {
                    mat[i * 3][j * 3] = '\\';
                    mat[i * 3 + 1][j * 3 + 1] = '\\';
                    mat[i * 3 + 2][j * 3 + 2] = '\\';
                }
            }
        }
        int res = 0;
        for(int i = 0; i < 3*n; i++) {
            for(int j = 0; j < 3*n; j++) {
                if (mat[i][j] == '\0') {
                    dfs(mat, i, j);
                    res += 1;
                }
            }
        }
        return res;
    }
}