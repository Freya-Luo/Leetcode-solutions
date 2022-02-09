package lc_951_1000.LC_980_UniquePathsIII;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int[][] dirs = {{-1,0}, {0,-1}, {0,1},{1,0}};
    private void dfs(int[][] grid, int[] cur, int[] des, int left,
                     List<int[]> path, List<List<int[]>> res) {
        int temp = grid[cur[0]][cur[1]];

        if (temp == -2) return;
        if (cur[0] == des[0] && cur[1] == des[1] && left == 1) {

            res.add(new ArrayList<>(path));
            return;
        }
        grid[cur[0]][cur[1]] = -2; // -2: means already visited
        path.add(new int[]{cur[0], cur[1]});
        left -= 1;
        for(int[] dir : dirs) {
            int nx = cur[0] + dir[0];
            int ny = cur[1] + dir[1];
            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length || grid[nx][ny] == -1)
                continue;

            dfs(grid, new int[]{nx, ny}, des, left, path, res);
        }

        left += 1;
        path.remove(path.size() - 1);
        grid[cur[0]][cur[1]] = temp;
    }

    // Brute force, backtrack
    // Time: O(3^N) -- at each step, have 3 dirs to explore except for the dir we just come from
    // Space: O(N)
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] src = new int[2], des = new int[2];
        int obstacles = 0;

        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    src[0] = i;
                    src[1] = j;
                } else if (grid[i][j] == 2) {
                    des[0] = i;
                    des[1] = j;
                } else if (grid[i][j] == -1) {
                    obstacles += 1;
                }
            }
        }
        List<List<int[]>> res = new ArrayList<>();
        dfs(grid, src, des, m*n - obstacles, new ArrayList<>(), res);
        return res.size();
    }
}