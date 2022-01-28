package lc_801_850.LC_827_MakingALargeIsland;

import java.util.*;

// Time: O(N^2)
// Space: O(N^2) -- stack call
class Solution {
    private int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private boolean isValid(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
            return false;
        return true;
    }

    private int dfs(int[][] grid, int x, int y, int islandIdx) {
        if (!isValid(grid, x, y) || grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = islandIdx;  // label the cell with the index of the current exploring island

        int res = 1;
        for (int[] dir : dirs) {
            res += dfs(grid, x + dir[0], y + dir[1], islandIdx);  // collect the size of the current island
        }
        return res;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        // <islandIdx, area>
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> allZeros = new ArrayList<>();
        int islandIdx = 2; // original either 0 or 1, so start from 2
        int max = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int curArea =  dfs(grid, i, j, islandIdx);
                    map.put(islandIdx, curArea); // map and store the size <=> current island
                    max = Math.max(max, curArea);
                    islandIdx++; // continue exploring next island
                } else if (grid[i][j] == 0) {
                    allZeros.add(new int[]{i, j});
                }
            }
        }

        for(int[] cur : allZeros) {
            int res = 1;
            Set<Integer> explored = new HashSet<>();

            for(int[] dir : dirs) { // find all 4 neighbors of the current 0 cell
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];

                if (!isValid(grid, nx, ny)) continue;

                int idx = grid[nx][ny];
                if (idx >= 2 && !explored.contains(idx)) { // check if the neighbor belongs to some unconnected island
                    res += map.get(idx);
                    explored.add(idx);
                }
            }
            max = Math.max(res, max);
        }
        return max;
    }
}