package lc_1351_1400.LC_1428_LeftmostColumnwithAtLeastAOne;


import java.util.List;

// This is the BinaryMatrix's API interface.
// You should not implement it, or speculate about its implementation
interface BinaryMatrix {
  public int get(int row, int col);
  public List<Integer> dimensions();
};


class Solution {
    // O(m + n)
    public int leftMostColumnWithOne(BinaryMatrix binaryMat) {
        int row = binaryMat.dimensions().get(0);
        int col = binaryMat.dimensions().get(1);

        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            if (binaryMat.get(i, j) == 0) {
                i++;
            } else {
                j--;
            }
        }
        return j == col - 1 ? -1 : j + 1;
    }
}