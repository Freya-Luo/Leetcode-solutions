package lc_1201_1250.LC_1202_SmallestStringWithSwaps;

import java.util.*;

class Solution {
    private int find(int x, int[] parents){
        if (parents[x] == -1) return x;
        return parents[x] = find(parents[x], parents);  // path compression needed
    }

    private void union(int x, int y, int[] parents) {
        int px = find(x, parents);
        int py = find(y, parents);

        if (px == py) return;
        parents[px] = py;
    }
    // Time: O(M + N + M * logK) - N: s.length(); M:pairs.size(); K: avg group size
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // Key: find all the connected components, taking index as the node
        int[] parents = new int[s.length()];
        Arrays.fill(parents, -1);

        for(List<Integer> pair: pairs) {
            union(pair.get(0), pair.get(1), parents);  // O(M * α(M)) ~ O(M)
        }

        Map<Integer, List<Character>> groups = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            int pi = find(i, parents);
            groups.putIfAbsent(pi, new LinkedList<>());
            groups.get(pi).add(s.charAt(i));
        }

        for(int i : groups.keySet()) {
            Collections.sort(groups.get(i));  //O(M* logK) worst case: K == N
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            int pi = find(i, parents);
            sb.append(groups.get(pi).remove(0));
        }
        return sb.toString();  // O(N)
    }
}