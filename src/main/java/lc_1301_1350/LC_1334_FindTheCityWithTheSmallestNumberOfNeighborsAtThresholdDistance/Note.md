### Thinking
**Solution - Floyd**
> Pick one by one pick all vertices and updates all shortest paths which include the picked vertex as **an intermediate vertex** in the shortest path  
 => Algo purpose: find the shortest path between **all pairs of nodes**
- Logic: - [article](https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/) && [video](https://www.youtube.com/watch?v=4OQeCuLYj-4)
  - when considering if including the current `k` node as the intermediate node
    - if `dist[i][k] + dist[k][j] < dist[i][j]` => update `dp[i][j]`, which means this `k` is an effective intermediate node between `i & j`
    - else do nothing
    - WHY this work?
      - because before dealing with `k`-th node, we have already checked `0, 1, ..., k-1` nodes
  - steps:
    - init `dist[][]` with `Integer.MAX_VALUE`, all `dist[i][i] = 0`
    - fill in `dist[][]` with the given edges `[i, j] = [j, i] = weight`
      - NOTE: has to do the bidirectional thing for unweighted graph as `i, j, k` are not ordered
    - then
      ```markdown
      for k in range n
        for i in range n
            for j in range n
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
      ```
**Solution - Dijkstra**
###### Note
  - typical Dijkstra Algo, treating each `V` as the source and loop `V-1` times
  - Time complexity _for 1 node should be `O(ElogV)`_, E: total edges in the graph
    - then, for loop `V-1` times, big O: `O(V * ElogV)`
    - `1 <= edges.length <= n * (n - 1) / 2` => **O(V^3 * logV)**
    - SO, this case, Dijkstra's Algo would be slower than Floyd's Algo