package lc_101_150.LC_140_WordBreakII;

import java.util.*;

class Solution_DFSMemoMaxLen {
    private Map<Integer, List<String>> map = new HashMap<>();

    private List<String> dfs(String s, Set<String> set, int cur, int maxLen) {
        if (map.containsKey(cur)) {
            return map.get(cur);
        }

        List<String> res = new ArrayList<>();
        if (cur == s.length()) {
            res.add("");
            return res;
        }

        for(int i = cur; i < cur + maxLen && i < s.length(); i++) {
            String prev = s.substring(cur, i + 1);
            if (!set.contains(prev)) continue;

            List<String> temp = dfs(s, set, i + 1, maxLen);
            for(String each: temp) {
                if (each.equals("")) res.add(prev);
                else res.add(prev + " " + each);
            }
            // if (temp.size() != 0) {
            //     for(String each: temp) {
            //         res.add(prev + " " + each);
            //     }
            // }else {
            //     res.add(prev);
            // }
        }
        map.put(cur, res);
        return res;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        int maxLen = 0;
        for(String word: wordDict) {
            set.add(word);
            maxLen = Math.max(maxLen, word.length());
        }
        return dfs(s, set, 0,  maxLen);
    }
}
