package lc_1001_1050.LC_1011_CapacityToShipPackagesWithinDDays;

class Solution {
    // O(n * log(sum(weights) - max(weights[i])))
    public int shipWithinDays(int[] weights, int days) {
        // group consecutive weight[i, ...j] into 1 set with sub-total weight < res
        // , where minimize res
        int left = Integer.MIN_VALUE, right = 1;
        for(int w: weights) {
            left = Math.max(left, w);  // res should >= max package
            right += w; // right could be the sum of the packages
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            // check the groups needed with "mid" as the capacity
            int temp = 0, groups = 1;
            for(int w : weights) { // O(n)
                if (temp + w <= mid) {
                    temp += w;
                } else {
                    temp = w;
                    groups++;
                }
            }

            if (groups <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}