package LC_1570_DotProductOfTwoSparseVectors;

import java.util.HashMap;
import java.util.Map;

// Time: O(N)
// Space: O(L) -- L: number of non-zero elements.
class SparseVector {
    private Map<Integer, Integer> map;

    public Map<Integer, Integer> computeRevisedVector() {
        return this.map;
    }

    SparseVector(int[] nums) {
        map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;

        Map<Integer, Integer> otherMap = vec.computeRevisedVector();
        for(int i : this.map.keySet()) {
            if (otherMap.containsKey(i)) {
                res += this.map.get(i) * otherMap.get(i);
            }
        }
        return res;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);