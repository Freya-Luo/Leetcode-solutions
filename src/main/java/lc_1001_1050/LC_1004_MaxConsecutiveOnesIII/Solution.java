package lc_1001_1050.LC_1004_MaxConsecutiveOnesIII;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int n = nums.length;

        int max = 0;
        while (right < n) {
            if (nums[right] == 0) { // change 0 to 1
                k -= 1;
            }
            // always compute max if we have sufficient k quotas
            // so max length can get kept along the way
            if (k >= 0) {
                max = Math.max(max, right - left + 1);
            } else { // else move left pointer with 1 step
                if (nums[left] == 0) { // save 1 quota of k
                    k += 1;
                }
                left += 1;
            }
            right += 1;
        }
        return max;
    }
}