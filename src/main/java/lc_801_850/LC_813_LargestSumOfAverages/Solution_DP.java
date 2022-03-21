package lc_801_850.LC_813_LargestSumOfAverages;

class Solution_DP {
    // Time: O(k * n^2)
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[][] dp = new double[n + 1][k + 1]; // dp[i][j]: computes the result for first i numbers to j groups
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            dp[i][1] =  (double) preSum[i] / i;  // double !!! type conversion
        }
        for (int j = 2; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                for (int p = 1; p < i; p++) {
                    // divide nums into [0:p] & [p+1:i]
                    // first p eles to form (j-1) groups, then the last j-th group is formed
                    // by [p+1:i], so the avg is (preSum[i] - preSum[p]) / (i - p)
                    dp[i][j] = Double.max(dp[i][j], dp[p][j - 1] + ((double) (preSum[i] - preSum[p]) / (i - p)));
                }
            }
        }
        return dp[n][k];
    }
}
