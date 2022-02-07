package lc_301_350.LC_332_ReconstructItinerary;

import java.util.*;

// Time: O(E* logE + E)
// Space: (V + 2E)
class Solution_Eulerian {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adjList = new HashMap<>();
        for(List<String> t : tickets) {
            adjList.putIfAbsent(t.get(0), new ArrayList<>());
            adjList.get(t.get(0)).add(t.get(1));
        }
        // sort the searching outgoing edges
        for(String from: adjList.keySet()) {
            Collections.sort(adjList.get(from));  // worst case, 1 V can have E/2 edges (already guarantee there is an Eulerian Path)
            // then, big O could be O((E/2) * log (E/2)) = O(E*logE)
        }

        List<String> res = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        // O(E)
        while (!stack.isEmpty()) {
            String cur = stack.peek();

            if (adjList.get(cur) != null && adjList.get(cur).size() != 0) { // has neighbors
                List<String> neighbors = adjList.get(cur);
                stack.push(neighbors.remove(0));  // remove any edge
            }else {  // no neighbors
                // should also consider when cur is not the adjList (like endpoints with no out edges)
                // Otherwise, may get infinite loop
                res.add(0, cur);  // add to the path
                stack.pop();
            }
        }

        return res;
    }
}
