package lc_901_950.LC_921_MinimumAddToMakeParenthesesValid;

class Solution {
    // Time: O(N)
    // Space: O(1), keep a var to track the imbalance
    public int minAddToMakeValid(String s) {
        int insert = 0, res = 0;
        for(char c : s.toCharArray()) {
            insert += (c == '(' ? 1 : -1);

            if (insert < 0) { // case like: "()))(("; need to reset
                res += -insert;
                insert = 0;
            }
        }

        return res + insert;
    }
}