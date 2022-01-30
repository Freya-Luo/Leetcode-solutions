package lc_801_850.LC_839_SimilarStringGroups;

class Solution {
    private boolean similarCheck(String a, String b) {
        if (a.length() != b.length()) return false;

        int diff = 0;
        for(int i = 0; i < a.length(); i++) {
            if (diff > 2) break;
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 2 || diff == 0;  // watch case when 2 strings are identical
    }

    private void dfs(String[] strs, int idx) {
        String cur = strs[idx];
        strs[idx] = "";  // label visited on entry

        for(int i = 0; i < strs.length; i++) {
            if (!strs[i].equals("") && similarCheck(cur, strs[i])) { // check visited
                dfs(strs, i);
            }
        }
    }

    // !!! Key: set the visited strings[i] to be ""
    // Time: O(n); Space: O(N) -- stack call
    public int numSimilarGroups(String[] strs) {
        int res = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("")) continue;  // check visited
            dfs(strs, i);
            res++;
        }
        return res;
    }
}