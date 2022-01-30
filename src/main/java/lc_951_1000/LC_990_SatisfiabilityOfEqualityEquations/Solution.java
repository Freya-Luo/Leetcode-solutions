package lc_951_1000.LC_990_SatisfiabilityOfEqualityEquations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private class UF {
        char[] parents;
        int[] sizes;

        UF(int n) {
            parents = new char[n];
            sizes = new int[n];

            Arrays.fill(parents, '\0');
            Arrays.fill(sizes, 1);
        }

        private char find(char c) {
            int id = c - 'a';
            if (parents[id] == '\0') return c;
            return parents[id] = find(parents[id]);
        }
        // Note: it is better to keep union consistent, not try to change / implement
        // too much logic in the union
        void union(char a, char b) {
            char pa = find(a);
            char pb = find(b);

            if (pa == pb) return;

            int ipa = pa - 'a', ipb = pb - 'a';
            if (sizes[ipa] < sizes[ipb]) {
                parents[ipa] = pb;
                sizes[ipb] += sizes[ipa];
            } else {
                parents[ipb] = pa;
                sizes[ipa] += sizes[ipb];
            }
        }
    }
    // Time: O(N); Space: O(1)
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        List<Integer> falsy = new ArrayList<>();

        for(int i = 0; i < equations.length; i++) {
            String s = equations[i];

            if (s.charAt(1) == '=') {
                uf.union(s.charAt(0), s.charAt(3));
            } else falsy.add(i);
        }

        for(int i : falsy) {
            String s = equations[i];
            if (uf.find(s.charAt(0)) == uf.find(s.charAt(3))) return false;
        }
        return true;
    }
}
