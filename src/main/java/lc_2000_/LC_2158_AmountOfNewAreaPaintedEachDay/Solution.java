package lc_2000_.LC_2158_AmountOfNewAreaPaintedEachDay;

import java.util.Map;
import java.util.TreeMap;

// Time: O(NlogN) could be risen from the *remove()* operation in the while loop
// Space: O(N)
class Solution {
    public int[] amountPainted(int[][] paint) {
        int[] res = new int[paint.length];
        TreeMap<Integer, Integer> intervals = new TreeMap<>();

        for(int i = 0; i < paint.length; i++) {
            int s = paint[i][0], e = paint[i][1]; // [start, end]
            int len = e - s;

            // merge the left side intervals
            Map.Entry<Integer, Integer> floor = intervals.floorEntry(s);
            if (floor != null) {
                int fStart = floor.getKey(), fEnd = floor.getValue();
                if (fEnd >= e) continue; // floor entry covers the current interval
                if (fEnd >= s) { // (fStart, s, fEnd, e)
                    len -= fEnd - s;
                    intervals.remove(fStart);
                    s = fStart;
                }
            }

            // merge the right side intervals
            // e.g. current [5, 20], ceils: [6, 8], [10, 15], [18, 22]
            Map.Entry<Integer, Integer> ceil;
            while ((ceil = intervals.ceilingEntry(paint[i][0])) != null) {
                int cStart = ceil.getKey(), cEnd = ceil.getValue();
                if (cStart > e) break;
                len -= Math.min(cEnd, e) - cStart;
                e = Math.max(cEnd, e);
                intervals.remove(cStart);
            }
            res[i] = len;
            intervals.put(s, e);
        }
        return res;
    }
}
