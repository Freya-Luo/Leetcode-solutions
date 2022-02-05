### Thinking
**Solution - Djikstra's ALgo**
###### Note
- `int[] dist` to keep track of the current dist on each node to validate the relaxing edge 
- `seen set` checking logic should be done when the curnode is <u>popped out from the pq</u>
  - <u>at this time</u>, curnode is guaranteed to have the **shortest distance** from `src` to it -- marked as `DONE`
  - if `seen.add()` after `pq.offer()`, it's may have shorter options later -> WRONG!