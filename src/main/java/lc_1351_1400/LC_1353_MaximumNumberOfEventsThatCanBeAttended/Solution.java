package lc_1351_1400.LC_1353_MaximumNumberOfEventsThatCanBeAttended;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    /**
     * Time: O(NlogN + D * logD) N: events.length; M: average number of events in 1 day;
     * Space: O(N)
     */
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int days = 100000;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int attended = 0, eventIdx = 0;
        for(int curDay = 1; curDay <= days; curDay++) {
            while (!pq.isEmpty() && pq.peek() < curDay) {
                pq.poll();
            }

            while (eventIdx < events.length && events[eventIdx][0] == curDay) {
                pq.offer(events[eventIdx][1]);
                eventIdx++;
            }

            if (!pq.isEmpty()) {
                pq.poll();
                attended++;
            }
        }
        return attended;
    }
}