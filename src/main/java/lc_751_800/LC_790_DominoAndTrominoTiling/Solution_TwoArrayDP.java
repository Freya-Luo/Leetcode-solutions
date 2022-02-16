package lc_751_800.LC_790_DominoAndTrominoTiling;

class Solution_TwoArrayDP {
    public int numTilings(int n) {
        long[] T2 = new long[1001], T3 = new long[1001];
        int mod = 1000000007;
        T2[1] = 1; T3[1] = 0;
        T2[2] = 2; T3[2] = 1;

        for(int i = 3; i <= n; i++) {
            T2[i] = (T2[i - 1] + T2[i - 2] + 2 * T3[i - 1]) % mod;
            T3[i] = (T3[i - 1]+ T2[i - 2]) % mod;
        }
        return (int) T2[n];
    }
}
