### Thinking
**Solution - Direct Thinking**
- Logic
  - Djikstra's Algo
    - used to find all the reachable nodes
    - ALSO, keep track of how much times the edge is used
    - then, the total nodes would be `sum(edge used time) + no.of ori nodes can be reached`
  - `dist[i]` to record the shortest distance for each node
    - Also, it marks the `seen/visited` nodes
###### Note
  - Typical Djikstra Algo
  ```js
  // seudo code
  function dijkstra(G, S)
    for each V in G
      distance[V] = infinite
      pathfrom[V] = NULL
      If V != S, add V to PQ
      distance[S] = 0

      while PQ IS NOT EMPTY
        U = Extract MIN from PQ
        for each unvisited neighbour V of U  // can use dist[]/pathfrom[] to check if it's seen
          temp = distance[U] + edge_weight(U, V)
          if temp < distance[V]
            distance[V] = temp
            pathfrom[V] = U
      return distance[], pathfrom[]
  ```
  - In my solution - `usually the way I'm doing`
    - `int[]` in PQ, which represents `<curnode, curdist>`, where `curdist` stores the <u>non-optimized distance</u>
    - `dist[i]` to store the shortest path for node `i`
       - init as `-1`, so to check if the node is seen
       - when **setting `dist[i]`** to some value, **this value is guaranteed to be the shortest** distance from this `src` to this node
         - then, <u>after</u> this step, we can <u>safely mark</u> `curndoe` as `seen`
    - variants of Djikstra
      - not just find each node's shortest distance, but some `sum` with constraints
    - BUT:
      - this way, `PQ` may take more space as the same `curnode` might be offered into `PQ` multiple times with differ `curdist`
  
**Solution - Reverse Thinking**
- Logic: - `PQ order should also be reversed`
  - instead of storing each node's shortest distance, storing the `leftMoves` this node can take
    - a.k.a, how far/many nodes the current node can reach to/spawn 
  - then, for each edge
    - take each end for the current edge, `f(i) = min(distSpawnFromNode1 + distSpawnFromNode2, weight[i])` would be the nodes that can be reached along this edge
  - SO, the total would be `sum(f(i)) + no.of ori nodes can be reached`