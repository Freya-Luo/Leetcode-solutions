package lc_1851_1900.LC_1868_ProductofTwoRunLengthEncodedArrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    /*
     * Revise:  merging the result along the way instead of merging afterwards
     * O(m + n)
     */
    public List<List<Integer>> findRLEArray(int[][] e1, int[][] e2) {
        List<List<Integer>> res = new LinkedList<>();
        int p1 = 0, p2 = 0;

        // set the 1st encoded array to be the main array
        while (p1 < e1.length) {
            int occur = Math.min(e1[p1][1], e2[p2][1]);
            int multiply = e1[p1][0] * e2[p2][0];

            // check if the previous one has the same multiplication result
            int n = res.size();
            if (n > 0 && res.get(n - 1).get(0) == multiply) {
                List<Integer> prev = res.get(n - 1);
                res.set(n - 1, Arrays.asList(prev.get(0), prev.get(1) + occur));
            } else {
                res.add(Arrays.asList(multiply, occur));
            }

            e1[p1][1] -= occur;
            if (e1[p1][1] == 0) p1++;
            e2[p2][1] -= occur;
            if (e2[p2][1] == 0) p2++;
        }

        return res;
    }
}