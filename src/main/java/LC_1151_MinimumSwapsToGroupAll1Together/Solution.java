package LC_1151_MinimumSwapsToGroupAll1Together;

class Solution {
    // Sliding window - (count min 0's)

    /**
     * Time: O(n) both versions
     */
    public int minSwaps(int[] data) {
        int numOfOne = 0;
        for (int num : data) numOfOne += num == 1 ? 1 : 0;

        if (numOfOne == 0) return 0; // for case [0]

        int min = data.length, beg = 0;
        int curOneCnt = 0;
        for(int end = 0; end < data.length; end++) {
            curOneCnt += data[end];

            if (beg < data.length && (end - beg + 1) >= numOfOne) {
                min = Math.min(min, (end - beg + 1) - curOneCnt);
                curOneCnt -= data[beg];
                beg++;
            }
        }
        return min;
    }

    /** ------------------------- Sliding Window (count max 1's) ----------------------- */
    public int minSwaps2(int[] data) {
        int numOfOne = 0;
        for (int num : data) numOfOne += num == 1 ? 1 : 0;

        int maxOne = 0, beg = 0, end = 0;
        int curOneCnt = 0;
        while(end < data.length) {
            curOneCnt += data[end];

            if (end - beg + 1 > numOfOne) {
                curOneCnt -= data[beg];
                beg++;
            }
            maxOne = Math.max(maxOne, curOneCnt);
            end++;
        }

        return numOfOne - maxOne;
    }
}