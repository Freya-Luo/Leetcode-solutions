package LC_528_RandomPickWithWeight;

class Solution {
    private int[] preSum;
    private int totalSum;

    // O(n)
    public Solution(int[] w) {
        preSum = new int[w.length];

        preSum[0] = w[0];
        totalSum = w[0];
        for(int i = 1; i < w.length; i++) {
            preSum[i] = preSum[i - 1] + w[i];
            totalSum += w[i];
        }
    }
    // O(logN)
    public int pickIndex() {
        double target = (Math.random() * totalSum);

        int left = -1, right = preSum.length;;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (preSum[mid] < target) {
                left = mid;
            } else right = mid;
        }
        return left + 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */