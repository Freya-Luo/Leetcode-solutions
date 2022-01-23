### Thinking

**Solution - Without Memo**
- Logic: dynamically keep 2 vars `(as usual in typicall DP)`
  - `robRoot & notRobRoot`, and record them in `int[]`
  - but without `memo`, we need to repetitively compare `child & grandchild` of each node

**Solution - With Memo**
- DP-like solution
- Logic: 
  - use a `Map` to store `<Node, maxSoFar>` pair
  - At each node, just 1 comparison

> Though these two have a slim difference in runtime, they are both `O(n)`  
- 2 cases: `Dependent on what DFS recursion returns`
  - case 1: choose current node, then omit `left & right` children
    - check its grandchildren
  - case 2: not choose current node
    - select the `max value` between 1) include `cur.left / cur.right` subtree 2) not include `cur.left / cur.right` subtrees
    - or just do `dfs(cur.left) + dfs(cur.right)`