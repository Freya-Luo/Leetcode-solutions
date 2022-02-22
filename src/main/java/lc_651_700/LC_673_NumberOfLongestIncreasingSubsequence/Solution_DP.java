package lc_651_700.LC_673_NumberOfLongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.List;

class Solution_DP {
    // Time: O(nlogn); Space: O(n)
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        List<int[]>[] store = new ArrayList[n]; // List<tailNum, accCnt> -> <tailNum, accCnt>
        for(int i = 0; i < n; i++) {
            store[i] = new ArrayList<>();
        }
        int len = 0;
        for(int num : nums) {
            int left = 0, right = len;
            while (left < right) {
                int mid = left + (right - left) /2;
                int tailNum = store[mid].get(store[mid].size() - 1)[0];
                if (tailNum < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // here, store.get(left - 1) would be the list we're going to search,
            // which holds the list of the current length - 1
            // as we need to find how many suitable "length - 1" tailing nums can this nums[i]
            // append to the end
            int smaller = 1, idx = left - 1;
            if (idx >= 0) {
                int lo = 0, hi = store[idx].size();
                while (lo < hi) {
                    int mid = lo + (hi - lo) / 2;
                    int tailNum = store[idx].get(mid)[0];
                    if (tailNum < num) {
                        hi = mid;
                    } else {
                        lo = mid + 1;
                    }
                }
                int largerSum = lo == 0 ? 0 : store[idx].get(lo - 1)[1];
                smaller = store[idx].get(store[idx].size() - 1)[1] - largerSum;
            }

            if (store[left].size() == 0) {  // first explore this length, add length by 1
                store[left].add(new int[]{num, smaller});
                len++;
            } else {
                store[left].add(new int[]{num, store[left].get(store[left].size() - 1)[1] + smaller});
            }
        }
        return store[len - 1].get(store[len - 1].size() - 1)[1];
    }
}
