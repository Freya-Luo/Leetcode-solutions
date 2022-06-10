package lc_151_200.LC_189_RotateArray;

class Solution {
    private void reverse(int[] A, int s, int e) {
        int i = s, j = e;

        while (i < j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }
    // O(N); Space: O(1)
    public void rotate(int[] nums, int k) {
        int K = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, K - 1);
        reverse(nums, K, nums.length - 1);
    }
}