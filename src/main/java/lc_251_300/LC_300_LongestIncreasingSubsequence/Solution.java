package lc_251_300.LC_300_LongestIncreasingSubsequence;

class Solution {
    // Time: O(NlogN)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // dp[i]: store the smallest tail of all the size i subarray

        int len = 0;
        for(int i = 0; i < n; i++) {  // for each num do the pile sorting
            int left = 0 , right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[right] = nums[i];
            if (right == len) len++;;
        }
        return len;
    }
}