### Thinking

###### Difference vs LC 200 "Number of Islands"
- Frankly, the members of a circle don't to be all connected
- Specifically, 
  - In 200
    - number of "nodes" = row * col cells
    - each edge is represented as 2 consecutive `1` in the adjacent cells
    - need to check each cell
  - In this
    - NxN matrix but only N friends
    - each edge is represented as `1` in the cell
    - need to traverse a row, or say N friends