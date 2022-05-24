package lc_501_550.LC_523_ContinuousSubarraySum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // Time: O(n), O(k) space
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        // calculate the presum of the array
        int[] preSum = new int[n + 1];
        Map<Integer, Integer> mods = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            int mod = preSum[i] % k;
            // case 1: mod == 0
            // case 2: (a + (n * k)) % k == (a % k)
            if ((mod == 0 && i != 1)
                    || (mods.containsKey(mod) && i - mods.get(mod) > 1)) {
                return true;
            }

            if (!mods.containsKey(mod)) { // only keep the 1st occurrence index
                mods.put(mod, i);
            }
        }
        return false;
    }
}