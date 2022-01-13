package LC_994_RottingOrange;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private boolean isValid(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 2) {
            return false;
        }
        return true;
    }

    public int orangesRotting(int[][] grid) {
        // First find all the fresh oranges and all rotten oranges
        int n = grid.length, m = grid[0].length;
        Queue<int[]> dq = new LinkedList<>();

        int fresh = 0;
        for(int i = 0; i < n; i++)  {
            for(int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    dq.offer(new int[]{i, j , 0});
                }
            }
        }
        if (fresh == 0) return 0;

        int minute = 0;
        while(!dq.isEmpty()) {
            int[] cur = dq.poll();

            for(int[] dir : dirs) {
                int nX = cur[0] + dir[0];
                int nY = cur[1] + dir[1];

                if (isValid(grid, nX, nY) && grid[nX][nY] == 1) {
                    dq.offer(new int[]{nX, nY, cur[2] + 1});
                    grid[nX][nY] = 2;
                    fresh--;
                    // Find the max minute to make all fresh oranges rotten
                    minute = Math.max(minute, cur[2] + 1);
                }
                if (fresh == 0) return minute;
            }
        }
        return -1;
    }
}