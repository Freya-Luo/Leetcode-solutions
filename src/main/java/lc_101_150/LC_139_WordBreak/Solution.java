package lc_101_150.LC_139_WordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    //O(n^3 + k), k: total no.of chars in the wordDict
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        Set<String> set = new HashSet<>(wordDict);

        dp[0] = true;  // s.charAt(-1) -> guardian: true
        for(int i = 1; i <= n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if (dp[j] && set.contains(s.substring(j, i))) { // substring(): O(n)
                    dp[i] = true;
                    break;  // Speed up the looping process !!!
                }
            }
        }
        return dp[n];
    }
}