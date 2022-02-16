### Thinking
**Solution - DP**
- Logic:
  - loop all the way up to `n`, store the square numbers & directly fetch from `dp[i - k * k]`
  
**Solution - BFS**
- Logic:
  - graph consists of all the nodes from `0 ... n`
  - for each node `u`, its neighbor `v` satisfy the equation that `v = u + (a perfect square num)` or `u = v + (a perfect square num)` -- Undirected Edge!
  - starting from `0`, when reach to `n`, the steps `curlevel` would be the least no.of perfect square numbers to sum to `n`
####### Note
  - BFS logic usually `seen.add(initState)` before BFS, and during the searching
    - check `if (!seen.contains(next) && ...) {/*.... */ seen.add(next) }`