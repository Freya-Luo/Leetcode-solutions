### Thinking
**Solution - Djikstra**
- Logic:
  - typical template solution, HOWEVER, here 2 variables should be considered
    - `distance[] & stop[]`
  - Meaning of `PQ` in Djikstra
    - it keeps all the **promising possibilities**
      - the `if (curcost + next[1] < cost[next[0]])` prune the searching steps which can also be omitted, however, would increase the time complexity
        - all the `next` fail this check is guaranteed it cannot lead to the shortest path
    - SO, another aspect - <u>`stop` **must not** be ruled out</u>
      - THEN, what if the condition?
        - if lesser `stop` can be made - although it may be more expensive, but `k` is the dominant constraint
        - `if (curstop + 1 < stop[next[0]])`
      
**Solution - Bellman-Ford**
> Typical solution would iterate all the edges `V - 1` times. The important point is that this algo **guarantees** 
> that after **(k + 1) hops** (levels of edges), it will <u>find the shortest distance</u> for **all nodes that can be reached**
> from the `src` **within a max `k` hops**.

- Logic:
  - In each `ith` loop, we update all the nodes that can be reached with `i` levels/steps
###### Note
  - `if (cost[from] == Integer.MAX_VALUE)` this check should from `cost[]` from last loop
  - the new cost calculation `cost[from] + prices` should also use `cost[]`
  - another `temp[]` is needed within each iteration
  - WHY?
    - when updating the node with `valid` cost/distance, we should keep the record of the previous value
    - without `temp[]`, the prev value would be lost
      > Any values updated in a particular iteration cannot be used to update other values in the same iteration