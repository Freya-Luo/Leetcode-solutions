### Thinking
**Solution - DFS**
- Logic:
  - to make it to return the smallest path, <u>sort the adjacent edges</u> when building the graph
  - NOTE
    - DFS edges instead of vertices
    - SO, `usedTickets` manipulation should inside the for loop => corresponding to the edge
      - otherwise, outside would indicate the vertex
  - Backtracking - `it's guaranteed that 1 path exists`
    - brute force search: when this picked path has exhausted, but not all edges have been used, we need to backtrack to exploit every possible solutions
    - BUT, since we sort it first, the 1st time `usedTickets == N`, it's guaranteed to be the smallest path

**Solution - Eulerian Path**
- Logic: [ref](http://www.graph-magics.com/articles/euler.php)
  - visit each edge exactly once
  - Algo:
    ```markdown
    - stack[] & path[]
      - all `V`s even degree - pick anyone
      - exactly 2 `V`s with odd edge - pick 1 of them
      - otherwise, no Eulerian Path
    - if cur node has no neighbors 
      - `path.add(cur)` & set `cur = stack.pop()`
    - else 
      - `stack.push(cur)` & remove any neighbor `n`
       - `cur = n`
    - repeat step 2 until `cur.neighbors.size() == 0 && stack.isEmpty()`
    ```
  - `it's guaranteed that 1 path exists` so this question would be slightly different
