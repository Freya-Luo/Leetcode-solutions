package lc_51_100.LC_84_LargestRectangleInHistogram;

class Solution_DP {
    // Time: O(n)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] firstSmallerFromCurToLeft = new int[n], firstSmallerFromCurToRight = new int[n];

        firstSmallerFromCurToLeft[0] = -1;
        // reduce to O(n)
        for(int i = 1; i < n; i++) {
            int left = i - 1;
            while (left >= 0 && heights[left] >= heights[i]) {
                left = firstSmallerFromCurToLeft[left];
            }
            firstSmallerFromCurToLeft[i] = left;
        }

        firstSmallerFromCurToRight[n - 1] = n;
        for(int i = n - 2; i >= 0; i--) {
            int right = i + 1;
            while (right <= n -1 && heights[right] >= heights[i]) {
                right = firstSmallerFromCurToRight[right];
            }
            firstSmallerFromCurToRight[i] = right;
        }

        int max = 0;
        for(int k = 0; k < n; k++) {
            int curArea = heights[k] * (firstSmallerFromCurToRight[k] - firstSmallerFromCurToLeft[k] - 1);
            max = Math.max(max, curArea);
        }
        return max;
    }
}
