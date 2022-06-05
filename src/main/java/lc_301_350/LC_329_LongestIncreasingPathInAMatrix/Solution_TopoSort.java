package lc_301_350.LC_329_LongestIncreasingPathInAMatrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Directed acyclic graph to find the longest path.
 * Kah's algo to implement topological sort && using level to get the longest chain of nodes.
 * But we first need to first construct the graph, which is pre-required to use topo sort
 * as a collection of nodes with 0 indegree is necessary.
 *
 * So, Time: O(V + E) = O(2mn + 2 * 4mn); Space: O(2mn)
 */
class Solution_TopoSort {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private int[][] indeg;

    private void buildGraph(int[][] mat, int m, int n) {
        // build the indegree of each node
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                for(int[] dir : dirs) {
                    int nX = i + dir[0];
                    int nY = j + dir[1];

                    if (nX < 0 || nX >= m || nY < 0 || nY >= n) continue;
                    if (mat[nX][nY] < mat[i][j]) {
                        indeg[i][j] += 1;
                    }
                }
            }
        }
    }

    public int longestIncreasingPath(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        indeg = new int[m][n];

        buildGraph(mat, m, n);

        // do topological sort
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (indeg[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // set of nodes with 0 indegree
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] vtx = queue.poll();
                for(int[] dir : dirs) {
                    int nX = vtx[0] + dir[0];
                    int nY = vtx[1] + dir[1];

                    if (nX < 0 || nX >= m || nY < 0 || nY >= n) continue;
                    if (mat[nX][nY] > mat[vtx[0]][vtx[1]]) {
                        indeg[nX][nY] -= 1;
                        if (indeg[nX][nY] == 0) {
                            queue.add(new int[]{nX, nY}); // will be next level 0's indegree node
                        }
                    }
                }
            }
            level += 1; // no matter which starting node can reach to the furthest level
        }
        return level;
    }
}
