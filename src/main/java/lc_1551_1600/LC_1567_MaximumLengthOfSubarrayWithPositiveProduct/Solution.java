package lc_1551_1600.LC_1567_MaximumLengthOfSubarrayWithPositiveProduct;

/**
 * Time: O(n)
 * Space: O(n) / O(1)
 */
class Solution {
    // Conversion: Find the max subarray with even negative nums
    public int getMaxLen(int[] nums) {
        int[] lenToBeNeg = new int[nums.length], lenToBePos = new int[nums.length];

        lenToBeNeg[0] = nums[0] < 0 ? 1 : 0;
        lenToBePos[0] = nums[0] > 0 ? 1 : 0;

        //[9 1 2 3 -4 0 -1 2 5 6 -3 7]
        // 1 2 3 4  0 0  0 1 2 3  5 6 => lenToBePos[]
        // 0 0 0 0  5 0  1 2 3 4  4 5 => lenToBeNeg[]
        int max = lenToBePos[0];
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                lenToBePos[i] = lenToBeNeg[i - 1] > 0 ? lenToBeNeg[i - 1] + 1 : 0;
                lenToBeNeg[i] = lenToBePos[i - 1]  + 1;
            } else if (nums[i] > 0) {
                lenToBePos[i] = lenToBePos[i - 1] + 1;
                lenToBeNeg[i] = lenToBeNeg[i - 1] > 0 ? lenToBeNeg[i - 1]  + 1 : 0;
            }
            max = Math.max(max, lenToBePos[i]);
        }
        return max;
    }

    /** --------- Note: dp[i] only depends on the last value dp[i - 1] --------------- */
    // Update using 2 vars instead of 2 arrays
    public int getMaxLen2(int[] nums) {

        int lenToBeNeg = nums[0] < 0 ? 1 : 0;
        int lenToBePos = nums[0] > 0 ? 1 : 0;

        int max = lenToBePos;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int lastPos = lenToBePos;
                lenToBePos = lenToBeNeg > 0 ? lenToBeNeg + 1 : 0;
                lenToBeNeg = lastPos  + 1;
            }
            else if (nums[i] > 0) {
                lenToBePos = lenToBePos + 1;
                lenToBeNeg = lenToBeNeg > 0 ? lenToBeNeg  + 1 : 0;
            }
            else {
                lenToBePos = lenToBeNeg = 0;
            }
            max = Math.max(max, lenToBePos);
        }
        return max;
    }
}