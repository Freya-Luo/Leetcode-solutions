### Thinking
**Solution - DFS**
- Logic:
  - graph coloring but with 4 choices
  - recursively do DFS if the `next` node has not been visited and the `dfs(rest)` is doable
    > The question is similar to coloring the graph with 2 colors, but since we have more choices, simple flipping color is not sufficient to find all the possibilities.  
    Rather, `Backtrack` is used. BUT, it's not fully backtrack because the problem guarantees to have at least one way to color the graph.  
  
  - Similarly, though do not need to backtrack, the logic is still applied here for practice
  - NOTE
    - `Set` is not needed =>  no real backtrack, `!dfs()` will not achieve
    - `List<Integer>[] graph` when initialize, must do `new ArrayList<>()` for each `graph[i]`
       - `Arrays.fill(graph, new ArrayList<>())` just give **ONLY 1** reference.
    - before DFS next node, need to pre-calculate the type of the current node
      - when coloring, we need to check if any neighbor has the same type with the current node
      - in 2 color cases, `if (colors[next] == color) return false` is right before the `dfs(next)` 
        - _WHY this formula cannot be applied here?_
          - when `if(types[ni] == type)`, we cannot just `return false`, instead, we need to try `next type` in the 4 types
          - so, a `for` loop to select the type is needed => but in side the `for(int next: graph[cur])`? NO
          - actually, `types[cur]` should not be directly assigned
            - <u>selection has constraints at this time!</u> 
            - pre-check its neighbor and find the proper type before doing next DFS
            - REM! No matter DFS or Backtrack, we first have to **ensure the current state is valid (if not, no need to do the rest)**, THEN do DFS recursively
              > This is a point that may be ignored as most DFS / Backtracking problems do not have constraints on selecting the current state value
          
**Solution - Greedy**
###### Problem can be simplified by just greedily assigning each type cuz an answer is guaranteed to exist
- Logic:
  - for each node, just check all the types that have been used by its neighbors
  - then, assign the current node the first available type