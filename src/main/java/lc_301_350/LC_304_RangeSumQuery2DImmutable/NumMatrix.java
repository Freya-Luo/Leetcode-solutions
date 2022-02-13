package lc_301_350.LC_304_RangeSumQuery2DImmutable;

class NumMatrix {
    private int[][] sum;
    // Time: O(m * n)
    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        sum = new int[m][n];
        // initialization of 1st row and column pre sum
        sum[0][0] = matrix[0][0];
        for (int j = 1; j < n; j++) sum[0][j] = matrix[0][j] + sum[0][j - 1];
        for (int i = 1; i < m; i++) sum[i][0] = matrix[i][0] + sum[i - 1][0];

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i -1][j] + matrix[i][j] - sum[i - 1][j - 1];
            }
        }
    }
    // Time: O(1)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int upSum = 0, leftSum = 0, upLeftSum = 0;
        if (row1 != 0) {
            upSum = sum[row1 - 1][col2];
        }

        if (col1 != 0) {
            leftSum = sum[row2][col1 - 1];
        }

        if (row1 != 0 && col1 != 0) {
            upLeftSum = sum[row1 - 1][col1 - 1];
        }

        return sum[row2][col2] - upSum - leftSum + upLeftSum;
    }
}
/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */