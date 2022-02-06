package lc_801_850.LC_841_KeysAndRooms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    // Time: O(n) & Space
    private boolean dfs(List<List<Integer>> rooms, int cur, Set<Integer> seen) {
        if (seen.contains(cur)) return true;
        seen.add(cur);

        for(int key : rooms.get(cur)) {
            dfs(rooms, key, seen);
        }
        return rooms.size() == seen.size();
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        return dfs(rooms, 0, new HashSet<>());
    }
}