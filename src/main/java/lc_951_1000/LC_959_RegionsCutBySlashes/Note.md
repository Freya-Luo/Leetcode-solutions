### Thinking
**Solution - DFS**
> Upscale the grid to be the 3N *3N size, then the problem would downgrade to LC.200  

- Logic
  - WHY scale?
    - to visualize it properly, the question needs us to find the area that can be divided by the slash
    - but either `'/' or '\\'` would take the whole space of 1 square
    - SO, question becomes how to represent the space between slashes?
      - scale the square up / divide the square into multiple pieces
      - THUS, the area in between is created by keeping the same ratio / relative positions  
  - WHY 3*N not 2*N or 4*N?
    - consider 1 simple case `["//"," /"]` and if it's scaled up by 2, then the graph:
      ```markdown
        0 1 0 1
        1 0 1 0
        0 1 0 0
        1 0 0 0
      ```
      - the `0`s in the middle level is counted incorrectly, as we can only go 4 directions
      - those `0`s are counted separately => 3 instead of 1
    - same case, but if it's scaled up by 3
      ```markdown
        0 0 1 0 0 1
        0 1 0 0 1 0
        1 0 0 1 0 0
        0 0 1 0 0 0
        0 1 0 0 0 0
        1 0 0 0 0 0
      ```
      - SO, to make sure the area is correctly counted, at least one of X and Y dimensions needs to be expanded
    - and 3*N would be sufficient, 4*N to expand both X and Y axes is not necessary