package lc_1_50.LC_44_WildcardMatching;

class Solution_DP {
    // Time: O(S*P); Space: O(S*P)
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        boolean[][] dp = new boolean[plen + 1][slen + 1];
        dp[0][0] = true;

        for(int pi = 1; pi <= plen; pi++) {
            if (p.charAt(pi - 1) == '*') {
                dp[pi][0] = true;
            } else break;
        }

        for(int i = 1; i <= plen; i++) {
            for(int j = 1; j <= slen; j++) {
                if (p.charAt(i - 1) == '*') {
                    // add "*" or add 1 more char to check
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '?');
                }
            }
        }
        return dp[plen][slen];
    }
}
