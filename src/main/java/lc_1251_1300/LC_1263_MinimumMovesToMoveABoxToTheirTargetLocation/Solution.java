package lc_1251_1300.LC_1263_MinimumMovesToMoveABoxToTheirTargetLocation;

import java.util.*;

class Solution {
    private int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private boolean isValid(char[][] grid, int x, int y) {
        int n = grid.length, m = grid[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == '#')
            return false;
        return true;
    }

    // Returns true if the player can move to the new position without acrossing the box
    private boolean canPlayerMove(char[][] grid, int[] oriPlayer, int[] newPlayer, int[] box) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(oriPlayer);
        Set<List<Integer>> visited = new HashSet<>();

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            if (cur[0] == newPlayer[0] && cur[1] == newPlayer[1]) return true;

            for(int[] dir : dirs) {
                int npx = cur[0] + dir[0], npy = cur[1] + dir[1];
                // player cannot stand on the box /across it
                if (npx == box[0] && npy == box[1]) continue;

                List<Integer> newPos = Arrays.asList(npx, npy);
                if (isValid(grid, npx, npy) && !visited.contains(newPos)) {
                    visited.add(newPos);
                    deque.offer(new int[]{npx, npy});
                }

            }
        }
        return false;
    }
    // Time: O((mn)^2) -- nested BFS
    // Space: O((mn)^2)
    public int minPushBox(char[][] grid) {
        int n = grid.length, m = grid[0].length;

        int[] box = new int[]{-1, -1}, target = new int[]{-1, -1}, player = new int[]{-1, -1};
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (grid[i][j] == 'B') {
                    box[0] = i;
                    box[1] = j;
                }
                if (grid[i][j] == 'T') {
                    target[0] = i;
                    target[1] = j;
                }
                if (grid[i][j] == 'S') {
                    player[0] = i;
                    player[1] = j;
                }
            }
            if (box[0] != -1 && target[0] != -1 && player[0] != -1) break;
        }

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{box[0], box[1], player[0], player[1]});  // record the box & player position
        Set<List<Integer>> seenStatus = new HashSet<>();  // hashCode() will use elements inside the list

        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();

            while (size-- > 0) {
                int[] cur = deque.poll();

                int bx = cur[0], by = cur[1];  // box current position
                if (bx == target[0] && by == target[1])
                    return level;

                int px = cur[2], py = cur[3];  // player current position

                for(int[] dir : dirs) {
                    int nbx = bx + dir[0];  // new box position
                    int nby = by + dir[1];

                    int opbx = bx - dir[0]; // player new position: opposite direction along which the box moves
                    int opby = by - dir[1];

                    /**
                     * In order to make a new push (only "push" is needed to record at the game level),
                     * old box position will & must be the player new position after finishing this action.
                     *
                     * This (opbx, opby) and (bx, by) should be distinguished:
                     * - (opbx, opby) is the player pos right before doing action, we need to pre-check if the player can move
                     * to this pos to do the "push" action
                     *    - HOWEVER, when checking, we need use "current box pos" to avoid player across/stand on the box
                     * - (bx, by) is the player pos after pushing position, we need to record it as the status to avoid
                     * future repetition.
                     */
                    List<Integer> newlist = Arrays.asList(nbx, nby, bx, by);
                    if (isValid(grid, nbx, nby)
                            && !seenStatus.contains(newlist) // this position combination has not achieved yet
                            // <player old pos, player new pos (before push), box position>
                            && canPlayerMove(grid, new int[]{px, py}, new int[]{opbx, opby}, new int[]{bx, by})) {
                        seenStatus.add(newlist);
                        deque.offer(new int[]{nbx, nby, bx, by});
                    }
                }
            }
            level++;
        }
        return -1;
    }

}