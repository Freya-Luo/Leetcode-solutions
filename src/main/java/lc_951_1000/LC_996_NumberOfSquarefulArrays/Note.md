### Thinking
**Solution-DFS/Bactrack**
- Logic:
  - basically it's a brute force permutation problem 
  - also, duplicates might appear
  - SO, how to <u>reduce the redundant sqrt calculation</u>?
    - 1st, to **solve duplicates**, using `count` map to store each number's occurrence
    - 2nd, to **solve repetitive computation**
      - using _`count` map,_ which contains only unique numbers to loop through instead of `nums` directly
      - then, using _`set` to keep track of what combinations_ will lead to the perfect square
    - THUS, by doing these steps, a `simplified graph` is constructed
      - `graph` only includes the unique edges
      - `count` will spawn edges in the graph
      - NOW, any edge in the graph is a valid combination (sum of 2 endpoints) 
      - **question becomes: `find the number of paths that can visit all Nodes`**
        - since permutations, we can have `N` sources, so starting from each vertex to do DFS