package lc_2101.LC_2128_RemoveAllWithRowandColumnFlips;

/**
 * Math question.
 *
 * Ref: https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips/discuss/1698026/Java-solution-(with-explanation)
 *
 * We can ALSO take the first row as the standard looking pattern. Instead of flip all columns whose 1st row element is 1,
 * just keep it as it is. Then, later rows with either the same or totally opposite pattern would both be correct.
 * E.g., 001011
 *   => 001011 or 110100 OK
 */
class Solution {
    private boolean canFlipSame(int[] A, int[] B, int n) {
        int same = 0;
        for(int j = 0; j < n; j++) {
            if (A[j] == B[j]) same += 1;
        }
        return (same == 0 || same == n); // either fully opposite or same
    }
    // O(N)
    public boolean removeOnes(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for(int i = 0; i < m; i++) {
            if (!canFlipSame(grid[0], grid[i], n)) return false;
        }
        return true;
    }
}