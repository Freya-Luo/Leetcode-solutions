package lc_451_500.LC_498_DiagonalTraverse;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    // O(mn)
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        HashMap<Integer, LinkedList<Integer>> indexSum = new HashMap<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int sum = i + j; // diagonal elements whose indexes sum are same
                indexSum.putIfAbsent(sum, new LinkedList<>());
                // odd index sum, insert from tail
                if (sum % 2 != 0) {
                    indexSum.get(sum).add(mat[i][j]);
                } else { // even index sum, insert from head
                    indexSum.get(sum).addFirst(mat[i][j]);
                }
            }
        }

        int upper = m + n - 2;
        List<Integer> res = new LinkedList<>();
        for(int i = 0; i <= upper; i++) {
            res.addAll(indexSum.get(i));
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
