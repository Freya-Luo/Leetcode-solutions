package lc_2000_.LC_2013_DetectSquares;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class DetectSquares {
    private int[][] count;
    private Set<List<Integer>> points;

    public DetectSquares() {
        count = new int[1001][1001];
        points = new HashSet<>();
    }

    // O(1)
    public void add(int[] point) {
        points.add(Arrays.asList(point[0], point[1]));
        count[point[0]][point[1]] += 1;
    }

    // find the diagonal point, which must be not at the same x-axis or y-axis
    // O(T), T: size of points
    public int count(int[] point) {
        int x1 = point[0], y1 = point[1];
        int res = 0;

        for(List<Integer> p : points) {
            int x3 = p.get(0), y3 = p.get(1);
            if (x3 == x1 || y3 == y1 || Math.abs(x3 - x1) != Math.abs(y3 - y1)) continue;
            res += count[x3][y3] * count[x3][y1] * count[x1][y3];
        }
        return res;
    }
}
