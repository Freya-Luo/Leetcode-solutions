### Thinking
**Solution- DFS**
###### Note
- if multiple sub-graph can exist, _loop through each node_ and `dfs()` on the **non-visited node** to collect results
- visited and partition check can be done at the same time
  - either check on current node `pre-check before loop neighbors` or next node `inside loop that goes through each neighbor` is feasible


**Solution- BFS**
###### Note
- multiple sub-graph => _loop through each node_ and `bfs()` on the **non-visited node** to collect results
- `if (groups[next] == group) return false;` **must before** non-visited node checking - `if (groups[next] != 0) continue;`
  - WHY?
    - if `continue` first, validity may not be able to detected
    - Also, they cannot combine as `if (groups[next] != 0) return groups[next] != group`: too early to return (`stupid logic :-(`)