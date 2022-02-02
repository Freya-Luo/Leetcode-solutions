### Thinking
**Solution - Union Find**
- Logic:
  - the overall situation can be divided into **3 cases**:
    - case 1: has a cycle, return the edge causing the cycle
    - case 2: a node has 2 parents
      - case 2.1: return the 2nd edge causing the duplicate edges
      - case 2.2: return the `{u1, v}` or `{u2, v}` causing the loop
- Step:
  - 1st, check all the node and find the one <u>having 2 parents</u>
    - if exists, remove the latest one `possibleE2`, e.g. just labeling it
      - and record both 2 edges as `possibleE1` & `possibleE2`
  - 2nd, do the union find `just as LC 684` to <u>detect a cycle</u>
    - if a cycle detected
      - if possible candidate edges exist, which means removing 2nd edge `possibleE2` has no effect. Then it should be the 1st edge `possibleE1` forming the cycle
      - if they do not exist, then just return the current edge
    - if not detecting a cycle
      - just return the duplicate `possibleE2`