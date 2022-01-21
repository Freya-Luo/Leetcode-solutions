package lc_401_450.LC_403_FrogJump;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// In this way, I feel this solution can also be considered as DP solution
class Solution_DFS_DP0 {
    /**
     * Time: O(n^2)
     * @param des destination stone
     * @param map <Stone, JumpUnit> map: record each jump unit happens at this stone
     * @param curStone current stone
     * @param jump current jump unit
     * @return
     */
    private boolean dfs(int des, Map<Integer, Set<Integer>> map, int curStone, int jump) {
        if (curStone == des) return true;

        if (jump <= 0)  return false; // !!! Don't forget

        if (!map.containsKey(curStone) || map.get(curStone).contains(jump))
            return false;

        for(int i = -1; i <= 1; i++) {
            int nextStone = jump + i + curStone;

            if (map.containsKey(nextStone)) {
                if (dfs(des, map, nextStone, jump + i)) {
                    return true;
                }
            }
        }
        // all the `k-1, k , k+1` possibilities failed, record this jump k at stone S
        map.get(curStone).add(jump);
        return false;
    }

    public boolean canCross(int[] stones) {
        // <Stone, JumpUnit>
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < stones.length; i++) {
            map.putIfAbsent(stones[i], new HashSet<>());
        }
        return dfs(stones[stones.length - 1], map, 1, 1);
    }
}