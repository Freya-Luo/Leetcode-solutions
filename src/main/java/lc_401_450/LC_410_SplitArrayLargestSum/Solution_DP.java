package lc_401_450.LC_410_SplitArrayLargestSum;

class Solution_DP {
    // Time: O(m * n^2), which is similar to LC.813
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            dp[i][1] = sum[i];
        }

        for(int k = 2; k <= m; k++) {
            for(int i = 1; i <= n; i++) {
                int min = Integer.MAX_VALUE;
                for(int j = 1; j < i; j++) {
                    // get the largest part among k subarrays using first i numbers in nums
                    int max = Math.max(dp[j][k - 1], sum[i] - sum[j]);
                    min = Math.min(min, max); // get the min largest sum
                }
                dp[i][k] = min;
            }
        }
        return dp[n][m];
    }
}