package lc_851_900.LC_864_ShortestPathToGetAllKeys;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private class State {
        int x, y, keys, moves;

        State(int x, int y, int keys, int moves) {
            this.x = x;
            this.y = y;
            this.keys = keys;
            this.moves = moves;
        }

        @Override
        public boolean equals(Object obj) {
            State o = (State) obj;
            return o.x == this.x && o.y == this.y && this.keys == o.keys;
        }

        @Override
        public int hashCode() {
            int res = x * 31 + y;
            return res * 31 + keys;
        }

    }
    private boolean isValid(String[] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length()
                || grid[x].charAt(y) == '#')
            return false;
        return true;
    }
    // Time: O(2^k * N^2), N: grid.length
    // Space: O(2^k * N^2)
    public int shortestPathAllKeys(String[] grid) {
        int n = grid.length;
        int sx = -1, sy = -1, keysCnt = 0;
        for(int i = 0; i < n; i++) {
            String cur = grid[i];
            for(int j = 0; j < cur.length(); j++) {
                char c = cur.charAt(j);
                if (c == '@') {
                    sx = i;
                    sy = j;
                } else if (c >= 'a' && c <= 'f') {
                    keysCnt++;
                }
            }
        }
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        Deque<State> deque = new ArrayDeque<>();
        Set<State> seen = new HashSet<>();

        deque.offer(new State(sx, sy, 0, 0));

        int moves = 0;
        while (!deque.isEmpty()) {
            State cur = deque.poll();

            if (cur.keys == ((1 << keysCnt) - 1)) {
                return cur.moves;
            }

            int x = cur.x, y = cur.y, keys = cur.keys;
            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (!isValid(grid, nx, ny)) continue;
                char nc = grid[nx].charAt(ny);

                int nkeys = keys;

                if (nc >= 'a' && nc <= 'f') {
                    nkeys = keys | (1 << (nc - 'a'));

                } else if (nc >= 'A' && nc <= 'F'
                        && (nkeys & (1 << (nc - 'A'))) == 0) continue;

                State newState = new State(nx, ny, nkeys, cur.moves + 1);
                if (!seen.contains(newState)) {
                    deque.offer(newState);
                    seen.add(newState);
                }

            }
        }
        return -1;
    }
}