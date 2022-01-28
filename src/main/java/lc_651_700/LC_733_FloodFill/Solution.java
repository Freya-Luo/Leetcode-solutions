package lc_651_700.LC_733_FloodFill;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean isValid(int[][] mat, int x, int y) {
        if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length)
            return false;
        return true;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        // Key!! must check the value difference, otherwise infinite stack calls
        if (target == newColor) return image;

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            for(int [] dir : dirs) {
                int nX = dir[0] + cur[0];
                int nY = dir[1] + cur[1];

                if (isValid(image, nX, nY) && image[nX][nY] == target) {
                    image[nX][nY] = newColor;
                    deque.offer(new int[]{nX, nY});
                }
            }
        }
        return image;
    }
}