package lc_1101_1150.LC_1105_FillingBookcaseShelves;

class Solution {
    // Time: O(n^2) in worst case, where shelfWidth = sum(width)
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            int w = books[i - 1][0], h = books[i - 1][1];
            dp[i] = dp[i - 1] + h;

            int prev = i - 1;
            while (prev > 0 && books[prev - 1][0] + w <= shelfWidth) {
                h = Math.max(h, books[prev - 1][1]);
                w += books[prev - 1][0];
                dp[i] = Math.min(dp[i], h + dp[prev - 1]);
                prev--;
            }
        }
        return dp[n];
    }
}