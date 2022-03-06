package lc_1_50.LC_44_WildcardMatching;

class Solution_Backtrack {
    // Time: avg O(SlogP);  worst case: O(S * P)
    // Space: O(1)
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();

        int si = 0, pi = 0;
        int lastGuess = -1, lastStar = -1;

        while (si < slen) {
            if (pi < plen && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?')) {
                si++;
                pi++;
            } else if (pi < plen && p.charAt(pi) == '*') {
                lastGuess = si;
                lastStar = pi;
                // si++;
                pi++;
            } else if (lastStar > -1) { // means there is a star before, and prev guess is wrong
                pi = lastStar + 1;
                si = lastGuess + 1; // here, si gradually increases for the 1 more char matching case for '*'
                lastGuess = si;
            } else return false;
        }
        while (pi < plen && p.charAt(pi) == '*') pi++;
        return pi == plen;
    }
}