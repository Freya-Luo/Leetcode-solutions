package lc_851_900.LC_875_KokoEatingBananas;

class Solution {
    // O(n * log(max(piles[i])))
    public int minEatingSpeed(int[] piles, int h) {
        // sum(ceil(piles[i]/res)) <= h, where keep res as min as possible
        int left = 1, right = 1;
        for(int p : piles) {
            right = Math.max(p, right);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int spent = 0;
            for(int p : piles) { // O(n)
                spent += (int) Math.ceil((double) p / mid);
            }

            if (spent <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
