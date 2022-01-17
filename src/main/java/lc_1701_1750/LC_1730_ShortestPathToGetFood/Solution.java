package lc_1701_1750.LC_1730_ShortestPathToGetFood;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    private final int[][] dirs = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    private int[] findSrc(char[][] grid) {
        // Find the src point
        int n = grid.length, m = grid[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (grid[i][j] == '*') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private boolean isValid(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 'X') {
            return false;
        }
        return true;
    }

    /**
     * BFS - Time: O(MN) size of the grid
     * Space: O(1)
     */
    public int getFood(char[][] grid) {
        // Find the src point
        int n = grid.length, m = grid[0].length;
        int[] src = findSrc(grid);

        // [x, y, level]
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{src[0], src[1], 0});

        while(!deque.isEmpty()) {
            int[] cur = deque.poll();

            for(int[] dir : dirs) {
                int nX = cur[0] + dir[0];
                int nY = cur[1] + dir[1];

                if (!isValid(grid, nX, nY)) continue;

                if (grid[nX][nY] == '#') return cur[2] + 1;

                if (grid[nX][nY] == 'O') {
                    deque.offer(new int[]{nX, nY, cur[2] + 1});
                    grid[nX][nY] = 'X';
                }
            }
        }
        return -1;
    }
}