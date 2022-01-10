### Thinking

**Solution MST(Kruskal's algo)**
- <u>Djikstra's algo vs Kruskal's algo</u>
  - `Djikstra (Greedy)` - **[Single Source V Shortest Path]**
    - heap based **PQ** `O(ElogV)`
    - both directed & undirected
    - may not correct for `weight < 0`
  - `Kruskal (Greedy)` - **[MST: Min Spanning Tree]**
    - union-find based
    - shortest from <u>any vertexes</u> in the current MST
    - can work for disconnected graph
    - **superior**: apply path compression + rank-based `O(Elog^* V)`
- Key process: 
  - sort edge based on `weight`
  - each step
    - find the smallest edge, if no cycle formed so far, add to MST
  - repeat until `V - 1` edges are added