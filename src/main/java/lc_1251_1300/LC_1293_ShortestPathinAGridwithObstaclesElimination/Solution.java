package lc_1251_1300.LC_1293_ShortestPathinAGridwithObstaclesElimination;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Using state (e.g., Cell) to keep track of remaining quota to eliminate the obstacles.
 */
class Solution {
    private int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    // Overwriting hashCode & equals to use the return value to identify equality in the hash set
    class Cell {
        int x;
        int y;
        int kleft;
        int step;

        public Cell(int x, int y, int kleft, int step) {
            this.x = x;
            this.y = y;
            this.kleft = kleft;
            this.step = step;
        }

        @Override
        public int hashCode() {
            int prime = 13;

            int res = 1;
            res = res * 31 + x;
            res = res * 31 + y;
            res = res * 31 + kleft;
            return res;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null || obj.getClass()!= this.getClass())
                return false;

            Cell o = (Cell) obj;
            return (this.x == o.x) && (this.y == o.y) && (this.kleft == o.kleft);
        }

    }

    private boolean isValid(int x, int y, int row, int col) {
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return false;
        }
        return true;
    }
    // Time and Space: O(mnk)
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        Deque<Cell> queue = new ArrayDeque<>();
        Set<Cell> visited = new HashSet<>();

        Cell src = new Cell(0, 0, k, 0);
        queue.add(src);
        visited.add(src);

        while (!queue.isEmpty()) {
            Cell cur = queue.poll();

            if (cur.x == m - 1 && cur.y == n - 1) return cur.step;
            for(int[] dir : dirs) {
                int nX = cur.x + dir[0];
                int nY = cur.y + dir[1];

                if (isValid(nX, nY, m, n)) {
                    int newKleft = cur.kleft - grid[nX][nY];
                    Cell nCell = new Cell(nX, nY, newKleft, cur.step + 1);
                    // remaining quota must be >= 0, then new state can be added
                    if (newKleft >= 0 && !visited.contains(nCell)) {
                        queue.add(nCell);
                        visited.add(nCell);
                    }
                }
            }
        }
        return -1;
    }
}