package lc_501_550.LC_539_MinimumTimeDifference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Using 24 * hh + min.
 */
class Solution {
    public int findMinDifference(List<String> timePoints) {
        ArrayList<Integer> timestamps = new ArrayList<>();

        for(String t : timePoints) {
            String[] parts = t.split(":");
            int time = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
            timestamps.add(time);
        }

        Collections.sort(timestamps);
        // Get the min difference
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < timestamps.size(); i++) {
            min = Math.min(min, timestamps.get(i) - timestamps.get(i - 1));
        }
        // 00 hour NEEDS to add wrap around time
        int wraptime = timestamps.get(0) + 24 * 60 - timestamps.get(timestamps.size() - 1);
        return Math.min(wraptime, min);
    }
}
