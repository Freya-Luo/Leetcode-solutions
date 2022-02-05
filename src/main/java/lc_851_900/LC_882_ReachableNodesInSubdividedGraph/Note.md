### Thinking
**Solution - Direct Thinking**
- Logic
  - Djikstra's Algo
    - used to find all the reachable nodes
    - ALSO, keep track of how much times the edge is used
    - then, the total nodes would be `sum(edge used time) + no.of nodes can be reached`
  - `dist[i]` to record the shortest distance for each node
    - Also, it marks the `seen/visited` nodes
###### Note
  - 