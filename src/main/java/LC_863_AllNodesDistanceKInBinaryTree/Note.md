### Thinking
- remind: 1st is obvious - find the `target` node 
    - either BFS / DFS
- Key:
  - 2 cases:
    - case 1: nodes that are childern of `target`
      - <u>normal DFS</u> can solve
    - case 2: nodes that are ancestors or siblings of `target`
      - need some `val` to add while traversing
  - WHAT is `val`?
    - thinking the 1st post-order traversal as the pre-configuration step
      - give all nodes `(a.k.a: all ancestors including itself)`in the path `root -> target` an initial value
      - `val` -- distance from current node to the `target`
    > when DFS, if the node is an ancestor, using the `pre-configured` value instead; otherwise, it is just using DFS to find
    the node's depth;  
    => trick: instead of root be `depth 0`, let target be `depth 0`
    