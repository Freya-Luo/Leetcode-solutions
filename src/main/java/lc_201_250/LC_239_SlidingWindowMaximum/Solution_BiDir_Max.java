package lc_201_250.LC_239_SlidingWindowMaximum;

class Solution_BiDir_Max {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int[] res = new int[N - k + 1];

        int[] leftDirMax = new int[N];
        int[] rightDirMax = new int[N];

        leftDirMax[0] = nums[0];
        rightDirMax[N - 1] = nums[N - 1];
        for(int leftIdx = 1; leftIdx < N ; leftIdx++) {
            // Find max from the left direction (merge to left)
            if (leftIdx % k == 0) {
                leftDirMax[leftIdx] = nums[leftIdx];
            } else {
                leftDirMax[leftIdx] = Math.max(leftDirMax[leftIdx - 1], nums[leftIdx]);
            }

            // Find max from the right direction (merge to right)
            int rightIdx = N - 1 - leftIdx;
            if ((rightIdx + 1) % k == 0) {
                rightDirMax[rightIdx] = nums[rightIdx];
            } else {
                rightDirMax[rightIdx] = Math.max(rightDirMax[rightIdx + 1], nums[rightIdx]);
            }
        }

        for(int i = 0; i < N - k + 1; i++) {
            res[i] = Math.max(rightDirMax[i], leftDirMax[i + k - 1]);
        }
        return res;
    }
}
