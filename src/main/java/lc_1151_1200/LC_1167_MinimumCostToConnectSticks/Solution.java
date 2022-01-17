package lc_1151_1200.LC_1167_MinimumCostToConnectSticks;

import java.util.Arrays;
import java.util.PriorityQueue;

// 1648 370 1481
class Solution {
    // Greedy O(n) - PQ
    public int connectSticks(int[] sticks) {
        Integer[] arr = Arrays.stream(sticks).boxed().toArray(Integer[]::new);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays.asList(arr));

        int res = 0;
        while(pq.size() != 1) {
            int cost = pq.poll() + pq.poll();

            res += cost;
            pq.offer(cost);
        }
        return res;
    }
}