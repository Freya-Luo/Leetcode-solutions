package LC_926_FlipStringToMonotoneIncreasing;

class Solution {
    // O(n)
    public int minFlipsMonoIncr1(String s) {
        int n = s.length();
        int[] dp = new int[n];

        int numOfOne = s.charAt(0) == '1' ? 1 : 0;
        for(int i = 1; i < n; i++) {
            if (s.charAt(i) == '1') {
                dp[i] = dp[i - 1];
                numOfOne += 1;
            } else {
                dp[i] = Math.min(numOfOne, dp[i - 1] + 1);
            }
        }
        return dp[n - 1];
    }
     /* ----------------------------------- */
    // O(n)
    public int minFlipsMonoIncr2(String s) {
        int n = s.length();
        int[] sum = new int[n + 1];


        for(int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (s.charAt(i - 1) == '1' ? 1 : 0);
        }
        // Start from i = 0, in the case that the whole string s is the right part
        int min = n;
        for(int i = 0; i <= n; i++) {
            int zerosAtRight = (n - i) - (sum[n] - sum[i]);
            min = Math.min(min, sum[i] + zerosAtRight);
        }
        return min;
    }
}
