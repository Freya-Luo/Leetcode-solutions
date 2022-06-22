package lc_251_300.LC_269_AlienDictionary;

import java.util.*;

// O(C), where C is the total length of every letter in the words[]
class Solution {
    private HashMap<Character, List<Character>> adjList = new HashMap<>();
    private HashMap<Character, Integer> indegs = new HashMap<>();

    private boolean buildGraph(String[] words) {
        // initialize adjList and indegs hash maps
        // O(C)
        for(String w : words) {
            for(char c: w.toCharArray()) {
                adjList.put(c, new ArrayList<>());
                indegs.put(c, 0);
            }
        }

        // only find the first non-matched char pair in adjacent words
        // to make an edge between them
        // O(C)
        for(int i = 0, j = 1; j < words.length; i++, j = i + 1) {
            String w1 = words[i], w2 = words[j];
            // If the 2nd one is the 1st one's prefix,
            // then we cannot infer any chars order from this pair
            if (w1.startsWith(w2) && w1.length() > w2.length()) return false;

            int min = Math.min(w1.length(), w2.length());
            int k = 0;
            while (k < min) {
                char c1 = w1.charAt(k), c2 = w2.charAt(k);
                if (c1 != c2) {
                    adjList.get(c1).add(c2);
                    indegs.put(c2, indegs.get(c2) + 1);
                    break;
                }
                k++;
            }
        }
        return true;
    }

    public String alienOrder(String[] words) {
        // build the graph
        if (!buildGraph(words)) return "";

        // do topological sort
        // O(V + E), V: at most 26 unique letters (nodes); E: at most N - 1 edges, where N = words.length
        // Because only one edge can be generated from each pair.
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(char c : indegs.keySet()) {
            if (indegs.get(c) == 0) {
                queue.add(c);
                // safely add here as we set up a checker below
                sb.append(c);
            }
        }

        while (!queue.isEmpty()) {
            char cur = queue.poll();
            for(char next : adjList.remove(cur)) {
                indegs.put(next, indegs.get(next) - 1);
                if (indegs.get(next) == 0) {
                    queue.add(next);
                    sb.append(next);
                }
            }
        }
        // cannot get all unique chars done, so not a clear answer for this sequence of chars
        if (sb.length() < indegs.size()) return "";

        return sb.toString();
    }
}