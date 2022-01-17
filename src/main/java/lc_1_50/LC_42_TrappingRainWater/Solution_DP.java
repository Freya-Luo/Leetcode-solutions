package lc_1_50.LC_42_TrappingRainWater;

class Solution_DP {
    // Time: O(n)
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        int[] left = new int[n], right = new int[n];

        left[0] = height[0];
        for(int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        right[n - 1] = height[n - 1];
        for(int i = n- 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        for(int k = 0; k < n; k++) {
            res += Math.min(left[k], right[k]) - height[k];
        }
        return res;
    }
}