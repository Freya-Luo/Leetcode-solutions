package lc_51_100.LC_55_JumpGame;

/**
 * Iterate and update the max index I can reach
 */
class Solution {
    public boolean canJump(int[] nums) {
        int furthest = 0;

        for(int i = 0; i < nums.length; i++) {
            if (furthest < i) return false; // early stop, as we cannot reach i, not mention n - 1
            furthest = Math.max(furthest, i + nums[i]);
        }
        return true;
    }
}