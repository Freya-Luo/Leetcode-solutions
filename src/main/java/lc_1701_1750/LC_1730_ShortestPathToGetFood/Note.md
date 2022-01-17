### Thinking
- Why BFS not DFS?
  - DFS can also be applied, but is inefficient. 
    - need to explore all the food paths and keep track of the shortest path separately
- Using 3rd entry to record the `level/step` info, instead of doing `deque.size() & 2nd while loop`
- MUST: remove the **visited** cell
  - either `visited[][]`
  - or make it to `X` wall