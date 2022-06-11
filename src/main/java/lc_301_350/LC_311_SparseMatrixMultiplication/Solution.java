package lc_301_350.LC_311_SparseMatrixMultiplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A sparse matrix can be represented as a sequence of rows,
 * each of which is a sequence of (column-number, value) pairs of the nonzero values in the row.
 */
class Solution {

    // O(m⋅k⋅n); Space: O(1) (result is not included in auxiliary space
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length, n = mat2[0].length;
        int[][] res = new int[m][n];

        //  create a non-zero map for mat1
        HashMap<Integer, List<int[]>> map1 = new HashMap<>();

        for(int i = 0; i < m; i++) {
            map1.put(i, new ArrayList<>());
            for(int j = 0; j < mat1[0].length; j++) {
                if (mat1[i][j] != 0) {
                    map1.get(i).add(new int[]{j, mat1[i][j]});
                }
            }
        }

        // do multiplication on mat2
        for(int i = 0; i < m; i++) {
            List<int[]> row = map1.get(i);
            for(int k = 0; k < row.size(); k++) {
                int col = row.get(k)[0];
                int num = row.get(k)[1];

                for(int j = 0; j < n; j++) {
                    if (mat2[col][j] != 0) {
                        res[i][j] += num * mat2[col][j];
                    }
                }
            }
        }
        return res;
    }
}