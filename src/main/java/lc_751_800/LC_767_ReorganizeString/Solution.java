package lc_751_800.LC_767_ReorganizeString;

class Solution {
    // O(n)
    public String reorganizeString(String s) {
        int[] counter = new int[26];
        char[] res = new char[s.length()];

        for(char c: s.toCharArray()) {
            counter[c - 'a']++;
        }
        // Find the max char count and the corresponding char
        int max = 0, maxC = 0;
        for(int i = 0; i < 26; i++) {
            if (counter[i] > max) {
                max = counter[i];
                maxC = i;
            }
        }
        if (max > (s.length() + 1) / 2) return "";

        int nextIdx = 0;
        char nextChar = (char)(maxC + 'a');
        while (max-- > 0) {
            res[nextIdx] = nextChar;
            nextIdx += 2;
        }
        counter[maxC] = 0; // remove the count of maxC in the counter

        int i = 0;
        while(i < 26) {
            nextChar = (char)(i + 'a');
            while (counter[i]-- > 0) {
                if (nextIdx >= s.length()) {
                    nextIdx = 1;
                }
                res[nextIdx] = nextChar;
                nextIdx += 2;
            }
            i++;
        }

        return String.valueOf(res);
    }
}