package lc_251_300.LC_312_BurstBalloons;

/**
 * dp[i][j] means the max coins that can be obtained by bursting the balloons between i and j.
 * Therefore, at the end, dp[1][n] is the result as the balloons between A[1] ~ A[n] should all be burst.
 *
 * DP state transition:
 * loop through each balloon k between [i, j] and make k to be the last balloon to burst:
 * max = max by bursting all the balloons on the left side of k + max by bursting all the balloons on the right side of k
 * + val by bursting k when left and right side are gone
 * = range(i, k-1) + range(k+1, j) + A[i-1]*A[k]*A[j+1]
 * = dp[left][k-1] + dp[k+1][right] + A[i-1]*A[k]*A[j+1]
 */
class Solution {
    // Time: O(n^3)
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] A = new int[n + 2];
        int[][] dp = new int[n + 2][n + 2];

        for(int i = 1; i <= n; i++) A[i] = nums[i - 1];
        A[0] = A[n + 1] = 1;  // out of boundary: left & right to be 1

        for(int range = 1; range <= n; range++) { // range length of [left, right]
            for(int left = 1; left + range <= n + 1; left++) { // set max value left can get
                int right = left + range - 1;
                for(int k = left; k <= right; k++) { // loop through every balloon between left and right
                    int sum = dp[left][k - 1] + dp[k + 1][right] + A[left - 1] * A[k] * A[right + 1];
                    dp[left][right] = Math.max(dp[left][right], sum);
                }
            }
        }
        return dp[1][n]; // burst all between 1 and n
    }
}