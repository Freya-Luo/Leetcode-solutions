### Thinking
**Solution-DP (DFS?)**
- This is also like a version of DP using `HashMap` instead of `2D-Array`
- Key: store a set of all the failed jump units associated with stone s -- `<Stone s, Set<failed jumps>>`
- Logic: can also a way of DFS
  - **!!** important terminating condition: `jump <= 0`
  - check all the `k-1, k, k+1` possibilities at jump `k`
    - then, if all fail, add this failed jump unit `k` to the stone `s`
  > Time Analysis:   
  > O(N^2) from my perspective:  
  > DFS complexity can be decided by the combinations of dfs params  
  >   => so, `nextStone & (jump + i)` => `(jump + i + curStone) & (jump + i)` => `(2n) & n` => `2n^2`


**Solution-DP**
- Key: forward direction, which means frog can only jump to this stone `s` from `[0: s-1]`
- Logic: construct `dp[s][j]`  
  - `dp[s]` means the stones `s`: flags all the next jump sizes at `s` as whether they can happen or not
  - `dp[s][j]` means if jump `j` at stone `s` is promising
  - steps:
    - loop all the stones before current stone `s` & cal the `gap` between them
    - check `stone[j][gap]` is doable
      - if `true`, which means frog can jump `gap` unit from stone **J** 
        - also, it can choose to jump `gap - 1` or `gap + 1`
        - label them all as `true` with stone **S**
      - if `false`, then this path is unreachable
      - if `s` reaches the last stone, just return true => path has been found