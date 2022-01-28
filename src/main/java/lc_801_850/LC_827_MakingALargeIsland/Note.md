### Thinking
- Notice that a cell in the initial `grid[][]` can only be `0` or `1`, so I use `2 ~ n` to label each cell belonging to the current island, which can be done by DFS.
    - `0`: water
    - `1`: not visited land
    - `2 ~ n`: visited land with label
- When looping through each `0` cell, keep a Set `explored` to avoid the same island to be connected more than once.