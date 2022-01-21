package lc_501_550.LC_540_SingleElementInASortedArray;

class Solution {
    // Time: O(logN)
    public int singleNonDuplicate(int[] nums) {
        int left = -1, right = nums.length;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            int leftPartLen = mid - left;
            int rightPartLen = right - mid;

            if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) {
                if (leftPartLen % 2 == 1) {  // singlet in the left
                    right = mid - 1;
                } else {  // singlet in the right
                    left = mid;
                }
            } else if (mid + 1 < nums.length && nums[mid + 1] == nums[mid]) {
                if (rightPartLen % 2 == 1) {  // singlet in the right
                    left = mid + 1;
                } else {  // singlet in the left
                    right = mid;
                }
            } else return nums[mid];
        }

        return left == -1 ? nums[0] : nums[left];
    }
}