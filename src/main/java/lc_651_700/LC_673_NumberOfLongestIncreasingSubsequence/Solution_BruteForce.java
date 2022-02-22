package lc_651_700.LC_673_NumberOfLongestIncreasingSubsequence;

class Solution_BruteForce {
    // O(n^2)
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n], cnt = new int[n];

        int max = 0, maxCnt = 0;
        for(int i = 0; i < n; i++) {
            len[i] = cnt[i] = 1;
            for(int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) continue;

                if (len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;
                    cnt[i] = cnt[j];
                } else if (len[i] == len[j] + 1) {
                    cnt[i] += cnt[j];
                }
            }
            if (max <= len[i]) {
                if (max < len[i]) {
                    max = len[i];
                    maxCnt = cnt[i];
                } else {
                    maxCnt += cnt[i];
                }
            }
        }
        return maxCnt;
    }
}
