### Thinking
> An edge is not a critical edge if it's not in the cycle  

**Solution - RemoveNonCritical** -- `Tarjan's Algo`
- Logic:
  - `lowdist[i]`: represents the distance to the starting node `0`
  - WHEN to remove?
    - when you search for the `next` node, if `lowdist[next] < curdist` => a CYCLE!
      - avoid considering the ordering, just remove the 2 edges `(from, to)` & `(to, from)`
  - HOW?
    - dfs returns the `mindist` found from the next layer
      - a.k.a `dfs(v) < lowdist[u]` => `u` knows its neighbor `v` finds a path back to `u` or ancestor's of `u` (smaller distance)
      - SO, `(u, v)/(v, u)` can be discarded  

**Solution - AddCritical**
- Logic: 
  - the same logic of the above methods, but instead of taking the `Set(connections)`, directly add to the `res`
  - NOTE
    - `lowdist[cur] = Math.min(lowdist[cur], lowdist[next]);` **cannot write** as `min(curdist, lowdist[next])`
      - read its value after `dfs()` call, `lowdist[cur]` might have been changed during the above `dfs()`
        - a.k.a `lowdist[cur]` may update to the value of its closest node to src `0`
---
> From Tarjan's Algo:  
> `low[u]` indicates earliest visited vertex (the vertex with minimum distance to src) that can be reached from the subtree `u` belongs to