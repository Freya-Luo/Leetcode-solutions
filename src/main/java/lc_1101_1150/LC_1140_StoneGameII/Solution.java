package lc_1101_1150.LC_1140_StoneGameII;

/**
 * 1) Main state transfer logic:
 * the max stones the current player can pick =
 * max(all the left stones  - stones picked by the other player)
 *
 * 2) The other player also tries to pick stones as much as possible, so "minus
 * dfs()" is for the opponent player.
 */
public class Solution {
    private int dfs(int[] sum, int[][] memo, int cur, int M) {
        // the other player pick all the left stones
        if (cur + 2 * M >= sum.length) return sum[cur];

        if (memo[cur][M] != 0) return memo[cur][M];
        int res = 0;
        for(int i = 1; i <= 2 * M; i++) {
            int taken = sum[cur] - sum[cur + i]; // stones picked by the current player
            // current picked stones + all the left stones - the stones picked by the other player (try to minimize this)
            res = Math.max(res, taken + sum[cur + i] - dfs(sum, memo, cur + i, Math.max(M, i)));
        }
        memo[cur][M] = res;
        return res;
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] postSum = new int[n];
        postSum[n - 1] = piles[n - 1];
        // sum[i] is all the stones left, so piles[i:]
        for(int i  = n - 2; i >= 0; i--) {
            postSum[i] = postSum[i + 1] + piles[i];
        }
        int[][] memo = new int[n][n]; // memo[i][j]: max stones the cur player can pick from piles[i:] with M=j
        return dfs(postSum, memo, 0, 1);
    }
}
