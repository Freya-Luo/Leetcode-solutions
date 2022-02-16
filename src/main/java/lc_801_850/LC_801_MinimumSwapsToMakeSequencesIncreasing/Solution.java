package lc_801_850.LC_801_MinimumSwapsToMakeSequencesIncreasing;

class Solution {
    // O(n)
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int[] swap = new int[n], noSwap = new int[n];

        swap[0] = 1;
        for(int i = 1; i < n; i++) {
            swap[i] = noSwap[i] = n;
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                swap[i] = swap[i - 1] + 1;
                noSwap[i] = noSwap[i - 1];
            }

            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                swap[i] = Math.min(swap[i], noSwap[i - 1] + 1);
                noSwap[i] = Math.min(swap[i - 1], noSwap[i]);
            }
        }
        return Math.min(swap[n - 1], noSwap[n - 1]);
    }
}