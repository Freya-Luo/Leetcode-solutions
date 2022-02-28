package lc_51_100.LC_96_UniqueBinarySearchTrees;

/**
 * No.of differ structure in root's left subtree * No.of differ structure in root's right subtree.
 *
 * Given the sorted property, we can think of it as:
 * for each root number of i & range [0, n], how many nums are smaller than i,
 * and how many nums are larger than i. For each picked pair, sum up its
 * all combinations.
 */

class Solution {
    // O(n^2)
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i <=n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}