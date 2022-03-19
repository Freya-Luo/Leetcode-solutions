package lc_1851_1900.LC_1891_CuttingRibbons;

/**
 * The length of ribbon can only between 1 and max length. So, we do binary search to find
 * at this length L, can we cut enough ribbons so that the number of ribbons with length L
 * is greater than K?
 *
 * If yes, can we find a larger L as we want to max this value?
 * If not, we should shrink the range and try to find a smaller L.
 */
class Solution {
    private boolean canCut(int[] ribs, int size, int k) {
        int count = 0;
        for(int len : ribs) {
            count += len/size;
        }
        return count >= k;
    }
    // O(N*log(max(ribbons[i])))
    public int maxLength(int[] ribbons, int k) {
        int max = -1;
        for(int len: ribbons) {
            max = Math.max(max, len);
        }

        int lo = 1, hi = max;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (canCut(ribbons, mid, k)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi > 0 ? hi : 0;
    }
}