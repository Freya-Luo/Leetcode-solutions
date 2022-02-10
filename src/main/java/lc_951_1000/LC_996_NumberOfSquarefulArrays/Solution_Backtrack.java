package lc_951_1000.LC_996_NumberOfSquarefulArrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Time: O(M * (M -1)!) = 0(M!) -- M: number of unique nums in nums[]
// - If all numbers in nums[] are unique, then O(N!)
// - If all numbers in nums[] are same, then will reduce to O(N)
class Solution_Backtrack {

    // Time: O((M - 1)!): M: unique number in the graph.keySet()
    private int dfs(Map<Integer, Set<Integer>> graph, Map<Integer, Integer> count,
                    int cur, int remain) {
        int pathNum = 0;
        remain -= 1;
        count.put(cur, count.get(cur) - 1);
        if (remain == 0) {
            pathNum = 1;
        } else {
            for (int next : graph.get(cur)) {
                if (count.get(next) > 0) {
                    pathNum += dfs(graph, count, next, remain);
                }
            }
        }
        count.put(cur, count.get(cur) + 1);
        return pathNum;
    }

    public int numSquarefulPerms(int[] nums) {
        // consider the duplicates & decrease the computation times
        Map<Integer, Integer> count = new HashMap<>();  // keep each node's occurrence
        Map<Integer, Set<Integer>> graph = new HashMap<>(); // keep the unique edge in the graph

        for(int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            graph.putIfAbsent(num, new HashSet<>());
        }
        // O(N^2): N : nums.length
        for (int n1 : graph.keySet()){
            for(int n2: graph.keySet()) {
                double res = Math.sqrt(n1 + n2);
                if ((res - Math.floor(res)) == 0) {
                    graph.get(n1).add(n2);
                    graph.get(n2).add(n1);
                }
            }
        }

        int res = 0;
        for(int n: graph.keySet()) {  // O(M * T(dfs)): M: graph.size(), unique number in nums[]
            res += dfs(graph, count, n, nums.length);
        }
        return res;
    }
}