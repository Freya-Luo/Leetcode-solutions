### Thinking
**Solution -- DFS**
- Logic:
  - brute force: classic "W-G-B" DFS solution
    - mark the node `gray` on entry, and `black` when exit
    - if see a `gray` node during DFS => detect CYCLE!

**Solution - Topological Sort**
- Logic: the **reverse version** of the typical topological sort
  - WHY?
    - <u>a node is safe if all it's outgoing edges are to nodes that are safe</u>
    - SO, node with `0 outdegree` => trace back to other nodes
      - `0 out` should be placed 1st in the topological sort
  - steps:
    - from the node with `0 outdegree`
    - update the nodes that only points to `safe` nodes
    - repeat
- Algo steps:
```
indegree[] = indegrees of each node
HashMap<curnode, Set<Integer>> recording neighbours of cur node
queue = []
for i in indegree:
    if indegree[i] == 0:
        queue.append(i)
		
while !queue.empty():
    cur = queue.poll()
    if (!neighbours.get(cur)) continue;
    for ni in neighbours.get(cur):
        indegree[ni] -= 1
        if indegree[ni] == 0:
            queue.offer(ni)
```