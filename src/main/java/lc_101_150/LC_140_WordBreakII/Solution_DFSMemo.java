package lc_101_150.LC_140_WordBreakII;

import java.util.*;

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
