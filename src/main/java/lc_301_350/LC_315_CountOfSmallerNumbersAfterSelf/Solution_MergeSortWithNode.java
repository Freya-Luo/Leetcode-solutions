package lc_301_350.LC_315_CountOfSmallerNumbersAfterSelf;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Time: O(NlogN), N: nums.length
// Space: O(N)
class Solution_MergeSortWithNode {
    private class Node {
        int val;
        int oriIdx;

        Node(int val, int idx) {
            this.val = val;
            this.oriIdx = idx;
        }
    }
    private void mergeSort(Node[] arr, int lo, int hi, int[] res) {
        if (lo >= hi) return;

        int mid = lo + (hi - lo) / 2;
        mergeSort(arr, lo, mid, res);
        mergeSort(arr, mid + 1, hi, res);

        // merge
        int i = lo, j = mid + 1;
        Node[] merged = new Node[hi - lo + 1];

        int lessNumCnt = 0, nextIdx = 0;
        while (i < mid + 1 && j <= hi) {
            if (arr[i].val <= arr[j].val) {  // head of left subarr < head of right subarr
                res[arr[i].oriIdx] += lessNumCnt;
                merged[nextIdx++] = arr[i++];

            } else {
                lessNumCnt++;
                merged[nextIdx++] = arr[j++];

            }
        }

        while (i < mid + 1) {
            res[arr[i].oriIdx] += lessNumCnt;
            merged[nextIdx++] = arr[i++];
        }

        while (j <= hi) {
            merged[nextIdx++] = arr[j++];
        }

        // copy back to the original arr
        int ni = lo;
        for(Node n: merged) {
            arr[ni++] = n;
        }
        return;
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Node[] arr = new Node[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new Node(nums[i], i);
        }

        int[] res = new int[n];
        mergeSort(arr, 0, n - 1, res);
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }
}
