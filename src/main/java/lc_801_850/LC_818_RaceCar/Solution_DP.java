package lc_801_850.LC_818_RaceCar;

class Solution_DP {
    public int racecar(int target) {
        int[] dp = new int[target + 1];

        for(int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;
            int j = 1, ji = 1;
            for(; j < i; j = (1 << (ji + 1)) - 1, ji++) {
                // System.out.println(j + " " + ji + "\t");
                for(int k = 0, ki = 0; k < j; k = (1 << (ki + 1)) - 1, ki++) {
                    // System.out.println(ki + " " + ((1 << ki) - 1));
                    dp[i] = Math.min(dp[i], ji + 1 + ki + 1 + dp[i - (j - k)]);
                }
            }

            if (i == j) {
                dp[i] = Math.min(dp[i], ji);
            } else {
                dp[i] = Math.min(dp[i], ji + 1 + dp[j - i]);
            }
        }
        return dp[target];
    }
}
