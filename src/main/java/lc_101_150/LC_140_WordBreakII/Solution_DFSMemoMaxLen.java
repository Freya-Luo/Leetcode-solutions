package lc_101_150.LC_140_WordBreakII;

import java.util.*;

// Time: O(N^2 + 2^N + W) = O(2^N) -- W: no.of words in the dictionary
// N: length of string, in the worst case, "aaaaa", ["a", "aa", "aaa", "aaaa", "aaaaa"]
// each prefix k will have 2^(k - 1) possibilities, so sum(2^(k - 1)) (k = 0, ... n) = O(2^k)

// Space: O(N * 2^N + N + W) = O(2^N * N + W)
// N for the map key, 2^N for the possible solutions and for each solution, needs N space
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
            String prefix = s.substring(cur, i + 1);
            if (!set.contains(prefix)) continue;

            List<String> temp = dfs(s, set, i + 1, maxLen);
            for(String each: temp) {
                if (each.equals("")) res.add(prefix);
                else res.add(prefix + " " + each);
            }
            /** Invalid concatenation condition */
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
