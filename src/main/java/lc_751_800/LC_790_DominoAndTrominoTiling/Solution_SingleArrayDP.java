package lc_751_800.LC_790_DominoAndTrominoTiling;

class Solution_SingleArrayDP {
    public int numTilings(int n) {
        // formula
        int[] dp = new int[1001];
        int mod = 1000000007;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for(int i = 4; i <= n; i++) {
            dp[i] = 2 * dp[i - 1] % mod + dp[i - 3];
            dp[i] %= mod;
        }
        return dp[n];
    }
}