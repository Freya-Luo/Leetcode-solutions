package lc_301_350.LC_317_ShortestDistancefromAllBuildings;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * For the 1st BFS, change the visited empty cell ot -1. Then, during the 2nd BFS, we only visit cells
 * with -1, which means these cells can reach the 1st house), then change -1 to -2. The 3rd BFS performs
 * on these -2 cells, and so on ...
 *
 * It can guarantee we won't visit ant cells that cannot reach all houses.
 *
 * Also, using a separate 2D array to denote the total steps. dist[i][j] represents
 * during this current BFS (with starting house Xn), the total steps from grid[i][j]
 * to the houses of X1, X2, ...., Xn.
 *
 * Worst case: half cells are 0s, half cells are 1s.
 * Then, elements are O(mn/2) and O(mn/2), which then gives O((mn)^2).
 */
class Solution {
    private final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int bfs(int[][] grid, int x, int y, int houseId, int[][] dist) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y, 0});

        int minDist = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();

                for(int[] dir : dirs) {
                    int nX = cur[0] + dir[0];
                    int nY = cur[1] + dir[1];
                    int nStep = cur[2] + 1;

                    if (nX < 0 || nX >= grid.length
                            || nY < 0 || nY >= grid[0].length) continue;
                    if (grid[nX][nY] == houseId) {
                        grid[nX][nY] -= 1; // this cell has been visited during this BFS round
                        dist[nX][nY] += nStep;

                        queue.offer(new int[]{nX, nY, nStep});
                        minDist = Math.min(minDist, dist[nX][nY]);
                    }
                }
            }
        }
        return minDist;
    }

    // Time: O((mn)^2), Space: O(mn)
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];

        int houseId = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // Do BFS for each house
                if (grid[i][j] == 1) {
                    min = bfs(grid, i, j, houseId, dist);
                    if (min == Integer.MAX_VALUE) {
                        return -1;
                    }
                    houseId -= 1;
                }
            }
        }
        return min;
    }
}