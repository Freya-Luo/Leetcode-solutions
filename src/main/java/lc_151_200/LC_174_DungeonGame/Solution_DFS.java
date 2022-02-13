package lc_151_200.LC_174_DungeonGame;

import java.util.Arrays;

class Solution_DFS {
    // dp[][] <=> memo[][]
    private int dfs(int[][] dungeon, int[][] dp, int x, int y) {
        if (x >= dungeon.length || y >= dungeon[0].length) {
            return Integer.MAX_VALUE;
        }
        if ((x == dungeon.length - 1) && (y == dungeon[0].length - 1))
            return dungeon[x][y] < 0 ? (-dungeon[x][y] + 1) : 1;

        if (dp[x][y] != Integer.MAX_VALUE) return dp[x][y];

        int minGoRight = dfs(dungeon, dp, x, y + 1);
        int minGoDown = dfs(dungeon, dp, x + 1, y);

        int minHpCost = Math.min(minGoRight, minGoDown);
        return dp[x][y] = (dungeon[x][y] - minHpCost) < 0 ? (minHpCost - dungeon[x][y]) : 1;

    }
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for(int[] row: dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        return dfs(dungeon, dp, 0, 0);
    }
}
