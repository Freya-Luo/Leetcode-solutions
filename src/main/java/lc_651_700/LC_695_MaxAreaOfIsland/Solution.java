package lc_651_700.LC_695_MaxAreaOfIsland;

class Solution {
    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length
                || grid[x][y] == 0) {
            return 0;
        }

        int res = 1;
        grid[x][y] = 0;

        res += dfs(grid, x - 1, y);
        res += dfs(grid, x, y + 1);
        res += dfs(grid, x + 1, y);
        res += dfs(grid, x, y - 1);
        return res;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }
}