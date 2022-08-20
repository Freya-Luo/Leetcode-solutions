package lc_251_300.LC_289_GameofLife;

// Time: O(mn); Space: O(1)
class Solution {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    private int countNeighbors(int x, int y, int[][] board) {
        int cnt = 0;
        for(int[] dir: dirs) {
            int nX = x + dir[0];
            int nY = y + dir[1];

            if (nX < 0 || nX >= board.length || nY < 0 || nY >= board[0].length) {
                continue;
            }
            if (board[nX][nY] == 1 || board[nX][nY] == -1) {
                cnt += 1;
            }
        }
        return cnt;
    }

    // neighbors = 2, 3; < 2 or > 3 is dead
    // -1: means the cell is supposed to be dead
    // 2: means the cell is supposed to be reproduced
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        // calculate the board status
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int cnt = countNeighbors(i, j, board);
                if (board[i][j] == 1 && (cnt < 2 || cnt > 3)) {
                    board[i][j] = -1;
                } else if (board[i][j] == 0 && cnt == 3) {
                    board[i][j] = 2;
                }
            }
        }
        // convert the board simultaneously
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == -1) board[i][j] = 0;
                else if (board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
}
