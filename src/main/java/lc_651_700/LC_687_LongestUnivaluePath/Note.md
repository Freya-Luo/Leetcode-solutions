### Thinking
**Solution**
- search from bottom to up to construct the `max path`, so post-order traversal is applied
- looking up the tree, there are 2 cases: 
  - case 1: treat the current `node` as a `root`, connect both left & right subtrees
    - side path's length equals to 0 has already been considered into leftLen + rightLen
    - `max` to keep track of the largest edges we get so far
  - case 2: treat the current node as an intermediate, then only one side is allowed
    - pick the larger side