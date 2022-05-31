package lc_301_350.LC_301_RemoveInvalidParentheses;

import java.util.*;

/**
 * Each node/state is a string removed by a '(' or ')'.
 *
 * The k-th level removes k single bracket. If a valid string is found, then this must be
 * the string formed by min removal. In order to find all possible min removal string, we only
 * continue searching only on this level.
 *
 * T(n) = 1 x C(n, 1) + (n-1) x C(n, n-1) + ... + n x C(n, n)  = n x 2^(n-1)
 */
class Solution {
    private boolean isValid(String s) {
        int count = 0;

        for(char c: s.toCharArray()) {
            if (c == '(') {
                count += 1;
            }
            if (c == ')') {
                count -= 1;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();

        HashSet<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();

        boolean reachMinLevel = false; // has already reached to the min removal level, find all other possible values in this level

        visited.add(s);
        queue.add(s);

        while (!queue.isEmpty()) {
            String curS = queue.poll();

            if (isValid(curS)) {
                res.add(curS);
                reachMinLevel = true;
            }

            // only search to the next level if we do not find any valid string in this level
            if (!reachMinLevel) {
                for(int i = 0; i < curS.length(); i++) {
                    if (curS.charAt(i) == '(' || curS.charAt(i) == ')') {
                        String newS = curS.substring(0, i) + curS.substring(i + 1);

                        if (!visited.contains(newS)) {
                            visited.add(newS);
                            queue.add(newS);
                        }
                    }
                }
            }
        }
        return res;
    }
}