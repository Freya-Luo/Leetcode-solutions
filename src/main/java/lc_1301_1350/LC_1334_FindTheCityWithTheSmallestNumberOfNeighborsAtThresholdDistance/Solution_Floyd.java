package lc_1301_1350.LC_1334_FindTheCityWithTheSmallestNumberOfNeighborsAtThresholdDistance;

import java.util.Arrays;

class Solution_Floyd {
    // Time: O(V^3)
    // Space: O(N^2)
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 10001);
            dist[i][i] = 0;
        }

        for(int[] e: edges) {
            dist[e[0]][e[1]] = dist[e[1]][e[0]] =  e[2];
        }

        for(int k = 0; k < n; k++) {
            for(int src = 0; src < n; src++) {
                for(int des = 0; des < n; des++) {
                    if (dist[src][k] + dist[k][des] < dist[src][des])
                        dist[src][des] = dist[src][k] + dist[k][des];
                }
            }
        }

        int res = 0, smallest = n;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; ++j)
                if (dist[i][j] <= distanceThreshold)
                    ++count;
            if (count <= smallest) {
                res = i;
                smallest = count;
            }
        }
        return res;
    }
}
