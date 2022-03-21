package lc_801_850.LC_813_LargestSumOfAverages;

class Solution_DFS {
    /**
     * Idea: let first cur numbers to be 1 group, and make the rest of the numbers to
     * form (k-1) groups.
     * Time: O(k * n^2)
     */
    private double dfs(int[] nums, int[] sum, int k, double[][] memo, int cur) {
        if (memo[cur][k] != 0) return memo[cur][k];
        // terminating condition
        if (k == 1) {
            memo[cur][1] = ((double)(sum[nums.length] - sum[cur] + nums[cur - 1]) / (nums.length + 1 -cur));
            return memo[cur][1];
        }
        // starts from the "cur" index, "i + k <= nums.length + 1" to make sure there is enough space to
        // let the rest of the nums to be k groups. (at least k elements left)
        double res = 0.0;
        for(int i = cur; i + k <= nums.length + 1; i++) {
            // compute the avg nums[cur:i] => "preSum[i] - preSum[cur] + nums[cur]" & length is (i - cur + 1)
            res = Math.max(res, ((double)(sum[i] - sum[cur] + nums[cur - 1]) / (i - cur + 1)) + dfs(nums, sum, k - 1, memo, i + 1));
        }
        memo[cur][k] = res;
        return res;
    }

    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[][] memo = new double[n + 1][k + 1];
        int[] preSum = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            preSum[i] += preSum[i - 1] + nums[i - 1];
        }

        return dfs(nums, preSum, k, memo, 1); // starts from index 1
    }
}
