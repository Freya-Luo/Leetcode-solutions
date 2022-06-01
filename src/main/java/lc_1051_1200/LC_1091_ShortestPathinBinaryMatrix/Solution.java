package lc_1051_1200.LC_1091_ShortestPathinBinaryMatrix;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    private int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};

    private boolean isValid(int x, int y, int n) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }
        return true;
    }
    // Time: O(N)
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1;

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] cur = queue.poll();

                if (cur[0] == n - 1 && cur[1] == n-1) return step + 1;
                for(int[] dir : dirs) {
                    int nX = cur[0] + dir[0];
                    int nY = cur[1] + dir[1];

                    if (isValid(nX, nY, n) && grid[nX][nY] == 0) {
                        queue.add(new int[]{nX, nY});
                        grid[nX][nY] = 1; // rewrite the visited cell
                    }
                }
            }
            step += 1;
        }
        return -1;
    }
}