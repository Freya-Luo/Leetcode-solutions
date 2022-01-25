package lc_101_150.LC_153_FindMinimumInRotatedSortedArray;

class Solution {
    // Time: O(logN)
    public int findMin(int[] nums) {
        int left = -1, right = nums.length;  // [0, nums.length]

        while (left + 1 < right) {  // left < right
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right - 1]) {  // mid < right
                right = mid + 1;  // mid
            } else {
                left = mid;  // mid + 1
            }
        }
        return nums[left];
    }
}