package lc_1701_1750.LC_1710_MaximumUnitsOnATruck;

import java.util.Arrays;

class Solution {
    /**
     * Sort + Greedy
     * Time: O(nlogn), n: boxTypes.length
     *
     * Option 2: PriorityQueue, also O(nlogn)
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

        int res = 0, remain = truckSize;
        for(int i = 0; i < boxTypes.length; i++) {
            int numOfBoxes = Math.min(remain, boxTypes[i][0]);

            res += numOfBoxes * boxTypes[i][1];
            remain -= numOfBoxes;
            if (remain == 0) break;
        }
        return res;
    }
}