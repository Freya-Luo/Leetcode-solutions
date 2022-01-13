package LC_992_SubarraysWithKDifferentIntegers;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private int subsWithAtMostK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        int subs = 0, beg = 0, end = 0;
        int curDiffNum = 0;
        while (end < n) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            if (map.get(nums[end]) == 1) curDiffNum++;

            while (beg <= end && curDiffNum > k) {
                map.put(nums[beg], map.get(nums[beg]) - 1);
                if (map.get(nums[beg]) == 0) curDiffNum--;
                beg++;
            }
            subs += (end - beg + 1);
            end++;
        }
        return subs;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subsWithAtMostK(nums, k) - subsWithAtMostK(nums, k - 1);
    }

}