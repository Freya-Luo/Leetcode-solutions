### Thinking
**Solution - BFS w/ Bitmask**
- Logic:
  - BFS guarantees the shortest path in **unweighted** graph, as soon as finding the answer, it is the **optimal one**
  - HOW to define the **state** `must be unique: once we encounter the same state, we know it's duplicate`?
    - **curnode value + record of the visited nodes** => guarantee to be the unique state
      - `curmoves` should not be considered, otherwise infinite loop
    - _TLE? using Bit Mask_
      - bitmask: `00001111` each bit if it's set indicates the `ith` node has seen
      - when `bitmask == ((1 << n) - 1) (n 1 bits)`, it means all nodes have been seen
      - when setting the `ith` bit, use `prevmask |= (1 << i)`