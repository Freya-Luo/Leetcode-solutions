package lc_951_1000.LC_973_KClosestPointsToOrigin;

import java.util.PriorityQueue;

class Solution_MaxPQ {
    /**
     * Time: O(N * logk)
     * Space: O(k)
     */
    private int calDistSqr(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[][] res = new int[k][2];

        for(int i = 0; i < points.length; i++) {
            int[] cur = new int[]{calDistSqr(points[i]), i};
            if (pq.size() < k) {
                pq.offer(cur);
            } else if (pq.peek()[0] > cur[0]) {
                pq.poll();
                pq.offer(cur);
            }
        }

        for(int i = 0; i < k; i++) {
            int idx = pq.poll()[1];
            res[i] = points[idx];
        }
        return res;
    }
}
