package lc_401_450.LC_410_SplitArrayLargestSum;

class Solution_BS {
    private boolean canSplit(int[] nums, int m, int bound) {
        int sum = 0, times = 1;
        for(int num : nums) {
            sum += num;
            if (sum > bound) {
                sum = num;
                times++;
                if (times > m) return false;
            }
        }
        return true;
    }
    // Time: O(n * log(sum))
    public int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        for(int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int lo = max, hi = sum;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canSplit(nums, m, mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
