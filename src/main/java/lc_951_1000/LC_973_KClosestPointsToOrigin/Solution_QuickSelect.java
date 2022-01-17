package lc_951_1000.LC_973_KClosestPointsToOrigin;

import java.util.Arrays;

// O(N) N: points.length
class Solution_QuickSelect {
    private int calDistSqr(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    private void quickSelect(int[][] points, int k, int left, int right) {
        if (left >= right) {
            return;
        }

        int pIdx = (right - left) / 2 + left;
        int[] pivot = points[pIdx];
        int pivotDist = calDistSqr(pivot);
        swap(points, pIdx, right);

        int i = left, curPIdx = left;
        while (i < right) {
            if (calDistSqr(points[i]) <= pivotDist) {
                swap(points, i, curPIdx);
                curPIdx++;
            }
            i++;
        }

        swap(points, curPIdx, right);

        int num = curPIdx - left  + 1;

        if (num == k) return;
        if (num < k) quickSelect(points, k - num, curPIdx + 1, right);
        if (num > k) quickSelect(points, k, left, curPIdx - 1);
    }

    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, k, 0, points.length - 1);
        return Arrays.copyOf(points, k);
    }
}
