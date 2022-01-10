package LC_472_ConcatenatedWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution_DP {
    /**
     * Time: O(N * M^3) - N: words.length; M : avg length of word.length
     * Space: O(N + M)
     */
    private boolean DPWalk(String word, HashSet<String> preWords) {
        if (preWords.isEmpty()) return false;

        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        // O(M^3)
        for(int end = 1; end <= word.length(); end++) {
            for(int start = 0; start < end; start++) {
                if (dp[start] && preWords.contains(word.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        // O(nlogn)
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        HashSet<String> preWords = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            if (DPWalk(words[i], preWords)) {
                res.add(words[i]);
            }
            preWords.add(words[i]);
        }

        return res;
    }
}