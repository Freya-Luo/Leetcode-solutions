package lc_251_300.LC_279_PerfectSquares;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution_BFS {
    // Time: O(n ^(h/2)) h: height of the N-ary tree
    // Space: O(n ^(h/2)): max no.of nodes that can appear at the level h
    public int numSquares(int n) {
        Deque<int[]> deque = new ArrayDeque<>();
        Set<Integer> seen = new HashSet<>();
        deque.offer(new int[]{0, 0});
        seen.add(0);

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int curnode = cur[0], curlevel = cur[1];

            if (curnode == n) return curlevel;
            // if (curnode > n) continue;

            for(int i = 1; curnode + i * i <= n; i++) {
                int next = curnode + i * i;
                if (!seen.contains(next)) {
                    deque.offer(new int[]{next, curlevel + 1});
                    seen.add(next);
                }
            }
        }
        return 0;
    }
}
