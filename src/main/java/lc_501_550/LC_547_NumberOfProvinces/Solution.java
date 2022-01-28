package lc_501_550.LC_547_NumberOfProvinces;

class Solution {

    private void dfs(int[][] grid, int x, boolean[] visited) {
        for(int next = 0; next < grid.length; next++) {
            if (!visited[next] && grid[x][next] == 1) {
                visited[next]= true;
                dfs(grid, next, visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        int total = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                total++;
            }
        }
        return total;
    }
}