package lc_851_900.LC_886_PossibleBipartition;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution_BFS {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for(int[] path: dislikes) {
            graph[path[0]].add(path[1]);
            graph[path[1]].add(path[0]);
        }

        int[] groups = new int[n + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            if (groups[i] != 0) continue;

            deque.offer(i);
            groups[i] = 1;
            while (!deque.isEmpty()) {
                int cur = deque.poll();
                int group = groups[cur];

                for(int next: graph[cur]) {
                    if (groups[next] == group) return false;
                    if (groups[next] != 0) continue;
                    groups[next] = -group;
                    deque.offer(next);
                }
            }
        }
        return true;
    }
}
