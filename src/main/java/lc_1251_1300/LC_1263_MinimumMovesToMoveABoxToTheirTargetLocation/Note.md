### Thinking
**Solution - BFS(nested)**
- Logic:
  - check if the box can be shifted to the new position `(nbx, nby)` - BFS
  - based on this, if the player can move to the `pushing` position - another BFS
  - for current box position `(bx, by)`
    - for each direction `dir[]`
      - get the possible new box position `(bx + dir[0], by + dir[1])`
      - to make the box be pushed, the player has to be `(bx - dir[0], by - dir[1])`
        - SO, check if player can move from `(px, py)` to be above position
          - rule out the old box position `(bx, by)`
- Note
  - for a valid box move, **both box & player position** need to be recorded into `seenStatus`
    - as box must be **pushed** by the player
  - for a valid player move, **player his own** position need to be recorded
  - tell the difference between `(opbx, opby)` & `(bx, by)`, which are the player's position right before and after "pushing"
