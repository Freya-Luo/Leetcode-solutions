package lc_301_350.LC_315_CountOfSmallerNumbersAfterSelf;

import java.util.ArrayList;
import java.util.List;

// Time: 0(NlogM), N: nums.length, M be the differences between min & max (M = max - min + 1)
// Space: 0(M)
class Solution_BITree {
    private class BITree {
        int[] nodes;
        int size;

        BITree(int n) {
            this.nodes = new int[n + 1];  // To access nodes[n], + 1
            this.size = n + 1;
        }

        private int get(int i) {
            int num = 0;
            while (i > 0) {
                num += nodes[i];
                i = i - (i & (-i));
            }
            return num;
        }

        private void update(int i, int delta) {  // delta: updated value
            i = i + 1;
            while (i < this.size) {
                this.nodes[i] += delta;
                i = i + (i & (-i));
            }
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();

        int min = 10001, max = -10001;
        for(int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
        }

        // Construct a new array plus offset => all positive nums to use its binary form
        // shifting them relatively to be within the range [1, n]
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = nums[i] - min + 1;
            max = Math.max(max, arr[i]);
        }

        // Initialize with the max length
        BITree bt = new BITree(max);
        for(int i = n - 1; i >= 0; i--) {
            res.add(0, bt.get(arr[i] - 1));  // -1, to find the smaller ones, not ones <= cur node's value
            bt.update(arr[i], 1);  // update smaller count to cur node and all the parent nodes
        }
        return res;
    }
}
