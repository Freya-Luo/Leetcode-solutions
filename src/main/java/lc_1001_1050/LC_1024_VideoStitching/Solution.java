package lc_1001_1050.LC_1024_VideoStitching;

import java.util.Arrays;

class Solution {
    // Time: O(nlogn), n: clips.length
    public int videoStitching(int[][] clips, int time) {
        int cnt = 0;
        // sort the intervals based on the start time
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        int start = 0, end = 0;

        int i = 0;
        while (start <= end) {
            cnt += 1; // cannot extend further, need more intervals
            int oriEnd = end;
            // greedy to find the furthest point it can reach
            while (i < clips.length)  {
                if (start <= clips[i][0] && clips[i][0] <= oriEnd) {
                    end = Math.max(end, clips[i][1]);
                    if (end >= time) {
                        return cnt;
                    }
                    i++;
                } else break;
            }
            start = oriEnd + 1; // find the next range to search other interval's start time
        }
        return -1;
    }
}