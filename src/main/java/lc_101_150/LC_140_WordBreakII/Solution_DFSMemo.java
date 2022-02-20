package lc_101_150.LC_140_WordBreakII;

import java.util.*;

// Time: O(N^2 + 2^N + W) = O(2^N) -- W: no.of words in the dictionary
// N: length of string, in the worst case, "aaaaa", ["a", "aa", "aaa", "aaaa", "aaaaa"]
// each prefix k will have 2^(k - 1) possibilities, so sum(2^(k - 1)) (k = 0, ... n) = O(2^k)

// Space: O(N * 2^N + N^2 + W) = O(2^N * N^2 + W)
// N^2 for the map key, 2^N for the possible solutions and for each solution, needs N space
class Solution_DFSMemo {
    private Map<String, List<String>> map = new HashMap<>();

    private List<String> dfs(String s, Set<String> set) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> res = new ArrayList<>();
        if (set.contains(s)) {
            res.add(s);
        }

        for(int i = 1; i < s.length(); i++) {
            String postStr = s.substring(i);
            if (!set.contains(postStr)) continue;
            // from empty prefix to a larger prefix
            List<String> temp = dfs(s.substring(0, i), set);
            if (temp.size() != 0) {
                for(String each: temp) {
                    res.add(each + " " + postStr);
                }
            }
        }
        map.put(s, res);
        return res;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return dfs(s, set);
    }
}
