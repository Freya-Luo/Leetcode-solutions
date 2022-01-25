package lc_101_150.LC_153_FindMinimumInRotatedSortedArray;

class Solution {
    // Time: O(logN)
    public int findMin(int[] nums) {
        int left = -1, right = nums.length;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right - 1]) {
                right = mid + 1;
            } else {
                left = mid;
            }
        }
        return nums[left];
    }
}