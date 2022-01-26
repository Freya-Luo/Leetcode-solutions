package lc_301_350.LC_315_CountOfSmallerNumbersAfterSelf;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Time: O(NlogN), N: nums.length
// Space: O(N)
class Solution_MergeSortIndexedArray {
    private void mergeSort(int[] nums, int[] index, int lo, int hi, int[] res) {
        if (lo >= hi) return;

        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, index, lo, mid, res);
        mergeSort(nums, index, mid + 1, hi, res);

        // merge
        int i = lo, j = mid + 1;
        int[] merged = new int[hi - lo + 1];

        int lessNumCnt = 0, nextIdx = 0;
        while (i < mid + 1 && j <= hi) {
            if (nums[index[i]] <= nums[index[j]]) {  // head of left subarr <= head of right subarr; duplicates
                res[index[i]] += lessNumCnt;
                merged[nextIdx++] = index[i++];
            } else {
                lessNumCnt++;
                merged[nextIdx++] = index[j++];
            }
        }

        while (i < mid + 1) {
            res[index[i]] += lessNumCnt;
            merged[nextIdx++] = index[i++];
        }

        while (j <= hi) {
            merged[nextIdx++] = index[j++];
        }

        // copy back to the original index array
        for(int k = lo; k <= hi; k++) {
            index[k] = merged[k - lo];
        }
        return;
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] index = new int[n];
        for(int i = 0; i < n; i++) {
            index[i] =  i;
        }

        int[] res = new int[n];
        mergeSort(nums, index, 0, n - 1, res);
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }
}
