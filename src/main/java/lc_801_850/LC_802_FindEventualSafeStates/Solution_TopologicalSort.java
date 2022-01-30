package lc_801_850.LC_802_FindEventualSafeStates;

import java.util.*;

class Solution_TopologicalSort {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> res = new ArrayList<Integer>();

        Deque<Integer> deque = new ArrayDeque<>();
        // <NodeTo, Set<NodeFrom>> reverse edge
        Map<Integer, Set<Integer>> reverses = new HashMap<>();
        int[] outs = new int[n];  // instead of indegrees[], using outdegrees[]

        for(int i = 0; i < n; i++) {
            outs[i] += graph[i].length;
            for(int ni: graph[i]) {
                reverses.putIfAbsent(ni, new HashSet<>());
                reverses.get(ni).add(i);
            }
            if (graph[i].length == 0) {
                deque.offer(i);   // start from all the nodes with 0 outdegree
            }
        }

        while (!deque.isEmpty()) {
            int cur = deque.poll();
            res.add(cur);   // 0 outgoing edges, safe nodes

            if (!reverses.containsKey(cur)) continue;  // need to check existence

            for(int ni: reverses.get(cur)) {
                outs[ni]--;
                if (outs[ni] == 0)
                    deque.offer(ni);
            }
        }
        Collections.sort(res);
        return res;
    }
}
