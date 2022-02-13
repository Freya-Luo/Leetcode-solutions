package lc_151_200.LC_174_DungeonGame;

import java.util.Arrays;

class Solution_DP {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int[] row: dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dp[m][n - 1] = dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int needHp = dungeon[i][j] - Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = needHp < 0 ? -needHp : 1;
            }
        }
        return dp[0][0];
    }
}
